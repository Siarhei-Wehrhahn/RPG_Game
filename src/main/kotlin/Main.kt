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
import Villains.`Satyr(underboss)`
import Villains.`Cyclop(Final Boss)`

fun main() {
    val magician = Magician("Merlin", 300)
    val warrior = Warrior("Arthur", 400)
    val kentaur = Kentaur("Cyrus", 350)
    val satyr = `Satyr(underboss)`("Panos", 500)
    val zyklop = `Cyclop(Final Boss)`("Aegon", 1000)

    val space = "|||||||||||||||||||||||||||||||||||||"

    // Unicode symbole
    val pg = "\uD83D\uDCDC"
    val star = "\u2B50"
    val castle = "\uD83C\uDFF0"
    val wizzard = "\uD83E\uDDD9"
    val wr = "\uD83E\uDD81"
    val kt = "\uD83E\uDD8C"
    val styr = "\uD83E\uDD93"
    val ccps = "\uD83D\uDC15"
    val friendship = "\uD83E\uDD0E"
    val power = "\uD83D\uDD25"
    val attck = "\u2694"

    // Farben
    val x = "\u001B[0m";
    val black = "\u001B[30m";
    val red = "\u001B[31m";
    val green = "\u001B[32m";
    val yellow = "\u001B[33m";
    val blue = "\u001B[34m";
    val purple = "\u001B[35m";
    val cyan = "\u001B[36m";
    val white = "\u001B[37m"

    val introText =
        """        
        $star $green Welcome to Legends of Mystica: Chronicles of the Enchanted Realms! $star
        $wizzard Step into a World of wonder and magic as you embark on an epic journey in 'Legends of Mystica'! $wizzard 
        $wr $kt Prepare to be captivated by a realm brimming with ancient mysteries, fantastical creatures, and untold adventures. $styr $ccps 
        $friendship Your destiny awaits as you immerse yourself in a narrative that weaves together courage, friendship, and the boundless power of imagination. $power 
        $pg Are you ready to explore the realms of Mystica and etch your own legend in its chronicles? $pg $x
        $castle $red Your castle is under attack! $attck 
        $pg You must help us defend it. $pg 
        $pg What should we do? We await your orders $pg $x
        """

    // Splitte den Text in Zeilen und gehe durch jede Zeile
    introText.lines().forEachIndexed { index, line ->
        // Warte 3 Sekunde zwischen den Zeilen
        if (index > 1) {
            Thread.sleep(10)
        }
        // Drucke die Zeile und überschreibe sie mit \r
        print(line)
        if (index < introText.lines().size - 1) {
            print("\r")
        }
    }

    val heroes = listOf(magician, warrior, kentaur)
    val firstVillain = satyr
    val finalVillain = zyklop

    // Die Vorstellung
    println("")
    println(" _______________________________________________________________________________________________________________________________________________________________________")
    println("|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||")
    magician.introduceOneself()
    warrior.introduceOneself()
    kentaur.introduceOneself()
    satyr.putOut()
    zyklop.putOut()

    // Solange alle am leben sind sollen die helden ihre züge machen danach die bösewichte
    while (heroes.any { it.alive } && firstVillain.alive) {
        for (hero in heroes) {
            if (hero.alive && firstVillain.alive) {
                hero.putOut(firstVillain)

                // Wenn heroes besiegt dan print
            } else if (!hero.alive && firstVillain.alive) {
                println("${firstVillain.name} defeated ${hero.name}!")

                // Wenn bösewicht besiegt dann zum endgegner weiter
            } else if (hero.alive && !firstVillain.alive) {
                println("${hero.name} defeated ${firstVillain.name}!")
                hero.putOut(finalVillain)

                // Solange alle am leben sind geht das spiel
                while (heroes.any { it.alive } && firstVillain.alive) {
                    for (hero in heroes) {
                        if (hero.alive && finalVillain.alive) {
                            hero.putOut(finalVillain)

                            // Wenn Bösewicht besiegt ist print
                        } else if (hero.alive && !finalVillain.alive) {
                            println("${hero.name} defeated ${finalVillain.name}!")
                            println("$space Horray, you have defeated the beasts! Our castle is saved, and you are our hero. Your courage" +
                                    "$space and determination have spared  us from disaster. We are profoundly grateful for your bravery" +
                                    "$space and selflessness. May your name be forever anshrined in the chronicles of our history.\t\t$space")

                            // Wenn Helden besiegt sind print
                        } else if (!hero.alive && finalVillain.alive) {
                            println("$space ${finalVillain.name} defeated ${hero.name}!")
                            println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||Game Over||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||")
                        }
                    }
                }
            }
        }

        // Zuerst sind die Helden am zug danach hier die bösen bis einer tod ist
        for (hero in heroes) {
            if (firstVillain.alive && hero.alive) {
                firstVillain.attack(hero)
            } else if (!hero.alive && finalVillain.alive) {
                println("$space ${finalVillain.name} defeated ${hero.name}!")
                println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||Game Over||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||")
            }
        }
    }
}