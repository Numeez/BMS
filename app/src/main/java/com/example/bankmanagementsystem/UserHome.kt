package com.example.bankmanagementsystem

import com.google.gson.Gson
import com.google.gson.GsonBuilder


fun userHome(){
    println("Enter 1 for getting account information")
    println("Enter 2 for depositing money")
    println("Enter 3 for withdrawing money")
    println("Enter 4 for updating the information")
    println("***************************************************\t")
    println("Enter your choice\t")
    val n = readln().toInt()
    when(n){
        1->displayAccountInfo()
        2->depositMoney()
        3->withdrawMoney()
        4->updateInformation()
        5->logOut()
        6->exit()

    }

}

fun displayAccountInfo(){
    println("Enter password")
    val pswd = readln()
    var index:Int=0
    val user = Gson().fromJson(userFile.readText(), UserModel::class.java)
    var password = ArrayList<String>()
    for(i in user){
        password.add(i.password)
    }
    if(password.contains(pswd)){

        while(index!=password.size){
            if(password.get(index)==pswd){
                break
            }
            else{
                index++
            }
        }
        println(index)
        val userAccountInfo = user[index]
        println("Personal Details\n********************************* \t")
        println("Name of Account Holder : ${userAccountInfo.firstName} ${userAccountInfo.lastName}")
        println("Mobile number of Account Holder : ${userAccountInfo.mobile}")
        println("Email of Account Holder : ${userAccountInfo.mail}\t")
        println("\t")
        println("\t")

        println("Account Details\n**********************************\t")
        for(i in userAccountInfo.account){
            println("Account number : ${i.accountNumber}")
            println("Account type : ${i.accountType}")
            println("Balance : ${i.balance}")
            if(i.isActive) {
                println("Account status : Active")
            }
            else{
                println("Account status : Not Active")
            }


        }


    }
    else{
        println("Invalid password or User doesn't exists")
        displayAccountInfo()
    }




}
fun depositMoney() {
    println("Money Depositing portal")
    println("****************************** \n\t\t")

    var index = 0
    println("Enter the amount to be deposited")
    println("**************************************\t\t")
    val amount = readln().toDouble()
    var password = ArrayList<String>()
    println("Enter password")
    val pswd = readln()
    for (i in user) {
        password.add(i.password)
    }
    if (password.contains(pswd)) {

        while (index != password.size) {
            if (password.get(index) == pswd) {
                break
            } else {
                index++
            }
        }
         var currentUser =  user[index]
        currentUser.account[0].balance+=amount
        userFile.writeText(GsonBuilder().setPrettyPrinting().create().toJson(user))
        println("$amount deposited successfully !!")

        userHome()



    }
}
fun withdrawMoney(){
    var index = 0
    println("Money withdrawing portal")
    println("**********************************************\n\t\t")
    println("Enter the amount you want to withdraw")
    val amount = readln().toDouble()
    println("Enter your password")
    val pswd = readln()
    val user = Gson().fromJson(userFile.readText(), UserModel::class.java)
    var password = ArrayList<String>()
    for(i in user){
        password.add(i.password)
    }
    if(password.contains(pswd)){

        while(index!=password.size){
            if(password.get(index)==pswd){
                break
            }
            else{
                index++
            }
        }
        val currentAmount = user[index].account[0].balance
        if(amount>currentAmount){
            println("You do not have sufficient balance")
            userHome()
        }
        else{
            var currentUser =  com.example.bankmanagementsystem.user[index]
            currentUser.account[0].balance-=amount
            userFile.writeText(GsonBuilder().setPrettyPrinting().create().toJson(com.example.bankmanagementsystem.user))
            println("$amount deducted successfully !!")
            userHome()


        }
    }







}


fun updateInformation() {
    var index = 0
    println("Update information")
    println("******************************")
    println("\n\t\t")
    println("Fill up the fields you want to update else type enter if you don't want to update that field")

    println("Enter your password")
    val pswd = readln()
    val user = Gson().fromJson(userFile.readText(), UserModel::class.java)
    var password = ArrayList<String>()
    for (i in user) {
        password.add(i.password)
    }
    if (password.contains(pswd)) {

        while (index != password.size) {
            if (password.get(index) == pswd) {
                break
            } else {
                index++
            }
        }
        val userId = user[index].id
        println("Enter firstname")
        val fname = readln()
        println("Enter lastname")
        val lname = readln()
        println("Enter mail")
        val email = readln()
        println("Enter mobile number")
        val mobile = readln()
    println(index)
        if (fname !== "") {

            val u = user.find { it.id.toString()==userId }
            if (u != null) {
                u.firstName = fname
                println(u.firstName)
            }

        }
        if(lname!==""){
            user[index].lastName=lname
        }
        if(email!=""){
            user[index].mail = email
        }
        if(mobile!=""){
            user[index].mobile=mobile

        }
        userFile.writeText(GsonBuilder().setPrettyPrinting().create().toJson(user))


    }
}
fun logOut(){
    auth()
}
