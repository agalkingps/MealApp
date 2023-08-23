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
fun SignInScreen(
    onClickSignInButton: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("@string/sign_in")
        Button(onClick = onClickSignInButton) {
            Text(text = "@string/sign_in")
        }
    }
}

