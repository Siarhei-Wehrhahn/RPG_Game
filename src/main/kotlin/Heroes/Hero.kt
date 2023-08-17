package Heroes

import Villains.Villain
import bag
import gold
import healDrink
import playSound
import protectiveSpell
import shop
import openBag
import takeDamage
import space

// Die Klasse für Helden
open class Hero(var name: String, var hp: Int) {

    var alive = true

    // Hier wird festgelegt, ob der Held gerade geschützt ist oder nicht
    var isProtected: Boolean = false
    var isOnVitamine: Boolean = false
    open var MAX_HP = 0 // Maximale Lebenspunkte des Helden

    // Die Hauptfunktion für die Aktionen des Helden
    open fun putOut(MAX_HP: Int, villain: Villain) {
        // Hier können Spieler ihre Handlung auswählen
        println("$space $name, choose your action:\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space 1. Attack\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space 2. Bag\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space") // Neue Option für die Tasche
        println("$space 3. Open shop\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        print("$space ")

    }

    // Die Angriffsaktion des Helden
    open fun attack(villain: Villain) {
        // Generiere eine zufällige Zahl für den Angriff
        var randomNumber = (0..100).random()

        // Wenn der Held auf Vitaminen ist, bekommt er 10 % mehr Stärke
        if (isOnVitamine) {
            randomNumber = (randomNumber * 1.1).toInt()
        }

        // Füge dem Bösewicht den Schaden hinzu
        villain.takeDamageEvil(randomNumber)

        // Zeige eine Nachricht abhängig vom Schaden
        if (randomNumber == 0) {
            println("$space Oh, no, I missed!\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        } else if ((randomNumber > 1) && (randomNumber < 25)) {
            println("$space That was weak!\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        } else if ((randomNumber > 25) && (randomNumber < 75)) {
            println("$space Good Attack!\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        } else if (randomNumber > 75) {
            println("$space Perfect! That was strong.\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        }
        println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
    }

    // Die Heilungsaktion des Helden
    open fun heal(MAX_HP: Int, villain: Villain) {
        val healingAmount = 150 // Heilungsmenge

        // Überprüfe, ob noch ein Heiltrank im Rucksack ist
        if (bag.contains("Healing Potion")) {
            println("$space You drink the healing potion.\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
            playSound(healDrink)
            Thread.sleep(3000)
            // Füge die Heilung zur HP des Helden hinzu
            hp += healingAmount
            bag.remove("Healing Potion")
            // Wenn die HP voll sind, gib eine Nachricht aus
            if (hp > MAX_HP) {
                hp = MAX_HP
                println("$space You reached the max hp!\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
            } else {
                println("$space $name heals for $healingAmount HP!\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
            }
        }
        println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
        putOut(MAX_HP, villain)
    }

    // Die Schutzaktion des Helden
    open fun useProtectivePotion(villain: Villain) {
        // Der Schutztrank kann nur getrunken werden, wenn er nicht bereits eingesetzt wurde und im Rucksack vorhanden ist
        if (!isProtected && bag.contains("Protective Potion")) {
            println("$space $name uses a Protective Potion!\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
            playSound(protectiveSpell)
            Thread.sleep(2500)
            bag.remove("Protective Potion")
            isProtected = true
        } else {
            println("$space $name cannot use a Protective Potion now.\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        }
        println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
        putOut(MAX_HP, villain)
    }

    // Die Vitaminaktion des Helden
    open fun takeVitamins(villain: Villain) {
        if (!isOnVitamine && bag.contains("Vitamins")) {
            println("$space You take the vitamins\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
            Thread.sleep(2000)
            println("$space GAAAAARRRHH!  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
            playSound(takeDamage)
            isOnVitamine = true
            println("$space You are now on special vitamins. Now you are 10% stronger!\t\t\t\t\t\t\t\t\t$space")
            bag.remove("Vitamins")
            println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
            Thread.sleep(2500)
            putOut(MAX_HP, villain)
        } else if (isOnVitamine) {
            println("$space You are on Vitamins, when u take more u will die!\t\t\t\t\t\t\t\t\t\t\t\t$space")
            println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
            Thread.sleep(2500)
            putOut(MAX_HP, villain)
        } else if (!bag.contains("Vitamins")) {
            println("$space You don't have Vitamins!\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
            println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
            putOut(MAX_HP, villain)
        }
    }

    // Der Schaden wird angenommen und abgezogen
    open fun takeDamage(damage: Int) {
        Thread.sleep(3000)
        if (!isProtected) {
            Thread.sleep(2500)
            // Die Damage(randomNumber) von den Bösewichten wird von den hp abgezogen
            hp -= damage
            if (hp <= 0) {
                println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t $name are Dead! $space")
                Thread.sleep(2500)
                alive = false
            } else {
                println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t  $name takes $damage damage. Remaining HP: $hp $space")
            }
        } else {
            Thread.sleep(2000)
            println("$space\t\t\t\t\t\t\t\t Your have reached nothing, because $name used protective spell! $space")
            isProtected = false
        }
    }

    open fun allTakeDamage(heroes: List<Hero>, damage: Int) {
        Thread.sleep(3000)
        for (hero in heroes) {
            hero.hp -= damage
            if (hp <= 0) {
                println("$space \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t${hero.name} are dead $space")

                alive = false
            } else {
                println("$space \t\t\t\t\t\t\t\t\t\t\t\t\t ${hero.name} takes $damage damage.  Remaining HP: ${hero.hp} $space")
            }
        }
    }

    // Das ist die Tashe der helden
    open fun openBag(MAX_HP: Int, villain: Villain) {
        println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
        playSound(openBag)
        println("$space You have open your bag\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space Lets see what do u have in there!\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        Thread.sleep(3500)
        println("|||||||||||||||||||$bag|||||||||||||||||||||||||||||")
        println("$space Do you want to take something out?\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space 1. Heal\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space 2. Use Protective Spell\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space 3. Use Vitamine\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space 4. Exit\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        print("$space ")
        var answered = readln().lowercase()
        if ((answered == "heal" || answered == "1") && bag.contains("Healing Potion")) {
            heal(MAX_HP, villain)
        } else if ((answered == "use protective spell" || answered == "2") && bag.contains("Protective Potion")) {
            useProtectivePotion(villain)
        } else if ((answered == "use vitamins" || answered == "3") && bag.contains("Vitamins")) {
            takeVitamins(villain)
        } else if (answered == "exit" || answered == "4") {
            println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
            putOut(MAX_HP, villain)
        } else {
            println("$space Invalid input!")
            openBag(MAX_HP, villain)
        }

    }


    open fun shop(villain: Villain) {
        println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
        playSound(shop)
        println("$space Welcome to the shop!\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space What do you want to buy?\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println(
            "$space In our assortment we have:\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space" +
                    "\n$space 1. Vitamins 500 Gold\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space" +
                    "\n$space 2. Protective Potion 300 Gold \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space" +
                    "\n$space 3. Healing Potion 250 Gold \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space" +
                    "\n$space 4. Exit\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space"
        )
        print("$space ")
        val buy = readln().lowercase()
        if ((buy == "vitamins" || buy == "1") && gold >= 500) {
            gold -= 500
            bag.add("Vitamins")
            println("$space Your purchase was successful!\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
            println("$space +1 Vitamins\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
            shop(villain)
        } else if ((buy == "protective potion" || buy == "2") && gold >= 300) {
            gold -= 300
            bag.add("Protective Potion")
            println("$space Your purchase was successful!\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
            println("$space +1 Protective Potion\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
            shop(villain)
        } else if ((buy == "healing potion" || buy == "3") && gold >= 250) {
            gold -= 250
            bag.add("Healing Potion")
            println("$space Your purchase was successful!\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
            println("$space +1 Healing Potion\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
            shop(villain)
        } else if (buy == "exit" || buy == "4") {
            playSound(shop)
            println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
            putOut(MAX_HP,villain)
        } else if (gold < 250) {
            println("$space Sorry, you don't have enough money.\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
            shop(villain)
        } else {
            println("$space Invalid input\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
            shop(villain)
        }
    }
}