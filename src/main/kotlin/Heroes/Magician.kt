package Heroes

import Villains.Villain
import space

class Magician(name: String, hp: Int) : Hero(name, hp) {           // Klasse angelegt Primärer konstruktor

    override var MAX_HP = 300                                                    //HP wurde festgelegt

    fun introduceOneself() {
        // Hier stellt sich der Held vor
        println("$space\u001B[34m Hello I'm the Wizard $name.\u001B[0m\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")

        // Hier ist der schlachtruf
        println("$space\u001B[34m By the power of magic, prevai!\u001B[0m\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
    }

    override fun putOut(MAX_HP: Int, villain: Villain) {
        super.putOut(MAX_HP,villain)
        val answere = readlnOrNull()?.lowercase()
        when (answere) {
            "attack", "1" -> attack(villain)
            "bag", "2" -> openBag(MAX_HP,villain) // Neue Funktion für die Tasche
            "open shop", "3" -> shop(villain)
            else -> {
                println("$space Invalid input!")
                putOut(MAX_HP,villain)
            }
        }
    }


    override fun attack(villain: Villain) {
        println("$space $name's fingertips crackle with arcane energy as a dazzling spell takes shape!\t\t\t\t$space")
        super.attack(villain)
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

    override fun openBag(MAX_HP: Int, villain: Villain) {
        super.openBag(MAX_HP, villain)
    }

    override fun shop(villain: Villain) {
        super.shop(villain)
    }
}