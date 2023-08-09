package Heroes

import Villains.Villain

class Kentaur(name: String, hp: Int): Hero(name, hp) {

    private val MAX_HP = 500

    fun introduceOneself(){
        println("$space\u001B[37m Wuhihihihi, I'm the Zentaur $name\u001B[0m\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space\u001B[37m For Hornor and Strength\u001B[0m\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
    }

    override fun putOut(villain: Villain){
        println("$space $name, choose your action:\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space 1. Attack\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space 2. Heal\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space 3. Use Protective Spell\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        print("$space ")
        var answere = readLine()?.lowercase()
        if ((answere == "attack") || (answere == "1")){
            attack(villain)
        } else if ((answere == "heal") || (answere == "2")) {
            heal(MAX_HP)
        } else if ((answere == "use protective spell") || (answere == "3")){
            useProtectivePotion()
        }
    }


    override fun attack(villain: Villain){
        println("$space $name charges forward, employing both his archery skills and powerful hooves in the attack!\t$space")
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

    override fun isAlive() {
        super.isAlive()
    }

}