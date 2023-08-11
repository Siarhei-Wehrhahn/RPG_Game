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
import Villains.Villain

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

    var heroes = mutableListOf(magician, warrior, kentaur)
    var firstVillain = satyr
    var finalVillain = zyklop

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
    while (heroes.all { it.alive } && firstVillain.alive) {
        for (hero in heroes) {
            if (hero.alive && firstVillain.alive) {
                hero.putOut(firstVillain)
                villainsTurn(heroes, firstVillain, finalVillain)

                // Wenn heroes besiegt dan print
            } else if (!hero.alive && firstVillain.alive) {
                println("${firstVillain.name} defeated ${hero.name}!")
                villainsTurn(heroes, firstVillain, finalVillain)

                // Wenn bösewicht besiegt dann zum endgegner weiter
            } else if (hero.alive) {
                println("${hero.name} defeated ${firstVillain.name}!")
                hero.putOut(finalVillain)
                villainsTurn(heroes, firstVillain, finalVillain)

                // Solange alle am leben sind geht das spiel
                while (heroes.all { it.alive } && finalVillain.alive) {
                    for (hero in heroes) {
                        if (hero.alive && finalVillain.alive) {
                            hero.putOut(finalVillain)
                            villainsTurn(heroes, firstVillain, finalVillain)

                            // Wenn Bösewicht besiegt ist print
                        } else if (hero.alive) {
                            println("${hero.name} defeated ${finalVillain.name}!")

                            // Text von Chat GPT
                            println(
                                "$space Horray, you have defeated the beasts! Our castle is saved, and you are our hero. Your courage" +
                                        "$space and determination have spared  us from disaster. We are profoundly grateful for your bravery" +
                                        "$space and selflessness. May your name be forever anshrined in the chronicles of our history.\t\t$space"
                            )

                            // Wenn Helden besiegt sind print
                        } else if (finalVillain.alive) {
                            println("$space ${finalVillain.name} defeated ${hero.name}!")
                            println("Oh no, ${hero.name} is dead!")
                            heroes.remove(hero)
                        }
                    }
                }
            }
        }
    }
}
    fun villainsTurn(heroes: List<Hero>, firstVillain: Villain, finalVillain: Villain) {
        if (firstVillain.alive && heroes.all { it.alive }) {
            firstVillain.evilAttack(heroes.random())
        } else if (!firstVillain.alive && heroes.all { it.alive }) {
          finalVillain.evilAttack(heroes.random())
        } else if (!heroes.all { it.alive } && firstVillain.alive) {
            println("$space ${finalVillain.name} defeated all Heroes!")
            println("Game Over!")
        }
    }
