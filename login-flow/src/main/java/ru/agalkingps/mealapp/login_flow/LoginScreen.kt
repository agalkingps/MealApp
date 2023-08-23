package ru.agalkingps.mealapp.login_flow

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun LoginScreen(
    onLoginDone: () -> Unit,
    onSignInStart: () -> Unit
) {
    val onClickLoginButton : () -> Unit = {
        onLoginDone()
    }
    val onClickSignInButton : () -> Unit = {
        onSignInStart()
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Login Screen")

        Button(onClick = onClickLoginButton) {
            Text(text = "Login")
        }
        Button(onClick = onClickSignInButton) {
            Text(text = "Sign In")
        }
    }
}

