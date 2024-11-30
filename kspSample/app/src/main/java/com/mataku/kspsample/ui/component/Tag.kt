package com.mataku.kspsample.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mataku.kspsample.ui.theme.KspSampleTheme

@Composable
fun Tag(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .background(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = MaterialTheme.shapes.small
            )
    ) {
        Text(
            text = "Tag"
        )
    }
}

@Preview
@Composable
fun TagPreview() {
    KspSampleTheme {
        Surface {
            Tag()
        }
    }
}