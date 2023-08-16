package Heroes

import Villains.Villain
import playSound
import space
import sword

class Warrior(name: String, hp: Int) : Hero(name, hp) {

    override var MAX_HP = 400

    fun introduceOneself() {
        Thread.sleep(2500)
        println("$space\u001B[0m Hello i'm a Warrior who is called $name\u001B[0m\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space\u001B[0m Victory or Valhalla!\u001B[0m\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
    }

    override fun putOut(MAX_HP: Int, villain: Villain) {
        super.putOut(MAX_HP, villain)
        val answere = readlnOrNull()?.lowercase()
        when (answere) {
            "attack", "1" -> attack(villain)
            "bag", "2" -> openBag(MAX_HP, villain) // Neue Funktion für die Tasche
            "open shop", "3" -> shop(villain)
            else -> {
                println("$space Invalid input!")
                putOut(MAX_HP, villain)
            }
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
        playSound(sword)
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




}