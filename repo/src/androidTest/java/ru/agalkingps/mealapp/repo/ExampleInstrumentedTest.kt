package ru.agalkingps.mealapp.repo

import android.content.Context
import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import ru.agalkingps.mealapp.data.MealRepositoryInterface
import ru.agalkingps.mealapp.data.UserRepositoryInterface
import ru.agalkingps.mealapp.data.model.Meal
import ru.agalkingps.mealapp.data.model.User
import ru.agalkingps.mealapp.repo.database.MealDatabase
import ru.agalkingps.mealapp.repo.database.UserDatabase

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("ru.agalkingps.mealapp.repo.test", appContext.packageName)

        testMealRepo(appContext)

        testUserRepo(appContext)
    }

    private fun testMealRepo(appContext : Context) {
        val repo: MealRepositoryInterface = MealDatabase.getRepository(appContext)

        GlobalScope.launch() {
            val mealList = repo.getAllMeals().collect {
                Log.d("Meal", it.toString())
            }
            val meal: Meal? = repo.getMealById(1)
            if (meal != null) {
                println(meal.toString())
            }
        }
        Thread.sleep(10_000)
    }

    private fun testUserRepo(appContext : Context) {
        val userRepository: UserRepositoryInterface = UserDatabase.getRepository(appContext)

        GlobalScope.launch() {
            val user : User = User(0, "aaa", "gg", "aaag@email.ru")
//            val id : Long = userRepository.addUser(user)
            val user2 : User? = userRepository.getUserByEmail(user.email)
            var i : Int = 0
            i++
        }
        Thread.sleep(10_000)
    }

}

