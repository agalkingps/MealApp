package ru.agalkingps.mealapp.login_flow

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation

fun NavGraphBuilder.loginGraph(navController: NavController) {
    navigation(startDestination = "loginScreen", route = "login") {
        composable(route = "loginScreen") {
            LoginScreen(
                onClickLoginButton = {
                },
                onClickSignInButton = {
                }
            )
        }
        composable(route = "signInScreen") {
            SignInScreen(
                onClickSignInButton = {
                }
            )
        }
    }
}
