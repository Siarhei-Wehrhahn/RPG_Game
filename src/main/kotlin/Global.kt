
import Heroes.Hero
import Heroes.Kentaur
import Heroes.Magician
import Heroes.Warrior
import Villains.`Cyclop(Final Boss)`
import Villains.`Satyr(underboss)`
import Villains.Villain
import java.io.File
import javax.sound.sampled.AudioSystem
import javax.sound.sampled.Clip
import javax.sound.sampled.FloatControl

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


var gold = 0

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


fun villainsTurn(heroes: MutableList<Hero>, firstVillain: Villain, finalVillain: Villain) {
    if (firstVillain.alive && heroes.any { it.alive }) {
        firstVillain.attack(heroes.filter { it.alive }.random())
    } else if (!firstVillain.alive && heroes.any { it.alive }) {
        finalVillain.attack(heroes.filter { it.alive }.random())
    }
}

fun surprise(hero: MutableList<Hero>) {
    println("$space Congratulations! You have defeated the satyr and discovered 500 gold coins in his pockets \t$space")
    Thread.sleep(1500)
    // Füge das Gold  hinzu
    gold += 500
    playSound(goldGift)
    println("$space +500 Gold the heroes\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
    Thread.sleep(1500)
    // Heile alle Helden auf volle Gesundheit
    for (hero in heroes) {
        hero.hp = hero.MAX_HP
    }
    println("$space All Heroes are fully healed!\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
    Thread.sleep(1500)
    println("$space Thanks to you, we are now safe and we gift you a Healing Potion as a token of our gratitude $space")
    bag.add("Healing Potion")
    println("$space +Healing Potion\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")

    println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
    Thread.sleep(1500)
}

fun status(heroes: List<Hero>) {
    println("$space\t\t\t\t\t╔═════════════════════════════════════════════════════╗\t\t\t\t\t\t$space")
    for (hero in heroes) {
        println("$space \t\t\t\t\t║ ${hero.name} Health: ${hero.hp} / ${hero.MAX_HP}\t\t\t\t\t\t\t║\t\t\t\t\t$space")
    }
    println("$space\t\t\t\t\t║ Gold: $gold                                      \t  ║  \t\t\t\t\t$space")
    println("$space \t\t\t\t\t╚═════════════════════════════════════════════════════╝\t\t\t\t\t\t$space")
}

// Hier werden die dateipfade von den audios inizialisiert
val gameOverSound = "src/main/kotlin/audio/Game Over.wav"
val goldGift = "src/main/kotlin/audio/coin Gift.wav"
val sword = "src/main/kotlin/audio/sword.wav"
val magic = "src/main/kotlin/audio/magic.wav"
val kentauraudio = "src/main/kotlin/audio/kentaurSound.wav"
val takeDamage = "src/main/kotlin/audio/takeDamage.wav"
//val introSpeech = "src/main/kotlin/audio/intro.wav"

// Fun zum laden und abspielen eines Soundeffekts
fun playSound(audioOrdner: String) {
    // Erstelle eine Datei aus dem angegebenen Dateipfad
    val audio = File(audioOrdner)

    // Hier wird die audio in das Audiosystem gepackt
    val audioInput = AudioSystem.getAudioInputStream(audio)

    // es wird ein Clip-Objekt erstellt um den Sound abzuspielen
    val clip: Clip = AudioSystem.getClip()

    // Öffne den Clip und lade die audio
    clip.open(audioInput)


    // Starte die Wiedergabe des Sounds
    clip.start()
    val vol = clip.getControl(FloatControl.Type.MASTER_GAIN) as FloatControl
    vol.value = vol.minimum+(0.66f*(vol.maximum-vol.minimum))


}
