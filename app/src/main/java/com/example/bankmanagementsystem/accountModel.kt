package com.example.bankmanagementsystem

import java.util.UUID

data class Account(
    val accountNumber:UUID=UUID.randomUUID(),
    val balance:Double=0.0,
    val accountType:String,
    val id:String=UUID.randomUUID().toString(),
    val isActive:Boolean=true

)
