package com.example.bankmanagementsystem
import java.io.File
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.google.gson.GsonBuilder

val userFile = File("C:\\Users\\158380\\AndroidStudioProjects\\BankManagementSystem\\app\\src\\main\\java\\com\\example\\bankmanagementsystem\\users.json")
fun main() {
    val user = Gson().fromJson(userFile.readText(), UserModel::class.java)

    if (user.size == 0) {
        register_admin()
    }
    else{
    auth()

    }
}