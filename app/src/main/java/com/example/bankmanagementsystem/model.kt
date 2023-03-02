package com.example.bankmanagementsystem

import java.util.UUID

class UserModel: ArrayList<User>()


data class User(
    val id:String = UUID.randomUUID().toString(),
    val isAdmin:Boolean = false,
    var firstName:String,
    var lastName:String,
    var mail:String,
    var mobile:String,
    val password :String,
    val account:MutableList<Account> = mutableListOf(),

    )

