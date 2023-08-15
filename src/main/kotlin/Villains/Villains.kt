package Villains

import Heroes.Hero
import heroes
import space
import zyklop

open class Villain(var name: String, var hp: Int) {

    var underboss = false
    var alive = true

    open fun takeDamageEvil(damage: Int) {
        hp -= damage
        if (hp <= 0) {
            println("$space $name are dead  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  $space")

            alive = false
        } else {
            println("$space $name takes $damage damage. Remaining HP: $hp\t\t\t\t\t\t\t\t\t\t\t\t\t\t$space")
        }
    }

    open fun attack(hero: Hero){
    }

    // Angriffe für den Zyklopen (Endgegner)
    open fun evilAttack(hero: Hero) {
        if (!hero.isProtected) {
            val randomNumber: Int = (0..150).random()
            hero.takeDamage(randomNumber)
            println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$name attacks ${hero.name} for $randomNumber damage! $space")
            if (randomNumber == 0) {
                println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$name's attack missed! $space")
            } else if ((randomNumber > 1) && (randomNumber < 50)) {
                println("$space  \t\t\t\t \t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was weak! $space")
            } else if ((randomNumber > 50) && (randomNumber < 100)) {
                println("$space  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was good! $space")
            } else if (randomNumber > 100) {
                println("$space \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was strong! $space")
            }
            println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
        }
    }

    // Es wird ein helfer gerufen der schutz bietet und angreift
    open fun underUnderBoss() {
        if (!underboss) {
            println("$space														\t\tA hellhound has come to the rescue $space")
            hp += 200
        }
    }

    // Kleiner Flächenschaden wegen stampfer
    open fun stomper(hero: Hero) {
        println("$space Feel the earth tremble beneath my might!$space")
        val randomNumber: Int = (0..100).random()
        hero.allTakeDamage(heroes, randomNumber)
        println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$name attacks ${hero.name} for $randomNumber damage!$space")
        if (randomNumber == 0) {
            println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$name's attack missed! $space")
        } else if ((randomNumber > 1) && (randomNumber < 50)) {
            println("$space  \t\t\t\t \t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was weak! $space")
        } else if ((randomNumber > 50) && (randomNumber < 100)) {
            println("$space  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was good! $space")
        } else if (randomNumber > 100) {
            println("$space \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was strong! $space")
        }
        println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
    }

    // Wirft großen stein auf seine gegner
    open fun boulderHurl(hero: Hero) {
        println("$space Witness the power of flying boulders!$space")
        val randomNumber: Int = (0..175).random()
        hero.allTakeDamage(heroes, randomNumber)
        println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$name attacks ${hero.name} for $randomNumber damage! $space")
        if (randomNumber == 0) {
            println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$name's attack missed! $space")
        } else if ((randomNumber > 1) && (randomNumber < 70)) {
            println("$space  \t\t\t\t \t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was weak! $space")
        } else if ((randomNumber > 70) && (randomNumber < 130)) {
            println("$space  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was good! $space")
        } else if (randomNumber > 130) {
            println("$space \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was strong! $space")
        }
        println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
    }

    // Durch schlag auf boden, entsteht ein Erbeben was einen größeren Schaden anrichtet wie stomper()
    open fun quakeCall(hero: Hero) {
        println("$space Bow before the earth's fury!$space")
        val randomNumber: Int = (0..150).random()
        hero.allTakeDamage(heroes, randomNumber)
        println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$name attacks ${hero.name} for $randomNumber damage! $space")
        if (randomNumber == 0) {
            println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$name's attack missed! $space")
        } else if ((randomNumber > 1) && (randomNumber < 50)) {
            println("$space  \t\t\t\t \t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was weak! $space")
        } else if ((randomNumber > 50) && (randomNumber < 100)) {
            println("$space  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was good! $space")
        } else if (randomNumber > 100) {
            println("$space \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was strong! $space")
        }
        println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
    }

    // Auge schießt feurige Energie, die bei kontakt zu verbrennungen führt
    open fun fieryGaze(hero: Hero) {
        println("$space Burn in the flames of my gaze!$space")
        val randomNumber: Int = (0..200).random()
        hero.takeDamage(randomNumber)
        println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$name attacks ${hero.name} for $randomNumber damage! $space")
        if (randomNumber == 0) {
            println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$name's attack missed! $space")
        } else if ((randomNumber > 1) && (randomNumber < 100)) {
            println("$space  \t\t\t\t \t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was weak! $space")
        } else if ((randomNumber > 100) && (randomNumber < 150)) {
            println("$space  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was good! $space")
        } else if (randomNumber > 150) {
            println("$space \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was strong! $space")
        }
        println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
    }

    // Zyklop fesselt die gegner während er sich auf eine andere fähigkeit konzentriert (Helden setzen 1 runde aus)
    open fun chainBind(hero: Hero) {
        println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tBound by unbreakable chains! $space")
        hero.allTakeDamage(heroes, 20)
        println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tThe heroes are bound! $space")
        zyklop.attack(hero)
    }

    // Zyklop feuert gewaltige Energy aus seinem Auge, welche bis zu 500 Schaden anrichtet aber auch 200 bei sich selbst.
    open fun wrathOfTheGods(hero: Hero) {
        println("$space Behold the wrath of the gods unleashed!$space")
        val randomNumber: Int = (0..500).random()
        hp -= 200
        hero.takeDamage(randomNumber)
        println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$name attacks ${hero.name} for $randomNumber damage! $space")
        if (randomNumber == 0) {
            println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$name's attack missed! $space")
        } else if ((randomNumber > 1) && (randomNumber < 150)) {
            println("$space  \t\t\t\t \t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was weak! $space")
        } else if ((randomNumber > 150) && (randomNumber < 350)) {
            println("$space  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was good! $space")
        } else if (randomNumber > 350) {
            println("$space \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was strong! $space")
        }
        println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
    }

    // Angriffe für den Satyr
    // Doppelhuf sorgt für einen Erdstoß, der den Gegner trifft
    open fun doubleHoofStrike(hero: Hero) {
        println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tFeel the thunder of my hooves! $space")
        val randomNumber: Int = (0..75).random()
        hero.takeDamage(randomNumber)
        println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$name attacks ${hero.name} for $randomNumber damage! $space")
        if (randomNumber == 0) {
            println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$name's attack missed! $space")
        } else if ((randomNumber > 1) && (randomNumber < 20)) {
            println("$space  \t\t\t\t \t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was weak! $space")
        } else if ((randomNumber > 20) && (randomNumber < 40)) {
            println("$space  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was good! $space")
        } else if (randomNumber > 40) {
            println("$space \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was strong! $space")
        }
        println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
    }

    // Flötenzauber raubt die lebensenergie
    open fun fluteEnchantment(hero: Hero) {
        println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Dance to the melody of enchantment! $space")
        val randomNumber: Int = (0..50).random()
        hero.allTakeDamage(heroes, randomNumber)
        println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$name attacks ${hero.name} for $randomNumber damage! $space")
        if (randomNumber == 0) {
            println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$name's attack missed! $space")
        } else if ((randomNumber > 1) && (randomNumber < 20)) {
            println("$space  \t\t\t\t \t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was weak! $space")
        } else if ((randomNumber > 20) && (randomNumber < 30)) {
            println("$space  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was good! $space")
        } else if (randomNumber > 30) {
            println("$space \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was strong! $space")
        }
        println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
    }

    // Waldes fluch entfesselt einen fluch, der Pflanzen und Tiere auf die Feinde losgehen lässt
    open fun forestCurse(hero: Hero) {
        println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tNative's wrath shall be your undoing! $space")
        val randomNumber: Int = (0..100).random()
        hero.allTakeDamage(heroes, randomNumber)
        println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$name attacks ${hero.name} for $randomNumber damage! $space")
        if (randomNumber == 0) {
            println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$name's attack missed! $space")
        } else if ((randomNumber > 1) && (randomNumber < 25)) {
            println("$space  \t\t\t\t \t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was weak! $space")
        } else if ((randomNumber > 25) && (randomNumber < 65)) {
            println("$space  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was good! $space")
        } else if (randomNumber > 65) {
            println("$space \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was strong! $space")
        }
        println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
    }

    // Panischer schrei versetzt Furcht und Panik in die Herzen der Gegner
    open fun panicCry(hero: Hero) {
        println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tTremble in the grip of fear! $space")
        val randomNumber: Int = (0..30).random()
        hero.allTakeDamage(heroes, randomNumber)
        println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$name attacks ${hero.name} for $randomNumber damage! $space")
        if (randomNumber == 0) {
            println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$name's attack missed! $space")
        } else if ((randomNumber > 1) && (randomNumber < 10)) {
            println("$space  \t\t\t\t \t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was weak! $space")
        } else if ((randomNumber > 10) && (randomNumber < 20)) {
            println("$space  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was good! $space")
        } else if (randomNumber > 20) {
            println("$space \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was strong! $space")
        }
        println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
    }

    // Äther beschwörung bring Kräfte aus anderen Dimmensionen zum Satyr
    open fun aetherConjuring(hero: Hero) {
        println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tFrom beyond the realms, I summon! $space")
        val randomNumber: Int = (0..50).random()
        hero.takeDamage(randomNumber)
        println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$name attacks ${hero.name} for $randomNumber damage! $space")
        if (randomNumber == 0) {
            println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$name's attack missed! $space")
        } else if ((randomNumber > 1) && (randomNumber < 10)) {
            println("$space  \t\t\t\t \t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was weak! $space")
        } else if ((randomNumber > 10) && (randomNumber < 20)) {
            println("$space  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was good! $space")
        } else if (randomNumber > 35) {
            println("$space \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was strong! $space")
        }
        println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
    }

    // Satyrischer Sturm beschwört einen Sturm herbei, der alle gegner wegfegt
    open fun satyricTempest(hero: Hero) {
        println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tUnleash the storm of a wild heart! $space")
        val randomNumber: Int = (0..80).random()
        hero.allTakeDamage(heroes, randomNumber)
        println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$name attacks ${hero.name} for $randomNumber damage! $space")
        if (randomNumber == 0) {
            println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t$name's attack missed! $space")
        } else if ((randomNumber > 1) && (randomNumber < 20)) {
            println("$space  \t\t\t\t \t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was weak! $space")
        } else if ((randomNumber > 20) && (randomNumber < 50)) {
            println("$space  \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was good! $space")
        } else if (randomNumber > 50) {
            println("$space \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t $name's attack was strong! $space")
        }
        println("$space\u001B[33m-----------------------------------------------------------------------------------------------\u001B[0m$space")
    }

    open fun info() {
        println("$space\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t $name have $hp $space")
    }

    open fun isAlive() {
        if (hp > 0) {
            alive = true
        } else {
            alive = false
        }
    }

}