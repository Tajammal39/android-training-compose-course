package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }

}

//@Preview(showBackground = true)
@Composable
private fun MyApp() {
    val value1 = remember {
        mutableStateOf("")
    }

    val value2 = remember {
        mutableStateOf("")
    }

    val result = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        OutlinedTextField(value = value1.value, onValueChange = {
            value1.value = it
        }, modifier = Modifier.fillMaxWidth())

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = value2.value,
            onValueChange = { value2.value = it },
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(onClick = {  result.value =
                (value1.value.toDouble() + value2.value.toDouble()).toString()
            }) {
                Text(text = "+")

            }
            Button(onClick = {  result.value =
                (value1.value.toDouble() - value2.value.toDouble()).toString()
            }) {
                Text(text = "-")

            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(onClick = {   result.value =
                (value1.value.toDouble() * value2.value.toDouble()).toString()
            }) {
                Text(text = "*")

            }
            Button(onClick = {   result.value =
                (value1.value.toDouble() / value2.value.toDouble()).toString()
            }) {
                Text(text = "/")

            }
        }
        if (result.value.isNotEmpty())
            Text(text = "the result is ${result.value}")
    }
}

