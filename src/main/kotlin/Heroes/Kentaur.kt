package Heroes

import Villains.Villain

class Kentaur(name: String, hp: Int): Hero(name, hp) {

    val MAX_HP = 350

    fun putOut(villain: Villain){
        println("Wuhihihihi, I'm the Zentaur $name")
        println("For Hornor and Strength")
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


    override fun attack(villain: Villain){
        super.attack(villain)
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