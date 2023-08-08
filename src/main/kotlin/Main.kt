// * =========================================================
// * =========== Projekt RPG-Game =================
// * =========================================================
// * Current Version 1.0
// * =========================================================
// * erstellt durch: Siarhei Wehrhahn
// * =========================================================
// * Sprache : Kotlin
// * =========================================================

import Heroes.Kentaur
import Heroes.Magician
import Heroes.Warrior
import Villains.`Satyr(underboss)`
import Villains.`Cyclop(Final Boss)`

fun main() {
    val magician = Magician("Merlin", 300)
    val warrior = Warrior("Arthur", 400)
    val kentaur = Kentaur("Cyrus", 350)
    val satyr = `Satyr(underboss)`("Panos", 500)
    val zyklop = `Cyclop(Final Boss)`("Aegon",1000)

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
        // Warte 2 Sekunde zwischen den Zeilen
        if (index > 1) {
            Thread.sleep(3000)
        }
        // Drucke die Zeile und überschreibe sie mit \r
        print(line)
        if (index < introText.lines().size - 1) {
            print("\r")
        }
    }

    magician.introduceOneself()
    warrior.introduceOneself()
    kentaur.introduceOneself()
    satyr.putOut()
    zyklop.putOut()

}


//init hp undso