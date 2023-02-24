package com.example.bankmanagementsystem

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.File

fun registerUser(){
     val userFile = File("C:\\Users\\158380\\AndroidStudioProjects\\BankManagementSystem\\app\\src\\main\\java\\com\\example\\bankmanagementsystem\\users.json")
     val user = Gson().fromJson(userFile.readText(), UserModel::class.java)
     var fname = ""
     var lname = ""
     var password = ""
     var email = ""
     var mobile = ""
     val pattern = Regex("^.{8,}\$")
     val pattern_email = Regex("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+\$")
     val pattern_mobile = Regex("^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}\$")

    println("Register admin")

         while (fname == "") {
             println("Enter  first name")
             val f: String = readln()
             if (!f.isNullOrBlank()) {
                 fname = f
             }
         }



         while (lname == "") {
             println("Enter  last name")
             val l: String = readln()
             if (!l.isNullOrBlank()) {
                 lname = l
             }
         }


         while (email == "") {
             println("Enter email")
             val e: String = readln()
             if (!e.isNullOrBlank() && pattern_email.containsMatchIn(e)) {

                 email = e

             } else {
                 println("Invalid email , please  Enter again \n\n")
             }
         }
         while (mobile == "") {
             println("Enter  valid mobile number ")
             val m: String = readln()
             if (!m.isNullOrBlank() && pattern_mobile.containsMatchIn(m)) {
                 mobile = m
             } else {
                 println("Invalid mobile number,Please enter again\n\n")
             }
         }

         while (password == "") {
             println("Enter password")
             val p: String = readln()
             if (!p.isNullOrBlank() && pattern.containsMatchIn(p)) {

                 password = p

             } else {
                 println("Invalid email , please  Enter again \n\n ")
             }
         }
         val u = User(
             firstName = fname,
             lastName = lname,
             mail = email,
             mobile = mobile,
             password = password
         )

         user.add(u)
         userFile.writeText(GsonBuilder().setPrettyPrinting().create().toJson(user))
        userManagement()
     }




