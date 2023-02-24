package com.example.bankmanagementsystem

import com.google.gson.Gson


class Authentication {
    fun auth( Mail:String, Password:String) :Boolean {
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
        if(mailList.contains(Mail) && passwordList.contains(Password)){
            for(i in passwordList){
                if(i==Password){
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
        return false

    }

}