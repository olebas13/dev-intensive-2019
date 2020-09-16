package ru.skillbranch.devintensive

import org.junit.Test

import org.junit.Assert.*
import ru.skillbranch.devintensive.extensions.TimeUnits
import ru.skillbranch.devintensive.extensions.add
import ru.skillbranch.devintensive.extensions.format
import ru.skillbranch.devintensive.extensions.toUserView
import ru.skillbranch.devintensive.models.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
        val user2 = User("2", "Oleg", "Nevoyt")
    }

    @Test
    fun test_factory() {
        val user = User.makeUser("Oleg Nevoyt")
        val user2 = user.copy(id = "2", lastName = "Gykach", lastVisit = Date())
        println("$user\n$user2")
    }

    @Test
    fun test_decomposition() {
        val user = User.makeUser("Oleg Nevoyt")
        fun getUserInfo() = user

        val (id, firstName, lastName) = getUserInfo()

        println("$id $firstName $lastName")
        println("${user.component1()} ${user.component2()} ${user.component3()}")
    }

    @Test
    fun test_copy() {
        val user = User.makeUser("Oleg Nevoyt")
        var user2 = user.copy(lastVisit = Date().add(-2, TimeUnits.SECOND))
        var user3 = user.copy(lastName = "Olebas", lastVisit = Date().add(2, TimeUnits.HOUR))

        println("""
            ${user.lastVisit?.format()}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}
        """.trimIndent())
    }

//    @Test
//    fun test_data_mapping() {
//        val user = User.makeUser("Олег Невойт")
//        println(user)
//
//        val userView = user.toUserView()
//
//        userView.printMe()
//    }

    @Test
    fun test_abstract_factory() {
        val user = User.makeUser("Олег Невойт")
        val textMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any text message", type = "text")
        val imgMessage = BaseMessage.makeMessage(user, Chat("1"), payload = "any image url", type = "image")

        println(textMessage.formatMessage())
        println(imgMessage.formatMessage())
    }
}