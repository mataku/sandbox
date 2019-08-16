package com.mataku.dynamicfeature.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mataku.dynamicfeature.R
import com.mataku.dynamicfeature.databinding.ActivityOnDemandBinding

class OnDemandActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityOnDemandBinding>(
            this,
            R.layout.activity_on_demand
        )
        binding.activityOnDemandWebview.loadUrl("file:///android_asset/licenses.html")
    }
}