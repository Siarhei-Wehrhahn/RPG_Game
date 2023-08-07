package Heroes

import Villains.Villain

class Magician(name: String, hp: Int): Hero(name, hp){           // Klasse angelegt Primärer konstruktor

    var MAX_HP = 300                                                    //HP wurde festgelegt

    fun putOut(villain: Villain){

        //Hier stellt sich der Held vor
        println("Hello I'm the Heroes.Magician $name.")

        //hier ist der schlachtruf
        println("By the power of magic, prevai!")

        //Hier kann der spieler seine handlung bestimmen ob
        println("$name, choose your action:")
        println("1. Attack")
        println("2. Heal")
        println("3. Use Protective Spell")

        //Hier wird die antwort erwartet
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