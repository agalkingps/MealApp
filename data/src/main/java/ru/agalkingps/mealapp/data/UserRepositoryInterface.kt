package ru.agalkingps.mealapp.data

import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import ru.agalkingps.mealapp.data.model.Order
import ru.agalkingps.mealapp.data.model.User

interface UserRepositoryInterface {
    suspend fun addUser(user: User) : Long
    suspend fun updateUser(user: User) : Int
    suspend fun deleteUser(user: User) : Int
    suspend fun deleteAllUsers() : Int
    suspend fun getAllUsers() : Flow<List<User>>
    suspend fun getUserById(id: Int): User?
    suspend fun getUserByEmail(email: String): User?
    suspend fun getUserByIdWithOrders(userid: Int): Map<User, List<Order>>
    suspend fun addOrder(user: User, order: Order) : Long

    fun justTest() : Unit
}