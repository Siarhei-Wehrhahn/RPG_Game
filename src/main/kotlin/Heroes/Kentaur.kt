package Heroes

import Villains.Villain

class Kentaur(name: String, hp: Int): Hero(name, hp) {

    private val MAX_HP = 500

    fun introduceOneself(){
        println("\u001B[37mWuhihihihi, I'm the Zentaur $name")
        println("For Hornor and Strength\u001B[0m")
        println("\u001B[33m---------------------------------------\u001B[0m")
    }

    fun putOut(villain: Villain){
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
        println("$name charges forward, employing both his archery skills and powerful hooves in the attack!")
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