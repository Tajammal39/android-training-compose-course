package com.example.loginapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginapp.ui.theme.LoginAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    LoginUi()
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun LoginUi() {
    Log.i("mytag","abc")
    val context = LocalContext.current
    var email = remember {
        mutableStateOf("")
    }

    var password = remember {
        mutableStateOf("")
    }
    Column {
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Welcome to my login system",
            fontSize = 22.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))
        Image(
            painter = painterResource(id = R.drawable.login_image), contentDescription = null,
            modifier = Modifier
                .height(250.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(40.dp))

        OutlinedTextField(
            value = email.value,
            onValueChange = { email.value = it },
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth(), label = {
                Text(text = "E-mail")
            }
        )
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            value = password.value,
            onValueChange = { password.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp), label = {
                Text(text = "Password")
            }
        )

        OutlinedButton(
            onClick = {
                Toast.makeText(
                    context,
                    "You have logged in  successfully",
                    Toast.LENGTH_SHORT
                ).show()

                email.value=""
                password.value=""
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Text(text = "Login", textAlign = TextAlign.Center)
        }
    }
}


