package Heroes

import Villains.Villain
import bag
import gold
import space

open class Hero(var name: String, var hp: Int) {

    var alive = true

    // Hier wir festgelegt, ob er gerade geschützt ist oder nicht
    var isProtected: Boolean = false
    var isOnVitamine: Boolean = false
    open var MAX_HP = 0

    open fun putOut(MAX_HP: Int, villain: Villain) {
        // Hier kann der spieler seine handlung bestimmen ob
        println("$space $name, choose your action:\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space 1. Attack\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        println("$space 2. Bag\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space") // Neue Option für die Tasche
        println("$space 3. Open shop\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        print("$space ")

    }

    // Attacke mit zufälligen werten gegen den bösewicht
    open fun attack(villain: Villain) {
        var randomNumber = (0..100).random()

        // Wenn er auf vitaminen ist dann, bekommt er 10 % mehr stärke
        if (isOnVitamine) {
            randomNumber = (randomNumber * 1.1).toInt()
        }
        Thread.sleep(3000)

        // Hier wird der bösewicht anvisiert
        villain.takeDamageEvil(randomNumber)
        // Es wird erwähnt, wie der angriff war
        if (randomNumber == 0) {
            println("$space Oh, no, i missed!\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        } else if ((randomNumber > 1) && (randomNumber < 25)) {
            println("$space That was weak!\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        } else if ((randomNumber > 25) && (randomNumber < 75)) {
            println("$space Good Attack!\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        } else if (randomNumber > 75) {
            println("$space Perfekt! That was strong.\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        }
        println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
    }

    // Heilungsfunktion die 150HP wieder auffüllt
    open fun heal(MAX_HP: Int, villain: Villain) {
        val healingAmount = 150

        // Es wird kontrolliert, ob noch ein trank in rucksack ist
        if (bag.contains("Healing Potion")) {
            println("$space You drink the healing potion.\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
            Thread.sleep(5000)
            // Die 150 hp werden zu den hp vom hero dazugezählt
            hp += healingAmount
            bag.remove("Healing Potion")
            // Wenn die hp voll sind, wird es anders ausgegeben als, wenn die nur gefüllt werden
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

    // Hier wird ein zaubertrank für den schutz getrunken
    open fun useProtectivePotion(villain: Villain) {

        // Man kann den schutztrank nur trinken, wenn man keinen intus hat, falls überhaupt einer da ist
        if (!isProtected && bag.contains("Protective Potion")) {
            println("$space $name drink a Protective Potion!$space")
            Thread.sleep(2500)
            bag.remove("Protective Potion")
            isProtected = true
        } else {
            println("$space $name cannot use a Protective Potion now.\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        }
        println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
        putOut(MAX_HP, villain)
    }

    open fun takeVitamins(villain: Villain) {
        if (!isOnVitamine && bag.contains("Vitamins")) {
            println("$space You take the vitamins\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
            Thread.sleep(3000)
            println("$space GAAAAARRRHH!  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
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
            println("$space Your have reached nothing, because $name used protective spell!\t\t\t\t\t\t\t$space")
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
            println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
            putOut(MAX_HP,villain)
        } else if (gold < 250) {
            println("$space Sorry, you don't have enough money.\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
            shop(villain)
        } else {
            println("$space Invalid input\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
            shop(villain)
        }
    }
}