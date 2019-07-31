package com.mataku.dynamicfeature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.mataku.core.databinding.ActivityWebviewBinding
import com.mataku.core.R as coreR

class DynamicFeatureWebviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityWebviewBinding =
            DataBindingUtil.setContentView(this, coreR.layout.activity_webview)
        binding.activityWebviewContent.loadUrl("https://twitter.com")
    }
}
