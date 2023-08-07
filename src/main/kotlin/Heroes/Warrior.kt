package Heroes

import Villains.Villain

class Warrior(name: String, hp: Int): Hero(name, hp) {

    val MAX_HP = 400

    fun putOut(villain: Villain){
        println("Hello i'm the Heroes.Warrior $name")
        println("Victory or Valhalla!")
        println("$name, choose your action:")
        println("1. Attack")
        println("2. Heal")
        println("3. Use Protective Spell")
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
        val randomNumber: Int = (50..150).random()                   //hier wir die attacke zufällig generiert
        if (randomNumber == 0) {
            println("Oh, no, i missed!")
        } else if ((randomNumber > 1) && (randomNumber < 25)) {
            println("That was weak!")
        } else if ((randomNumber > 25) && (randomNumber < 75)) {
            println("Good Attack!")
        } else if ((randomNumber > 75)&&(randomNumber < 125)) {
            println("Perfekt! That was strong.")
        } else if (randomNumber > 125) {
            println("Incredible!")
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