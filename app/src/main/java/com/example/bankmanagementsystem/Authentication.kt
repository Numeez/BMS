package com.example.bankmanagementsystem

import com.google.gson.Gson


class Authentication {
    fun auth( Mail:String, Password:String) :Boolean {
        val user = Gson().fromJson(userFile.readText(), UserModel::class.java)
        val mail = user[0].mail
        val password = user[0].password
        if(Mail==mail && Password==password){
            return true
        }
        return false

    }

}