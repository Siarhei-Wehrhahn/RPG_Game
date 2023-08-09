package Heroes

import Villains.Villain

class Warrior(name: String, hp: Int): Hero(name, hp) {

    private val MAX_HP = 400

    fun introduceOneself(){
        println("||\u001B[0mHello i'm a Warrior who is called $name\u001B[0m\t\t\t\t\t\t\t\t\t\t\t\t\t\t||")
        println("||\u001B[0mVictory or Valhalla!\u001B[0m\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t||")
        println("||\u001B[33m----------------------------------------------------------------------------------------------\u001B[0m||")
    }

    fun putOut(villain: Villain){
        println("||$name, choose your action:")
        println("||1. Attack")
        println("||2. Heal")
        println("||3. Use Protective Spell")
        var answere = readLine()?.lowercase()
        if (answere == "attack"){
            attack(villain)
        } else if (answere == "heal") {
            heal(MAX_HP)
        } else if (answere == "use protective spell"){
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
        println("||$name raises their mighty sword and charges forward!")

        // Hier wir die attacke zufällig generiert
        if (randomNumber == 0) {
            println("||Oh, no, i missed!")
        } else if ((randomNumber > 1) && (randomNumber < 25)) {
            println("||That was weak!")
        } else if ((randomNumber > 25) && (randomNumber < 75)) {
            println("||Good Attack!")
        } else if ((randomNumber > 75)&&(randomNumber < 125)) {
            println("||Perfekt! That was strong.")
        } else if (randomNumber > 125) {
            println("||Incredible!")
        }
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

}