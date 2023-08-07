class Warrior(var name: String,var hp: Int):Hero(name, hp) {

    var isProtected = false
    var MAX_HP = 200

    fun putOut(){
        println("Hello i'm the Warrior $name")
        println("Victory or Valhalla!")
        println("$name, choose your action:")
        println("1. Attack")
        println("2. Heal")
        println("3. Use Protective Spell")
        var answere = readLine()?.lowercase()
        if (answere == "attack"){
            attack()
        } else if (answere == "heal") {
            heal()
        } else if (answere == "use protective spell"){
            useProtectivePotion()
        }
    }


    private fun attack(): Int {
        val randomNumber: Int = (0..100).random()
        return randomNumber
    }

    private fun heal() {
        val healingAmount = 150
        hp += healingAmount
        if (hp > MAX_HP) {
            hp = MAX_HP
        }
        println("$name heals for $healingAmount HP!")
    }

    private fun useProtectivePotion() {
        if (!isProtected && bag.contains("Protective Potion")) {
            println("$name uses a Protective Potion!")
            bag.remove("Protective Potion")
            isProtected = true
        } else {
            println("$name cannot use a Protective Potion now.")
        }
    }

    fun isProtected(): Boolean {
        return true
    }

}