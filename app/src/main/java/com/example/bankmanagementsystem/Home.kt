package com.example.bankmanagementsystem

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.File


val user = Gson().fromJson(userFile.readText(), UserModel::class.java)

var email=""

fun home(){
     println("HOME")
     println("1>> User Management")
     println("2>> Account Management")
     println("3>> Logout")
     println("4>> Exit")
     println("Select")
     val n:Int = readln().toInt()
     when(n){
         1-> userManagement()
         2-> accountManagement()
         3-> logout()
         4-> exit()


     }
 }
    fun userManagement(){
    println("User Management")
       // admin_logs("Admin entered User Management functionality")
        println("Menu")
        println("1>> Register User")
        println("2>> User Details")
        println("3>> Back")
        val n:Int = readln().toInt()
        when(n){
            1-> registerUser()
            2-> userDetails()
            3-> back()
        }

    }

    fun accountManagement(){
        println("Account Management")
        println("Menu")
        println("1>>Create Account")
        println("2>>Account Details")
        println("3>>Back")
        val n:Int = readln().toInt()
        when(n){
            1->createAccount()
            2->accountDetails()
            3->back()
        }
        //admin_logs("Admin entered Account Management functionality")
        home()

    }

    fun logout(){
        println("logout")
        auth()


    }

    fun exit(){
        println("Exit")


    }


    fun userDetails(){

        val user = Gson().fromJson(userFile.readText(), UserModel::class.java)

        for(i in user){
            println("UserName: ${i.firstName}"+ "${i.lastName}")
            println("Email: ${i.mail}")
            println("Mobile:${i.mobile}")
            println("")
        }
    }

    fun back(){
        home()

    }

    fun createAccount() {
            println("Enter Email of the user")
            val e: String = readln()
            email = e
            val findUser = user.find { it.mail == e }
            if (findUser != null) {
                println("Select Account Type")
                println("1>>Savings")
                println("2>>Current")
                val selection = readln()
                when (selection) {
                    "1" -> "Savings"
                    "2" -> "Current"
                }
                if (selection == "1") {
                    println("Enter balance:")
                    val balance: Double = readln().toDouble()
                    if (balance != null) {
                        val newAcc =
                            Account(id = findUser.id, accountType = selection, balance = balance)
                        findUser.account.add(newAcc)
                        userFile.writeText(GsonBuilder().setPrettyPrinting().create().toJson(user))
                        println("Account Created Successfully.")
                        println("Account Number:${newAcc.id}")
                        println("Balnce:${newAcc.balance}")
                    }
                }
                else {
                        println("Enter balance:")
                        val balance: Double = readln().toDouble()
                        if (balance != null && balance > 5000) {
                            val newAcc = Account(
                                id = findUser.id,
                                accountType = selection,
                                balance = balance
                            )
                            findUser.account.add(newAcc)
                            userFile.writeText(
                                GsonBuilder().setPrettyPrinting().create().toJson(user)
                            )
                            println("Account Created Successfully.")
                            println("Account Number:${newAcc.id}")
                            println("Balnce:${newAcc.balance}")


                        } else
                            println("You can not create current account!!")


                    }
                } else {
                    println("User doesn't exists.")


                }
            }



    fun accountDetails() {


    }


