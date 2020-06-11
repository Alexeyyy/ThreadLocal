package context

import java.util.*
import kotlin.collections.ArrayList

/*
* Модель пользователя.
* Например, такие данные могут храниться в базе данных.
* При логине в систему создается профиль пользователя, эти данные отправляются пользователю в виде html-странички.
* */
class User {
    var id: Int = 0
    var name: String = ""
    var age: Int = 0
    var interests: ArrayList<String> = arrayListOf()

    constructor(id: Int, name: String, age: Int, interests: ArrayList<String>) {
        this.id = id
        this.name = name
        this.age = age
        this.interests
    }
}