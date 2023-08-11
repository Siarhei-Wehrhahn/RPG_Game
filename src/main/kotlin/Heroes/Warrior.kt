package Heroes

import Villains.Villain
import space

class Warrior(name: String, hp: Int): Hero(name, hp) {

    private val MAX_HP = 400

    fun introduceOneself(){
        println("$space\u001B[0m Hello i'm a Warrior who is called $name\u001B[0m\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space\u001B[0m Victory or Valhalla!\u001B[0m\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
    }

    override fun putOut(villain: Villain){
        println("$space $name, choose your action:\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space 1. Attack\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space 2. Heal\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space 3. Use Protective Spell\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        print("$space ")
        val answere = readLine()?.lowercase()
        if ((answere == "attack") || (answere == "1")){
            attack(villain)
        } else if ((answere == "heal") || (answere == "2")) {
            heal(MAX_HP)
        } else if ((answere == "use protective spell") || (answere == "3")){
            useProtectivePotion()
        }
    }


    override fun attack(villain: Villain) {
        var randomNumber = (0..100).random()

        // Wenn er auf vitaminen ist dann, bekommt er 10 % mehr stärke
        if (isOnVitamine){
            randomNumber *=  1.1 .toInt()
        } else {
        }

        // Hier wird der bösewicht anvisiert
        villain.takeDamageEvil(randomNumber)
        println("$space $name raises their mighty sword and charges forward!\t\t\t\t\t\t\t\t\t\t\t$space")

        // Hier wir die attacke zufällig generiert
        if (randomNumber == 0) {
            println("$space Oh, no, i missed!\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        } else if ((randomNumber > 1) && (randomNumber < 25)) {
            println("$space That was weak!\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        } else if ((randomNumber > 25) && (randomNumber < 75)) {
            println("$space Good Attack!\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        } else if ((randomNumber > 75)&&(randomNumber < 125)) {
            println("$space Perfekt! That was strong.\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        } else if (randomNumber > 125) {
            println("$space Incredible!\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t")
        }
        println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
    }

    override fun heal(MAX_HP: Int) {
        super.heal(MAX_HP)
    }

    override fun useProtectivePotion() {
        super.useProtectivePotion()
    }

    override fun takeDamage(damage: Int) {
        super.takeDamage(damage)
    }

    override fun info() {
        super.info()
    }

    override fun isAlive() {
        super.isAlive()
    }

}