package context

import storage.MyThreadLocal

class UserSession : Runnable {
    private var userId: Int // Идентификатор пользователя.
    private var localStorage: ThreadLocal<User> // LocalStorage из стандартной java-библиотеки.
    private var myLocalStorage: MyThreadLocal<User> // Собственная реализация класса ThreadLocal.

    constructor(id: Int) {
        userId = id
        localStorage = ThreadLocal()
        myLocalStorage = MyThreadLocal()
    }

    override fun run() {
        var repository = UserRepository()
        var userData = repository.getUser(userId) as User

        localStorage.set(userData)
        localStorage.set(User(0, "test", 10, arrayListOf("1", "2", "3")))
        localStorage.get()
        localStorage.remove()

        /*userData.age = (Thread.currentThread().id).toInt()
        myLocalStorage.set(userData)
        println("Started session for $userId")
        println("Session closed! ${myLocalStorage.get()?.name} of age ${myLocalStorage.get()?.age}, good bye!")*/
    }
}