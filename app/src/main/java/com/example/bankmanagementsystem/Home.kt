package com.example.bankmanagementsystem

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.File

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
        home()

    }

    fun logout(){
        println("logout")
        login()

    }

    fun exit(){
        println("Exit")


    }


    fun userDetails(){

    }

    fun back(){

    }

