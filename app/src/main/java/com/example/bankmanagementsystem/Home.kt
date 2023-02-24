package com.example.bankmanagementsystem

class Home{
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
        home()

    }

    fun accountManagement(){
        println("Account Management")
        home()

    }

    fun logout(){
        println("logout")
        login()

    }

    fun exit(){
        println("Exit")


    }
}
