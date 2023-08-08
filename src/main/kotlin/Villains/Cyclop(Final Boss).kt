package Villains

import Heroes.Hero

open class `Cyclop(Final Boss)`(name: String, hp: Int): Villain(name, hp) {
    val MAX_HP = 1000

    fun putOut(){
        println("\u001B[31mI'm $name \nFor the streng of the Cyclops!")
        println("GAAARRH!!\u001B[0m")
    }

    fun attack(){
        var attacks: List<String> = listOf("evilAttack", "underUnderBoss", "stomper", "boulderHurl", "quakeCall", "fieryGaze", "chainBind", "wrathOfTheGods")
        var index = (0..7).random()
        var attackName = attacks[index]
        when (attackName){
            "evilAttack" -> evilAttack(Hero(name, hp))
            "underUnderBoss" -> underUnderBoss()
            "stomper" -> stomper(Hero(name, hp))
            "boulderHurl" -> boulderHurl(Hero(name, hp))
            "quakeCall" -> quakeCall(Hero(name, hp))
            "fieryGaze" -> fieryGaze(Hero(name, hp))
            "chainBind" -> chainBind(Hero(name, hp))
            "wrathOfTheGods" -> wrathOfTheGods(Hero(name, hp))
        }
    }

    override fun evilAttack(hero: Hero) {
        super.evilAttack(hero)
    }

    override fun takeDamageEvil(damage: Int) {
        super.takeDamageEvil(damage)
    }

    override fun underUnderBoss() {
        super.underUnderBoss()
    }

    override fun stomper(hero: Hero) {
        super.stomper(hero)
    }

    override fun boulderHurl(hero: Hero) {
        super.boulderHurl(hero)
    }

    override fun quakeCall(hero: Hero) {
        super.quakeCall(hero)
    }

    override fun fieryGaze(hero: Hero) {
        super.fieryGaze(hero)
    }

    override fun chainBind(hero: Hero) {
        super.chainBind(hero)
    }

    override fun wrathOfTheGods(hero: Hero) {
        super.wrathOfTheGods(hero)
    }

    override fun info() {
        super.info()
    }
}