package Villains

import Heroes.Hero

open class `Satyr(underboss)`(name: String, hp: Int): Villain(name, hp) {

    val MAX_HP = 500
    fun putOut(){
        println("I'm $name \nI#m fighting for destruction and dark power!")
    }

    override fun takeDamageEvil(damage: Int) {
        super.takeDamageEvil(damage)
    }

    override fun evilAttack(hero: Hero) {
        super.evilAttack(hero)
    }

}