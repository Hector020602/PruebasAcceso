package Tema1.ejeprin

import java.io.File
import java.util.*


fun main(args: Array<String>) {
    var directoriActual = File.listRoots()[0]
    val scanner = Scanner(System.`in`)
    while (true) {
        llistaContingutDelDirectori(directoriActual)
        println("Directori actual: " + directoriActual.absolutePath)
        println("Per favor, introdueix un número (-1 per acabar, 0 per anar al directori pare): ")
        val opcio = scanner.nextInt()
        if (opcio == -1) {
            break
        } else if (opcio == 0) {
            val directoriPare = directoriActual.parentFile
            if (directoriPare != null && directoriPare.exists() && directoriPare.isDirectory) {
                directoriActual = directoriPare
            } else {
                println("No es pot accedir al directori pare")
            }
        } else {
            val contingutDirectori = directoriActual.listFiles()
            if (opcio >= 1 && opcio <= contingutDirectori.size) {
                val seleccio = contingutDirectori[opcio - 1]
                if (seleccio.isDirectory) {
                    if (seleccio.canRead()) {
                        directoriActual = seleccio
                    } else {
                        println("No tens permisos de lectura en este directori")
                    }
                } else {
                    println("Este no es un directori")
                }
            } else {
                println("Opció inválida. Introdueix un nombre válid")
            }
        }
    }
    System.exit(0)
}

fun llistaContingutDelDirectori(directori: File) {
    println("Contingut de " + directori.absolutePath + ":")
    val contingut = directori.listFiles()
    if (contingut != null) {
        for (i in contingut.indices) {
            val tipo =
                if (contingut[i].isDirectory) "<directori>" else java.lang.Long.toString(contingut[i].length()) + " bytes"
            println((i + 1).toString() + ". " + contingut[i].name + " [" + tipo + "]")
        }
    }
}
