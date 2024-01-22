package com.example.mobilecomputingseveri

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import com.example.mobilecomputingseveri.R

import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobilecomputingseveri.ui.theme.MobileComputingSeveriTheme
import androidx.compose.material.Text
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "LogIn") {
                composable("LogIn") {
                    UserBox(navController)

                }
                composable("MainMenu") {
                    MainMenu(navController)
                }
            }
        }
    }
}
@Composable
fun UserBox(navController: NavController) {
    var text by remember { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    Row{
        Spacer(modifier = Modifier.width(60.dp))
        Column {
            Row {
                Spacer(modifier = Modifier.width(40.dp))
                Image(
                    painter = painterResource(R.drawable.ste_mariacorrection),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(200.dp)

                )
            }
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = {Text("Username")}
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = {Text("Enter password")}
            )
            Button(onClick = {
                navController.navigate("MainMenu")
            }
            ){
                Text(text = "Log In")
            }
                    
                }
            }
        }




