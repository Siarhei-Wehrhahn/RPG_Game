package Villains

import Heroes.Hero

open class Villain(var name: String, var hp: Int) {

    open fun takeDamageEvil(damage: Int) {
        hp -= damage
        if (hp <= 0) {
            println("$name you are a lucky one!")
        } else {
            println("$name takes $damage damage. Remaining HP: $hp")
        }
    }

    // Angriffe für den Zyklopen (Endgegner)
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

    // Es wird ein helfer gerufen der schutz bietet und angreift
    open fun underUnderBoss(){
        println("A hellhound has come to the rescue.")
        hp += 200
    }

    // Kleiner Flächenschaden wegen stampfer
    open fun stomper(hero: Hero){
        println("Feel the earth tremble beneath my might!")
        val randomNumber: Int = (0..100).random()
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

    // Wirft großen stein auf seine gegner
    open fun boulderHurl(hero: Hero){
        println("Witness the power of flying boulders!")
        val randomNumber: Int = (0..175).random()
        hero.takeDamage(randomNumber)
        println("$name attacks ${hero.name} for $randomNumber damage!")
        if (randomNumber == 0) {
            println("$name's attack missed!")
        } else if ((randomNumber > 1) && (randomNumber < 70)) {
            println("$name's attack was weak!")
        } else if ((randomNumber > 70) && (randomNumber < 130)) {
            println("$name's attack was good!")
        } else if (randomNumber > 130) {
            println("$name's attack was strong!")
        }
    }

    // Durch schlag auf boden, entsteht ein Erbeben was einen größeren Schaden anrichtet wie stomper()
    open fun quakeCall(hero: Hero){
        println("Bow before the earth's fury!")
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

    // Auge schießt feurige Energie, die bei kontakt zu verbrennungen führt
    open fun fieryGaze(hero: Hero){
        println("Burn in the flames of my gaze!")
        val randomNumber: Int = (0..200).random()
        hero.takeDamage(randomNumber)
        println("$name attacks ${hero.name} for $randomNumber damage!")
        if (randomNumber == 0) {
            println("$name's attack missed!")
        } else if ((randomNumber > 1) && (randomNumber < 100)) {
            println("$name's attack was weak!")
        } else if ((randomNumber > 100) && (randomNumber < 150)) {
            println("$name's attack was good!")
        } else if (randomNumber > 150) {
            println("$name's attack was strong!")
        }
    }

    // Zyklop fesselt die gegner während er sich auf eine andere fähigkeit konzentriert (Helden setzen 1 runde aus)
    open fun chainBind(hero: Hero){
        println("Bound by unbreakable chains!")
        println("The heroes are bound!")
    }

    // Zyklop feuert gewaltige Energy aus seinem Auge, welche 500 Schaden anrichtet aber auch 200 bei sich selbst.
    open fun wrathOfTheGods(hero: Hero){
        println("Behold the wrath of the gods unleashed!")
        val randomNumber: Int = (0..500).random()
        hero.takeDamage(randomNumber)
        println("$name attacks ${hero.name} for $randomNumber damage!")
        if (randomNumber == 0) {
            println("$name's attack missed!")
        } else if ((randomNumber > 1) && (randomNumber < 150)) {
            println("$name's attack was weak!")
        } else if ((randomNumber > 150) && (randomNumber < 350)) {
            println("$name's attack was good!")
        } else if (randomNumber > 350) {
            println("$name's attack was strong!")
        }
    }

    // Angriffe für den Satyr
    // Doppelhuf sorgt für einen Erdstoß, der den Gegner trifft
    open fun doubleHoofStrike(hero: Hero){
        println("Feel the thunder of my hooves!")
        val randomNumber: Int = (0..75).random()
        hero.takeDamage(randomNumber)
        println("$name attacks ${hero.name} for $randomNumber damage!")
        if (randomNumber == 0) {
            println("$name's attack missed!")
        } else if ((randomNumber > 1) && (randomNumber < 20)) {
            println("$name's attack was weak!")
        } else if ((randomNumber > 20) && (randomNumber < 40)) {
            println("$name's attack was good!")
        } else if (randomNumber > 40) {
            println("$name's attack was strong!")
        }
    }

    // Flötenzauber raubt die lebensenergie
    open fun fluteEnchantment(hero: Hero){
        println("Dance to the melody of enchantment!")
        val randomNumber: Int = (0..50).random()
        hero.takeDamage(randomNumber)
        println("$name attacks ${hero.name} for $randomNumber damage!")
        if (randomNumber == 0) {
            println("$name's attack missed!")
        } else if ((randomNumber > 1) && (randomNumber < 20)) {
            println("$name's attack was weak!")
        } else if ((randomNumber > 20) && (randomNumber < 30)) {
            println("$name's attack was good!")
        } else if (randomNumber > 30) {
            println("$name's attack was strong!")
        }
    }

    // Waldes fluch entfesselt einen fluch, der Pflanzen und Tiere auf die Feine losgehen lässt
    open fun forestCurse(hero: Hero){
        println("Natire's wrath shall be your undoing!")
        val randomNumber: Int = (0..100).random()
        hero.takeDamage(randomNumber)
        println("$name attacks ${hero.name} for $randomNumber damage!")
        if (randomNumber == 0) {
            println("$name's attack missed!")
        } else if ((randomNumber > 1) && (randomNumber < 25)) {
            println("$name's attack was weak!")
        } else if ((randomNumber > 25) && (randomNumber < 65)) {
            println("$name's attack was good!")
        } else if (randomNumber > 65) {
            println("$name's attack was strong!")
        }
    }

    // Panischer schrei versetzt Furcht und Panik in die Herzen der Gegner
    open fun panicCry(hero: Hero){
        println("Tremble in the grip of fear!")
        val randomNumber: Int = (0..30).random()
        hero.takeDamage(randomNumber)
        println("$name attacks ${hero.name} for $randomNumber damage!")
        if (randomNumber == 0) {
            println("$name's attack missed!")
        } else if ((randomNumber > 1) && (randomNumber < 10)) {
            println("$name's attack was weak!")
        } else if ((randomNumber > 10) && (randomNumber < 20)) {
            println("$name's attack was good!")
        } else if (randomNumber > 20) {
            println("$name's attack was strong!")
        }
    }

    // Äther beschwörung bring Kräfte aus anderen Dimmensionen zum Satyr
    open fun aetherConjuring(hero: Hero){
        println("From beyond the realms, I summon!")
        val randomNumber: Int = (0..50).random()
        hero.takeDamage(randomNumber)
        println("$name attacks ${hero.name} for $randomNumber damage!")
        if (randomNumber == 0) {
            println("$name's attack missed!")
        } else if ((randomNumber > 1) && (randomNumber < 10)) {
            println("$name's attack was weak!")
        } else if ((randomNumber > 10) && (randomNumber < 20)) {
            println("$name's attack was good!")
        } else if (randomNumber > 35) {
            println("$name's attack was strong!")
        }
    }

    // Satyrischer Sturm beschwört einen Sturm herbei, der alle gegner wegfegt
    open fun satyricTempest(hero: Hero){
        println("Unleash the storm of a wild heart!")
        val randomNumber: Int = (0..80).random()
        hero.takeDamage(randomNumber)
        println("$name attacks ${hero.name} for $randomNumber damage!")
        if (randomNumber == 0) {
            println("$name's attack missed!")
        } else if ((randomNumber > 1) && (randomNumber < 20)) {
            println("$name's attack was weak!")
        } else if ((randomNumber > 20) && (randomNumber < 50)) {
            println("$name's attack was good!")
        } else if (randomNumber > 50) {
            println("$name's attack was strong!")
        }
    }

    open fun info() {
        println("$name have $hp")
    }
}