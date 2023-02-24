package com.example.bankmanagementsystem


    fun login(){
        println("Login")
        println("Enter mail")
        val mail = readln()
        println("Enter password")
        val password = readln()
        if( Authentication().auth(mail,password)){
            home()
        }

    }
