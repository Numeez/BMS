package com.example.bankmanagementsystem

class TransactionModel: ArrayList<Transaction>()

data class Transaction(
val name:String,
val email:String,
var Balance:Double = 0.0
)

fun transaction_info(name:String,email: String){



}