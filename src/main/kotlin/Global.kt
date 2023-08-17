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
import kotlin.concurrent.thread

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


var gold = 55550

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



// Hier werden die dateipfade von den audios inizialisiert
val gameOverSound = "src/main/kotlin/audio/Game Over.wav"
val goldGift = "src/main/kotlin/audio/coin Gift.wav"
val sword = "src/main/kotlin/audio/sword.wav"
val magic = "src/main/kotlin/audio/magic.wav"
val kentauraudio = "src/main/kotlin/audio/kentaurSound.wav"
val takeDamage = "src/main/kotlin/audio/takeDamage.wav"
val introSpeech = "src/main/kotlin/audio/introText.wav"
val healDrink = "src/main/kotlin/audio/healDrink.wav"
val protectiveSpell = "src/main/kotlin/audio/protectiveSpell.wav"
val shop = "src/main/kotlin/audio/shop.wav"
val openBag = "src/main/kotlin/audio/openBag.wav"


// Fun zum laden und abspielen eines Soundeffekts
fun playSound(soundFile: String) {
    // Definiere die gewünschte Lautstärke für den Sound
    var volFloat = 0.66f

    // Mit Thread starte ich Multitasking
    thread {
        // Erstelle einen AudioInputStream aus der Sounddatei
        val stream = AudioSystem.getAudioInputStream(java.io.File(soundFile))

        // Erstelle ein Clip-Objekt für die Audiowiedergabe
        val clip = AudioSystem.getClip()

        // Öffne den Clip und lade den AudioInputStream
        clip.open(stream)

        // Hole die Lautstärke-Steuerung und setze die gewünschte Lautstärke
        val vol = clip.getControl(FloatControl.Type.MASTER_GAIN) as FloatControl
        vol.value = vol.minimum + (volFloat * (vol.maximum - vol.minimum))

        // Starte die Audiowiedergabe
        clip.start()

        // Pausiere den Thread für die Dauer der Audiowiedergabe
        Thread.sleep(clip.microsecondLength / 1000)

        // Stoppe die Audiowiedergabe
        clip.stop()

        // Schließe den Clip und den Stream, um Ressourcen freizugeben
        clip.close()
        stream.close()
    }
}


fun playBackgroundIntroSound() {

    var volFloat = 0.50f

    var soundFile = "src/main/kotlin/audio/introSound.wav"

    thread {
        val stream = AudioSystem.getAudioInputStream(java.io.File(soundFile))
        val clip = AudioSystem.getClip()
        clip.open(stream)
        val vol = clip.getControl(FloatControl.Type.MASTER_GAIN) as FloatControl
        vol.value = vol.minimum + (volFloat * (vol.maximum - vol.minimum))
        clip.start()
        Thread.sleep(clip.microsecondLength / 1000)
        clip.stop()
        clip.close()
        stream.close()
    }
}

fun playBackgroundSound() {

    var volFloat = 0.66f

    var soundFile = "src/main/kotlin/audio/backgroundSound.wav"

    thread {
        val stream = AudioSystem.getAudioInputStream(java.io.File(soundFile))
        val clip = AudioSystem.getClip()
        clip.open(stream)
        val vol = clip.getControl(FloatControl.Type.MASTER_GAIN) as FloatControl
        vol.value = vol.minimum + (volFloat * (vol.maximum - vol.minimum))
        clip.loop(2)

    }
}