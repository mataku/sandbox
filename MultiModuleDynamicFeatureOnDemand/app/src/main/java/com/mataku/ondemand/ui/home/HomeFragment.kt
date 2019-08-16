package com.mataku.ondemand.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import com.google.android.play.core.splitinstall.SplitInstallStateUpdatedListener
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus
import com.mataku.ondemand.BuildConfig
import com.mataku.ondemand.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var manager: SplitInstallManager
    private val moduleOssLicenses by lazy {
        getString(R.string.title_dynamicfeature)
    }
    private var sessionId = 0

    companion object {
        const val ON_DEMAND_CLASS =
            "com.mataku.dynamicfeature.ui.activity.OnDemandActivity"
    }

    private val listener = SplitInstallStateUpdatedListener { state ->

        val names = state.moduleNames().joinToString(" - ")

        when (state.status()) {
            SplitInstallSessionStatus.DOWNLOADING -> {
                Toast.makeText(this.context, "Downloading...", Toast.LENGTH_LONG).show()
            }
            SplitInstallSessionStatus.INSTALLED -> {
                onSuccessfulLoad(names)
            }
            SplitInstallSessionStatus.INSTALLING -> {
                Toast.makeText(this.context, "Installing.....", Toast.LENGTH_LONG).show()
            }

            SplitInstallSessionStatus.FAILED -> {
                Toast.makeText(this.context, "Failed...........", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onResume() {
        manager.registerListener(listener)
        super.onResume()
    }

    override fun onPause() {
        manager.unregisterListener(listener)
        super.onPause()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        manager = SplitInstallManagerFactory.create(this.context)
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(this, Observer {
            textView.text = it
        })
        val button = root.findViewById<Button>(R.id.fragment_home_button)
        button.setOnClickListener {
            loadAndModuleName(moduleOssLicenses)
        }
        return root
    }

    private fun loadAndModuleName(name: String) {
        if (manager.installedModules.contains(name)) {
            Toast.makeText(requireContext(), "Already installed", Toast.LENGTH_LONG).show()
            onSuccessfulLoad(name)
        } else {
            val request = SplitInstallRequest.newBuilder()
                .addModule(moduleOssLicenses)
                .build()
            manager.startInstall(request)
        }
    }

    private fun onSuccessfulLoad(name: String) {
        when (name) {
            moduleOssLicenses -> {
                launchActivity(ON_DEMAND_CLASS)
            }
            else -> {
                Toast.makeText(requireContext(), "$name?????????????", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun launchActivity(className: String) {
        Intent().setClassName(BuildConfig.APPLICATION_ID, className)
            .also {
                startActivity(it)
            }
    }
}