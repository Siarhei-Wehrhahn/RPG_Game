package Villains

import Heroes.Hero

open class Villain(var name: String, var hp: Int) {

    open fun evilAttack(hero: Hero) {
        val randomNumber: Int = (0..150).random()
        hero.takeDamage(randomNumber)
        println("$name attacks ${hero.name} for $randomNumber damage!")
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

    open fun takeDamageEvil(damage: Int) {
        hp -= damage
        if (hp <= 0) {
            println("$name you are a lucky one!")
        } else {
            println("$name takes $damage damage. Remaining HP: $hp")
        }
    }

    open fun underUnderBoss(){
        println("Oh no ")
    }
}