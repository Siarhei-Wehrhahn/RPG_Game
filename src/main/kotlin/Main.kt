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


    // Text Quelle: Chat GPT
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

                            // Text von Chate GPT
                            println(
                                "$space Horray, you have defeated the beasts! Our castle is saved, and you are our hero. Your courage" +
                                        "$space and determination have spared  us from disaster. We are profoundly grateful for your bravery" +
                                        "$space and selflessness. May your name be forever anshrined in the chronicles of our history.\t\t$space"
                            )

                            // Wenn Helden besiegt sind print
                        } else if (!hero.alive && finalVillain.alive) {
                            println("$space ${finalVillain.name} defeated ${hero.name}!")
                            println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||Game Over||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||")
                        }
                    }
                }
            }
        }
    }
    fun villainsTurn(heroes: List<Hero>, hero: Hero) {
        if (firstVillain.alive && hero.alive) {
            firstVillain.attack(heroes)
        } else if (!hero.alive && finalVillain.alive) {
            when(!hero.alive) {
                hero.
            }
        }
    }
}
println("$space ${finalVillain.name} defeated ${heroes.name}!")
println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||Game Over||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||")