package com.mataku.kspsample.ui.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mataku.kspsample.ui.theme.KspSampleTheme

@Composable
fun Header(modifier: Modifier = Modifier) {
    Text(
        text = "Header",
        modifier = modifier
            .fillMaxWidth()
    )
}

@Preview
@Composable
fun HeaderPreview() {
    KspSampleTheme {
        Surface {
            Header()
        }
    }
}