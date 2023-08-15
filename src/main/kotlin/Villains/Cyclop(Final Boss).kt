package Villains

import Heroes.Hero
import heroes
import space

open class `Cyclop(Final Boss)`(name: String, hp: Int) : Villain(name, hp) {

    fun putOut() {
        Thread.sleep(2500)
        println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\u001B[31mI'm $name the Cyclop\u001B[0m  \t\t\t\t\t\t$space \n$space\t\t\t\t\t\t\t\t\t\t\t\t\t\u001B[31mFor the streng of the Cyclops!\u001B[0m\t\t\t\t$space")
        println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\u001B[31mGAAARRH!!\u001B[0m\t\t\t\t\t\t\t\t\t$space")
        println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
    }


    override fun attack(hero: Hero) {
        var attacks: List<String> = listOf(
            "evilAttack",
            "underUnderBoss",
            "stomper",
            "boulderHurl",
            "quakeCall",
            "fieryGaze",
            "chainBind",
            "wrathOfTheGods"
        )
        var index = (0..7).random()
        var attackName = attacks[index]
        when (attackName) {
            "evilAttack" -> evilAttack(heroes.random())
            "underUnderBoss" -> underUnderBoss(hero)
            "stomper" -> stomper(heroes.random())
            "boulderHurl" -> boulderHurl(heroes.random())
            "quakeCall" -> quakeCall(heroes.random())
            "fieryGaze" -> fieryGaze(heroes.random())
            "chainBind" -> chainBind(heroes.random())
            "wrathOfTheGods" -> wrathOfTheGods(heroes.random())
        }
    }
}