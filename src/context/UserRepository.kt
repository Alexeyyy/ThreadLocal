package context

import java.lang.Exception

/*
* Класс, имитирующий получение данных из БД или кеша, например.
* */
class UserRepository {
    private var users: ArrayList<User> = arrayListOf(
            User(1, "Vladislav", 24, arrayListOf("films watching", "design", "frontend")),
            User(2, "Ivan", 25, arrayListOf("programming", "car driving", "football")),
            User(3, "Alex", 26, arrayListOf("conference activities", "reading", "programming"))
    )

    fun getUser(id: Int) : User? {
        return try {
            users.first { it.id == id }
        } catch (e: Exception) {
            println("User was not found!")
            null
        }
    }
}