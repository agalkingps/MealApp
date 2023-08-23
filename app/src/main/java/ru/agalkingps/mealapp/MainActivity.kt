package ru.agalkingps.mealapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import ru.agalkingps.mealapp.data.UserRepositoryInterface
import ru.agalkingps.mealapp.repo.database.UserDatabase
import ru.agalkingps.mealapp.ui.theme.MealAppTheme
import ru.agalkingps.mealapp.login_flow.loginGraph
import ru.agalkingps.mealapp.order_flow.orderGraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val userRepository: UserRepositoryInterface = UserDatabase.getRepository(this.applicationContext)
        userRepository.justTest()

        setContent {
            MealAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val controller = rememberNavController()

                    NavHost(
                        navController = controller,
                        startDestination = "LoginFlow"
                    ) {
                        loginGraph(controller)
                        orderGraph(controller)
                    }
                }
            }
        }

    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

