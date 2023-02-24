package com.example.bankmanagementsystem

import java.util.UUID

class UserModel: ArrayList<User>()


data class User(
    val id:String = UUID.randomUUID().toString(),
    val isAdmin:Boolean = false,
    val firstName:String,
    val lastName:String,
    val mail:String,
    val mobile:String,
    val password :String

    )

