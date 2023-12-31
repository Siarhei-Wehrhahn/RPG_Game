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
import java.io.File
import javax.sound.sampled.AudioSystem
import javax.sound.sampled.Clip

fun main() {

// Der Nachfolgende Text ist von Chat GPT und der code für die rainbow Farbe habe ich auch dort abgeschrieben
    val winningText =
        "$space Horray, you have defeated the beasts! Our castle is saved, and you are our hero. Your courage" +
                "$space and determination have spared  us from disaster. We are profoundly grateful for your bravery" +
                "$space and selflessness. May your name be forever anshrined in the chronicles of our history."

    val rainbowColors = listOf(black, red, green, yellow, blue, purple, cyan, white, magenta)

// Hier kommt der text kombiniert mit der Farbe rein
    var rainbowText = ""

// In der schleife wird buchstabe für buchstabe genommen und mit einer Farbe kombiniert und speichert jeden buchstaben und index in der zeichenkette
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
                $star$green Welcome to 'Legends of Mystica: Chronicles of Enchantment,'$star
                $wizzard Embark on a journey where wonder and might entwine,$wr
                $kt Unveil an epic saga in 'Legends of Mystica!'$styr
                $ccps Harness your imagination, your power will shine.$friendship
                $power Are you ready to traverse the dominions of Mystica,$power
                $power Etch your legend within its chronicles divine?$x $power
                
                $attck $red A fortress under siege, dire defense required,$attck
                $castle Awaiting your command, as the heroes align.$castle
                $pergament How shall we face this impending assault,$pergament 
                $pergament Your wisdom, our guide, as the stars align bright?$pergament 
                $pergament The fate of Mystica hangs in the balance,$pergament 
                $pergament Lead us to triumph, through day and through night.$x $pergament 
        """

    playBackgroundIntroSound()
    println("")
    println(titel)

    Thread.sleep(10000)
    playBackgroundSound()
    playSound(introSpeech)

// Splitte den Text in Zeilen und gehe durch jede Zeile
    introText.lines().forEachIndexed { index, line ->
        // Warte 3 Sekunde zwischen den Zeilen
        if (index > 1) {
            Thread.sleep(2500)
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

// Solange alle Helden am Leben sind und der erste Bösewicht am Leben ist, führe die Schleife aus
    while (heroes.any { it.alive } && firstVillain.alive) {
        for (hero in heroes) {
            // Wenn der Held lebt und der erste Bösewicht am Leben ist
            if (hero.alive && firstVillain.alive) {
                // Führe Aktion des Helden aus und dann die Aktion der Bösewichte
                hero.putOut(hero.MAX_HP, firstVillain)
                villainsTurn(heroes, firstVillain, finalVillain)

                // Wenn der Held besiegt wurde, aber der Bösewicht noch am Leben ist
            } else if (!hero.alive && firstVillain.alive) {
                // Gib eine Meldung aus und führe die Aktion der Bösewichte aus
                println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  ${firstVillain.name} defeated ${hero.name}!$space")
                villainsTurn(heroes, firstVillain, finalVillain)

                // Wenn der Held lebt, aber der erste Bösewicht besiegt wurde
            } else if (hero.alive && !firstVillain.alive) {
                // Beende die Schleife, um zur nächsten Phase überzugehen
                break
            }
        }
    }

// Zeige Status der Helden an und gebe helden ein Geschenk
    surprise(heroes)

// Solange alle Helden am Leben sind und der Endgegner am Leben ist, führe die Schleife aus
    while (heroes.any { it.alive } && finalVillain.alive) {
        for (hero in heroes) {
            // Wenn der Held lebt und der Endgegner am Leben ist
            if (hero.alive && finalVillain.alive) {
                // Führe Aktion des Helden aus und dann die Aktion der Bösewichte
                hero.putOut(hero.MAX_HP, finalVillain)
                villainsTurn(heroes, firstVillain, finalVillain)

                // Wenn der Endgegner besiegt wurde
            } else if (!finalVillain.alive) {
                // Gib eine Meldung aus und beende die Schleife
                println("$space ${hero.name} defeated ${finalVillain.name}!")
                println("$space ")
                print(rainbowText)
                print("\t\t$space")
                break
            }
        }
    }

// Wenn alle Helden besiegt wurden
    if (heroes.all { !it.alive }) {
        // Spiele den "Game Over"-Sound ab und gib eine Meldung aus
        playSound(gameOverSound)
        println("$space ${finalVillain.name} defeated all Heroes!")
        println("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||${red}Game Over$x!||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||")
    }
}