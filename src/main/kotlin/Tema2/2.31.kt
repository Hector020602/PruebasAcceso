package Tema2

import java.io.FileWriter

fun main(args: Array<String>) {
    val text = "Esto es lo que saldra en el archivo f5"
    val f_out = FileWriter("f5.txt",true)
    for (c in text) {
        f_out.write(c.toInt())
    }
    f_out.close()
}