class Magician(name: String, hp: Int):Hero(name, hp){           // Klasse angelegt Primärer konstruktor

    var MAX_HP = 300                                                    //HP wurde festgelegt

    fun putOut(){
        println("Hello I'm the Magician $name.")                        //Hier stellt sich der Held vor
        println("By the power of magic, prevai!")                       //hier ist der schlachtruf
        println("$name, choose your action:")
        println("1. Attack")
        println("2. Heal")                                              //Hier kann der spieler seine handlung
        println("3. Use Protective Spell")                                  //bestimmen ob er attakiert o. a.
        var answere = readLine()?.lowercase()                           //Hier wird die antwort erwartet
        if (answere == "attack"){
            attack()                                         //Bei attack() wird dir fun attack ausgeführt
        } else if (answere == "heal") {
            heal(MAX_HP)
        } else if (answere == "use protective spell"){
            useProtectivePotion()
        }
    }


    override fun attack() {
        super.attack()
    }

    override fun heal(MAX_HP: Int) {
        super.heal(MAX_HP)
    }

    override fun useProtectivePotion() {
        super.useProtectivePotion()
    }

    override fun protect() {
        return super.protect()
    }

}