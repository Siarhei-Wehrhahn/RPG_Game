class Kentaur(name: String, hp: Int):Hero(name, hp) {

    var MAX_HP = 200

    fun putOut(){
        println("Wuhihihihi, I'm the Zentaur $name")
        println("For Hornor and Strength")
        println("$name, choose your action:")
        println("1. Attack")
        println("2. Heal")
        println("3. Use Protective Spell")
        var answere = readLine()?.lowercase()
        if (answere == "attack"){
            attack()
        } else if (answere == "heal") {
            heal(MAX_HP)
        } else if (answere == "use protective spell"){
            useProtectivePotion()
        }
    }


    override fun attack(){
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