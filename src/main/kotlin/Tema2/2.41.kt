package Tema2

import java.io.PrintStream
import java.io.FileOutputStream

fun main(args: Array<String>) {
    val f_out = PrintStream("f6.txt")

    val a = 5.25.toFloat()
    val b = "Hola."
    f_out.print(b)
    f_out.println("Que tal?")
    f_out.println(a + 3)
    f_out.printf("El numero %d en hexadecimal es %x",27,27)

    f_out.close()
}