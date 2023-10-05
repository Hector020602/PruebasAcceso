package exemples.Tema1

import java.io.File

fun main(args: Array<String>) {
    val f = File(".")
    System.out.println("Llista de fitxers i directoris del directori actual")
    System.out.println("---------------------------------------------------")
    for (e in f.list().sorted())
        println(e);
    if (f.exists()) {
        if (f.isDirectory()) {
            f.list()
        } else
            println("No es un directori")
    }else
        println("No existeix el directori")
}