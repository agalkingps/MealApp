package ru.agalkingps.mealapp.repo

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import ru.agalkingps.mealapp.data.UserRepositoryInterface
import ru.agalkingps.mealapp.data.model.Order
import ru.agalkingps.mealapp.data.model.User
import ru.agalkingps.mealapp.repo.dao.UserDao

class UserRepository(private val userDao: UserDao) : UserRepositoryInterface {

    override suspend fun addUser(user: User) : Long {
        return userDao.addUser(user)
    }

    override suspend fun updateUser(user: User) : Int {
        return userDao.updateUser(user)
    }

    override suspend fun deleteUser(user: User) : Int {
        return userDao.deleteUser(user)
    }

    override suspend fun deleteAllUsers() : Int {
        return userDao.deleteAllUsers()
    }

    override suspend fun getAllUsers() : Flow<List<User>> {
        return userDao.getAllUsers()
    }

    override suspend fun getUserById(id: Int): User?
        = userDao.getUserById(id)

    override suspend fun getUserByEmail(email: String): User?
        = userDao.getUserByEmail(email)

    override suspend fun getUserByIdWithOrders(userId: Int): Map<User, List<Order>>
        = userDao.getUserByIdWithOrders(userId)

    @Transaction
    override suspend fun addOrder(user: User, order: Order) : Long {
        if (order.orderedMeal.isEmpty())
            return 0
        order.userId = user.id;
        order.orderedMeal.forEach {
            user.balance += it.price * it.qty
        }
        if (userDao.updateUser(user) == 0)
            return 0
        return userDao.addOrder(order)
    }
    override fun justTest() : Unit {
        GlobalScope.launch() {
            val user: User = User(0, "aaaaa", "gg", "aaaaag@email.ru")
            val id : Long = addUser(user)
            val user2: User? = getUserByEmail(user.email)
            var name : String? = user2?.firstName
            name +=" "
            var i: Long = id
            i++
        }
        Thread.sleep(10_000)
    }
}


