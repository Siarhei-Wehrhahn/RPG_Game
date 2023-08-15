// * =========================================================
// * =========== Projekt RPG-Game =================
// * =========================================================
// * Current Version 1.0
// * =========================================================
// * erstellt durch: Siarhei Wehrhahn
// * =========================================================
// * Sprache : Kotlin
// * =========================================================

import Heroes.*
import Villains.Villain

fun main() {

    // Der Nachfolgende Text ist von Chat GPT und der code für die rainbow Farbe habe ich auch dort abgeschrieben
    val winningText =
        "$space Horray, you have defeated the beasts! Our castle is saved, and you are our hero. Your courage" +
                "$space and determination have spared  us from disaster. We are profoundly grateful for your bravery" +
                "$space and selflessness. May your name be forever anshrined in the chronicles of our history."

    val rainbowColors = listOf(black, red, green, yellow, blue, purple, cyan, white, magenta)

    // Hier kommt der text kombiniert mit der Farbe rein
    var rainbowText = ""

    // In der schleife wir buchstabe für buchstabe genommen und mit einer Farbe kombiniert und speichert jeden buchstaben und index in der zeichenkette
    for ((index, char) in winningText.withIndex()) {

        // rainbowColors-Liste ausgewählt, index des buchstaben wird durch die anzahl der farben geteilt damit alle farben zyklisch durchlaufen
        val color = rainbowColors[index % rainbowColors.size]
        rainbowText += "$color$char$x"
    }

    val titel =
        "                 _                              _              __   __  __           _   _                                                                        \n" +
                "                | |    ___  __ _  ___ _ __   __| |___    ___  / _| |  \\/  |_   _ ___| |_(_) ___ ___                                                               \n" +
                "                | |   / _ \\/ _` |/ _ | '_ \\ / _` / __|  / _ \\| |_  | |\\/| | | | / __| __| |/ __/ __|                                                              \n" +
                "                | |__|  __| (_| |  __| | | | (_| \\__ \\ | (_) |  _| | |  | | |_| \\__ | |_| | (__\\__ \\                                                              \n" +
                "                |_____\\___|\\__, |\\___|_| |_|\\__,_|___/  \\___/|_|   |_|  |_|\\__, |___/\\__|_|\\___|___/                                                              \n" +
                "   ____ _                  |___/     _                   __   _   _        |________            _                 _           _   ____            _               \n" +
                "  / ___| |__  _ __ ___  _ __ (_) ___| | ___ ___    ___  / _| | |_| |__   ___  | ____|_ __   ___| |__   __ _ _ __ | |_ ___  __| | |  _ \\ ___  __ _| |_ __ ___  ___ \n" +
                " | |   | '_ \\| '__/ _ \\| '_ \\| |/ __| |/ _ / __|  / _ \\| |_  | __| '_ \\ / _ \\ |  _| | '_ \\ / __| '_ \\ / _` | '_ \\| __/ _ \\/ _` | | |_) / _ \\/ _` | | '_ ` _ \\/ __|\n" +
                " | |___| | | | | | (_) | | | | | (__| |  __\\__ \\ | (_) |  _| | |_| | | |  __/ | |___| | | | (__| | | | (_| | | | | ||  __| (_| | |  _ |  __| (_| | | | | | | \\__ \\\n" +
                "  \\____|_| |_|_|  \\___/|_| |_|_|\\___|_|\\___|___/  \\___/|_|    \\__|_| |_|\\___| |_____|_| |_|\\___|_| |_|\\__,_|_| |_|\\__\\___|\\__,_| |_| \\_\\___|\\__,_|_|_| |_| |_|___/\n" +
                "                                                                                                                                                                  \n"
    // Text Quelle: Chat GPT
    val introText =
        """        
        $star $green Welcome to Legends of Mystica: Chronicles of the Enchanted Realms! $star
        $wizzard Step into a World of wonder and magic as you embark on an epic journey in 'Legends of Mystica'! $wizzard 
        $wr $kt Prepare to be captivated by a realm brimming with ancient mysteries, fantastical creatures, and untold adventures. $styr $ccps 
        $friendship Your destiny awaits as you immerse yourself in a narrative that weaves together courage, friendship, and the boundless power of imagination. $power 
        $pergament Are you ready to explore the realms of Mystica and etch your own legend in its chronicles? $pergament $x
        $castle $red Your castle is under attack! $attck 
        $pergament You must help us defend it. $pergament 
        $pergament What should we do? We await your orders $pergament $x
        """
    println("")
    println(titel)

    // Splitte den Text in Zeilen und gehe durch jede Zeile
    introText.lines().forEachIndexed { index, line ->
        // Warte 3 Sekunde zwischen den Zeilen
        if (index > 1) {
            Thread.sleep(2000)
        }
        // Drucke die Zeile und überschreibe sie mit \r
        println(line)
        if (index < introText.lines().size - 1) {
            print("\r")
        }
    }

    // Die Vorstellung
    println(" _______________________________________________________________________________________________________________________________________________________________________")
    println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||")
    magician.introduceOneself()
    warrior.introduceOneself()
    kentaur.introduceOneself()
    satyr.putOut()
    zyklop.putOut()

    // Solange alle am leben sind sollen die helden ihre züge machen danach die bösewichte (erster gegner)
    while (heroes.any { it.alive } && firstVillain.alive) {
        for (hero in heroes) {
            if (hero.alive && firstVillain.alive) {
                hero.putOut(hero.MAX_HP, firstVillain)
                villainsTurn(heroes, firstVillain, finalVillain)

                // Wenn heroes besiegt dan print
            } else if (!hero.alive && firstVillain.alive) {
                println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ${firstVillain.name} defeated ${hero.name}!$space")
                villainsTurn(heroes, firstVillain, finalVillain)

                // Wenn bösewicht besiegt dann zum endgegner weiter
            } else if (hero.alive && !firstVillain.alive) {
                break
            }
        }
    }

    surprise(heroes)


    while (heroes.any { it.alive } && finalVillain.alive) {
        for (hero in heroes) {
            if (hero.alive && finalVillain.alive) {
                hero.putOut(hero.MAX_HP, finalVillain)
                villainsTurn(heroes, firstVillain, finalVillain)

                // Wenn Bösewicht besiegt ist print
            } else if (!finalVillain.alive) {
                println("$space ${hero.name} defeated ${finalVillain.name}!")
                println("$space ")
                print(rainbowText)
                print("\t\t$space")
                break
            }
        }
    }
    if (heroes.all { !it.alive }) {
        println("$space ${finalVillain.name} defeated all Heroes!")
        println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||${red}Game Over$x!||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||")
    }
}

fun villainsTurn(heroes: MutableList<Hero>, firstVillain: Villain, finalVillain: Villain) {
    if (firstVillain.alive && heroes.any { it.alive }) {
        firstVillain.attack(heroes.filter { it.alive }.random())
    } else if (!firstVillain.alive && heroes.any { it.alive }) {
        finalVillain.attack(heroes.filter { it.alive }.random())
    }
}

fun surprise(hero: MutableList<Hero>) {
    println("$space Congratulations! You have defeated the satyr and discovered 500 gold coins in his pockets $space")

    // Füge das Gold  hinzu
    gold += 500

    println("$space +500 Gold for each Hero")

    // Heile alle Helden auf volle Gesundheit
    for (hero in heroes) {
        hero.hp = hero.MAX_HP
    }
    println("$space All Heroes are fully healed!")

    println("$space Thanks to you, we are now safe and we gift you a Healing Potion as a token of our gratitude $space")
    bag.add("Healing Potion")
    println("$space +Healing Potion")

    println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
}