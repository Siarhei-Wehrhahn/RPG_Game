package Heroes

import Villains.Villain

open class Hero(var name: String, var hp: Int) {

    //Das ist die Tashe der helden
    var bag: MutableList<String> = mutableListOf("Healing Potion", "Healing Potion", "Healing Potion", "Healing Potion", "Vitamins", "Vitamins", "Vitamins")

    //Hier wir festgelegt ob er gerade geschützt ist oder nicht
    var isProtected: Boolean = false
    var isOnVitamine: Boolean = false

    //Attacke mit zufälligen werten gegen den bösewicht
    open fun attack(villain: Villain) {
        var randomNumber = (0..100).random()

        //wenn er auf vitaminen ist dann bekommt er 10% mehr stärke
        if (isOnVitamine){
            randomNumber *=  1.1 .toInt()
        } else {
        }

        //Hier wird der bösewicht anvisiert
        villain.takeDamageEvil(randomNumber)

        //Es wird erwähnt wie der angriff war
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

    //Heilungsfunktion die 150HP wieder auffüllt
    open fun heal(MAX_HP: Int) {
        val healingAmount = 150

        //Es wird kontrolliert ob nooch ein trank in rucksack ist
        if (bag.contains("Healing Potion")) {
            println("You drin the healing potion.")

            //die 150 hp werden zu den hp vom hero dazugezählt
            hp += healingAmount
            bag.remove("Healing Potion")
            //wenn die hp voll sind wird es anders ausgegeben als wenn die nur gefüllt werden
            if (hp > MAX_HP) {
                hp = MAX_HP
                println("You reached the max hp!")
            } else{
                println("$name heals for $healingAmount HP!")
            }
        }
    }

    //Hier wird ein zaubertrank für den schutz getrunken
    open fun useProtectivePotion() {

        //Man kann den schutztrank nur trinken wenn man keinen intus hat falls überhaupt einer da ist
        if (!isProtected && bag.contains("Protective Potion")) {
            println("$name drink a Protective Potion!")
            bag.remove("Protective Potion")
            isProtected = true
        } else {
            println("$name cannot use a Protective Potion now.")
        }
    }

    //Der schaden wird angenommen und abgezogen
    open fun takeDamage(damage: Int) {

        //die demage(randomNumber) von den Bösewichten wird von den hp abgezogen
        hp -= damage
        if (hp <= 0) {
            println("$name are Dead!")
        } else {
            println("$name takes $damage damage. Remaining HP: $hp")
        }
    }

    //Hier werden die HP zu dem passendem Heroes.Hero gedruckt
    open fun info() {
        println("$name have $hp")
    }
}