package Heroes

import Villains.Villain
import space

class Kentaur(name: String, hp: Int) : Hero(name, hp) {

    override var MAX_HP = 500

    fun introduceOneself() {
        Thread.sleep(2500)
        println("$space\u001B[37m Wuhihihihi, I'm the Zentaur $name\u001B[0m\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space\u001B[37m For Hornor and Strength\u001B[0m\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
    }

    override fun putOut(MAX_HP: Int, villain: Villain) {
        super.putOut(MAX_HP,villain)
        when (readlnOrNull()?.lowercase()) {
            "attack", "1" -> attack(villain)
            "bag", "2" -> openBag(MAX_HP, villain) // Neue Funktion für die Tasche
            "open shop", "3" -> shop(villain)
            else -> {
                println("$space Invalid input!")
                putOut(MAX_HP,villain)
            }
        }
    }


    override fun attack(villain: Villain) {
        println("$space $name charges forward, employing both his archery skills and powerful hooves in the attack!\t$space")
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