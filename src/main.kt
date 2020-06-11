import context.User
import context.UserSession

fun main(args: Array<String>) {
    var alex = UserSession(1)
    //var ivan = UserSession(2)
    var vladislav = UserSession(1)


    var alexThread = Thread(alex).start()
    //var vladislavThread = Thread(vladislav).start()
    //var ivanThread = Thread(ivan).start()
}