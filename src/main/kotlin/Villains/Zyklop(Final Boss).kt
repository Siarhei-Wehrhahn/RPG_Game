package Villains

import Heroes.Hero

open class `Zyklop(Final Boss)`(name: String, hp: Int): Villain(name, hp) {

    val MAX_HP = 1000


    fun putOut(){
        println("I'm $name \nFor the streng of the Cyclops!")
        println("GAAARRH!!")
    }

    override fun evilAttack(hero: Hero) {
        super.evilAttack(hero)
    }
}