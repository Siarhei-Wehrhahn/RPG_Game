package Villains

import Heroes.Hero
import space

open class `Satyr(underboss)`(name: String, hp: Int) : Villain(name, hp) {

    fun putOut() {
        Thread.sleep(2500)
        println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\u001B[35mI'm $name the Satyr\u001B[0m\t\t\t\t\t\t\t$space\n$space\t\t\t\t\t\t\t\t\t\t\t\t\t\u001B[35mI'm fighting for destruction and dark power!\u001B[0m$space")
    }

    fun attack(heroes: List<Hero>) {
        var attacks: List<String> = listOf(
            "doubleHoofStrike",
            "fluteEnchantment",
            "forestCurse",
            "panicCry",
            "aetherConjuring",
            "satyricTempest"
        )
        var index = (0..5).random()
        var attackName = attacks[index]
        when (attackName) {
            "doubleHoofStrike" -> doubleHoofStrike(heroes.random())
            "fluteEnchantment" -> fluteEnchantment(heroes.random())
            "forestCurse" -> forestCurse(heroes.random())
            "panicCry" -> panicCry(heroes.random())
            "aetherConjuring" -> aetherConjuring(heroes.random())
            "satyricTempest" -> satyricTempest(heroes.random())
        }
    }

    override fun takeDamageEvil(damage: Int) {
        super.takeDamageEvil(damage)
    }

    override fun doubleHoofStrike(hero: Hero) {
        super.doubleHoofStrike(hero)
    }

    override fun fluteEnchantment(hero: Hero) {
        super.fluteEnchantment(hero)
    }

    override fun forestCurse(hero: Hero) {
        super.forestCurse(hero)
    }

    override fun panicCry(hero: Hero) {
        super.panicCry(hero)
    }

    override fun aetherConjuring(hero: Hero) {
        super.aetherConjuring(hero)
    }

    override fun satyricTempest(hero: Hero) {
        super.satyricTempest(hero)
    }

    override fun info() {
        super.info()
    }

    override fun isAlive() {
        super.isAlive()
    }

}