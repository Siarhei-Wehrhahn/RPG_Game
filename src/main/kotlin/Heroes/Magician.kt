package Heroes

import Villains.Villain
import space

class Magician(name: String, hp: Int) : Hero(name, hp) {           // Klasse angelegt Primärer konstruktor

    private var MAX_HP = 300                                                    //HP wurde festgelegt

    fun introduceOneself() {
        // Hier stellt sich der Held vor
        println("$space\u001B[34m Hello I'm the Wizard $name.\u001B[0m\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")

        // Hier ist der schlachtruf
        println("$space\u001B[34m By the power of magic, prevai!\u001B[0m\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
    }

    override fun putOut(villain: Villain) {
        // Hier kann der spieler seine handlung bestimmen ob
        println("$space $name, choose your action:\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space 1. Attack\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space 2. Heal\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space 3. Use Protective Spell\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space 4. Use Vitamine\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")

        // Hier wird die antwort erwartet
        print("$space ")
        var answere = readLine()?.lowercase()
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

    override fun info() {
        super.info()
    }

    override fun isAlive() {
        super.isAlive()
    }

}