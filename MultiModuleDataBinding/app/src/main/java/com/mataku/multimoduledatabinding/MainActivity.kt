package com.mataku.multimoduledatabinding

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mataku.core.databinding.ActivityWebviewBinding
import com.mataku.core.R as coreR

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityWebviewBinding =
            DataBindingUtil.setContentView(this, coreR.layout.activity_webview)
        val webView = binding.activityWebviewContent
        webView.loadUrl("https://google.com")
        Thread.sleep(5000)
        val intent = Intent(Intent.ACTION_VIEW).also {
            it.setClassName(
                "com.mataku.multimoduledatabinding",
                "com.mataku.dynamicfeature.DynamicFeatureWebviewActivity"
            )
        }
        startActivity(intent)
    }
}
