open class Villain(name: String, hp: Int) : Hero(name, hp) {

    override fun attack() {
        val randomNumber: Int = (0..150).random()

        if (randomNumber == 0) {
            println("$name's attack missed!")
        } else if ((randomNumber > 1) && (randomNumber < 50)) {
            println("$name's attack was weak!")
        } else if ((randomNumber > 50) && (randomNumber < 100)) {
            println("$name's attack was good!")
        } else if (randomNumber > 100) {
            println("$name's attack was strong!")
        }
    }
}