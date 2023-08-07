open class Hero(var name: String, var hp: Int) {
    var bag: MutableList<String> = mutableListOf("Healing Potion", "Healing Potion", "Healing Potion", "Healing Potion", "Vitamins", "Vitamins", "Vitamins")

    var isProtected: Boolean = false
    open fun attack() {
        val randomNumber: Int = (0..100).random()                   //hier wir die attacke zufällig generiert
        if (randomNumber == 0) {
            println("Oh, no, i missed!")
        } else if ((randomNumber > 1) && (randomNumber < 25)) {
            println("That was weak!")
        } else if ((randomNumber > 25) && (randomNumber < 75)) {
            println("Good Attack!")
        } else if (randomNumber > 75) {
            println("Perfekt! That was strong.")
        }
    }

    open fun heal(MAX_HP: Int) {
        val healingAmount = 150
        if (bag.contains("Healing Potion")) {
            hp += healingAmount
            bag.remove("Healing Potion")
            if (hp > MAX_HP) {
                hp = MAX_HP
                println("You reached the max hp!")
            } else{
                println("$name heals for $healingAmount HP!")
            }
        }
    }

    open fun useProtectivePotion() {
        if (!isProtected && bag.contains("Protective Potion")) {
            println("$name uses a Protective Potion!")
            bag.remove("Protective Potion")
            isProtected = true
        } else {
            println("$name cannot use a Protective Potion now.")
        }
    }

    open fun protect() {
        isProtected = true
        println("You used a protective spell")
    }
}