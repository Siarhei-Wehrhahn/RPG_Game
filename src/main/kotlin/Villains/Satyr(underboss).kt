package Villains

import Heroes.Hero

open class `Satyr(underboss)`(name: String, hp: Int): Villain(name, hp) {

    val MAX_HP = 500
    fun putOut(){
        println("I'm $name \nI'm fighting for destruction and dark power!")
    }

    fun attack(){
        var attacks: List<String> = listOf("doubleHoofStrike", "fluteEnchantment", "forestCurse", "panicCry", "aetherConjuring", "satyricTempest")
        var index = (0..7).random()
        var attackName = attacks[index]
        when (attackName){
            "doubleHoofStrike" -> doubleHoofStrike(Hero(name, hp))
            "fluteEnchantment" -> fluteEnchantment(Hero(name, hp))
            "forestCurse" -> forestCurse(Hero(name, hp))
            "panicCry" -> panicCry(Hero(name, hp))
            "aetherConjuring" -> aetherConjuring(Hero(name, hp))
            "satyricTempest" -> satyricTempest(Hero(name, hp))
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
}