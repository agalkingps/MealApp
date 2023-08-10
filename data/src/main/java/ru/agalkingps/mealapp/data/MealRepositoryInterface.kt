package ru.agalkingps.mealapp.data

import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import ru.agalkingps.mealapp.data.model.Meal

interface MealRepositoryInterface {
    suspend fun getAllMeals(): Flow<List<Meal>>
    suspend fun getMealById(mealId: Int): Meal?
}