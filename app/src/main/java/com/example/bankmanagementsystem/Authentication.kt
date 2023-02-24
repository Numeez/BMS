package com.example.bankmanagementsystem

import com.google.gson.Gson


    fun auth ()  {
        println("Login")
        println("Enter mail")
        val mail = readln()
        println("Enter password")
        val password = readln()
        var index:Int=0
        val user = Gson().fromJson(userFile.readText(), UserModel::class.java)

        val mailList=ArrayList<String>()
        val passwordList=ArrayList<String>()
        for(i in user){

            mailList.add(i.mail)

        }
        for(i in user){

            passwordList.add(i.password)

        }

        if(mailList.contains(mail))
        {
            if(passwordList.contains(password)){
            for(i in passwordList){
                if(i==password){
                    index = passwordList.indexOf(i)

                }
            }
            val currentUser= user[index]
            if (currentUser.isAdmin){
                home()
            }
            else
            {
                println("User Home")
            }
        }
            else{
                println("User doesn't Exist")
                auth()

            }

        }
        else {
            println("User doesn't Exist")
            auth()
        }
    }

