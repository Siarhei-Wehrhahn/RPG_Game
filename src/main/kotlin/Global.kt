import Heroes.Kentaur
import Heroes.Magician
import Heroes.Warrior
import Villains.`Cyclop(Final Boss)`
import Villains.`Satyr(underboss)`

val space = "|||||||||||||||||||||||||||||||||||||"

// Unicode symbole Quelle: Chat GPT
val pergament = "\uD83D\uDCDC"
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

// Farben Quelle: https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
val x = "\u001B[0m";
val black = "\u001B[30m";
val red = "\u001B[31m";
val green = "\u001B[32m";
val yellow = "\u001B[33m";
val blue = "\u001B[34m";
val purple = "\u001B[35m";
val cyan = "\u001B[36m";
val white = "\u001B[37m"
val magenta = "\u001B[35m"

val magician = Magician("Merlin", 300)
val warrior = Warrior("Arthur", 400)
val kentaur = Kentaur("Cyrus", 350)
val satyr = `Satyr(underboss)`("Panos", 500)
val zyklop = `Cyclop(Final Boss)`("Aegon", 1000)

var heroes = mutableListOf(magician, warrior, kentaur)
var firstVillain = satyr
var finalVillain = zyklop

// Das ist die Tashe der helden
var bag: MutableList<String> = mutableListOf(
    "Healing Potion",
    "Healing Potion",
    "Healing Potion",
    "Healing Potion",
    "Vitamins",
    "Protective Potion",
    "Protective Potion",
    "Protective Potion"
)