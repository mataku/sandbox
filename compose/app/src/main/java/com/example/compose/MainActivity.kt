package com.example.compose

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.core.Modifier
import androidx.ui.core.setContent
import androidx.ui.foundation.Text
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.padding
import androidx.ui.material.Button
import androidx.ui.material.Divider
import androidx.ui.material.Surface
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import com.example.compose.ui.ComposeTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeApp {
                MyScreenContent()
            }
        }
    }
}

@Composable
fun ComposeApp(content: @Composable() () -> Unit) {
    ComposeTheme {
        Surface(color = Color.Yellow) {
            content()
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeApp {
        MyScreenContent()
    }
}

@Composable
fun MyScreenContent(names: List<String> = listOf("Android", "there")) {
    var counterState = state { 0 }

    Column {
        names.forEach {
            Greeting(name = it)
            Divider(color = Color.Black)
        }
        Divider(color = Color.Transparent, thickness = 32.dp)
        Counter(
                count = counterState.value,
                updateCount = { newCount ->
                    counterState.value = newCount
                }
        )
    }
}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
    Button(onClick = { updateCount(count + 1) }) {
        Text(text = "I've been clicked $count times")
    }
}