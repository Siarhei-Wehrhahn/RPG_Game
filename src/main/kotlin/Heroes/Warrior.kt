package Heroes

import Villains.Villain
import space

class Warrior(name: String, hp: Int) : Hero(name, hp) {

    private val MAX_HP = 400

    fun introduceOneself() {
        Thread.sleep(2500)
        println("$space\u001B[0m Hello i'm a Warrior who is called $name\u001B[0m\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space\u001B[0m Victory or Valhalla!\u001B[0m\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
    }

    override fun putOut(villain: Villain) {
        println("$space $name, choose your action:\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space 1. Attack\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space 2. Heal\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space 3. Use Protective Spell\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space 4. Use Vitamine\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        print("$space ")
        val answere = readLine()?.lowercase()
        if ((answere == "attack") || (answere == "1")) {
            attack(villain)
        } else if ((answere == "heal") || (answere == "2")) {
            heal(MAX_HP, villain)
        } else if ((answere == "use protective spell") || (answere == "3")) {
            useProtectivePotion(villain)
        } else if ((answere == "use vitamins") || (answere == "4")) {
            takeVitamins(villain)
        } else if (answere == "") {
            println("Ungültige eingabe!")
            putOut(villain)
        }
    }


    override fun attack(villain: Villain) {
        var randomNumber = (0..100).random()

        // Wenn er auf vitaminen ist dann, bekommt er 10 % mehr stärke
        if (isOnVitamine) {
            randomNumber *= 1.1.toInt()
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
        } else if ((randomNumber > 75) && (randomNumber < 125)) {
            println("$space Perfekt! That was strong.\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        } else if (randomNumber > 125) {
            println("$space Incredible!\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t")
        }
        println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
    }

    override fun heal(MAX_HP: Int, villain: Villain) {
        super.heal(MAX_HP, villain)
    }

    override fun useProtectivePotion(villain: Villain) {
        super.useProtectivePotion(villain)
    }

    override fun takeDamage(damage: Int) {
        super.takeDamage(damage)
    }

    override fun allTakeDamage(heroes: List<Hero>, damage: Int) {
        super.allTakeDamage(heroes, damage)
    }

    override fun info() {
        super.info()
    }

    override fun isAlive() {
        super.isAlive()
    }

}