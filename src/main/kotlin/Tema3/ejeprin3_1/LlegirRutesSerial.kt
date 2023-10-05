package Tema3.ejeprin3_1

import java.io.DataInputStream
import java.io.EOFException
import java.io.FileInputStream
import java.io.RandomAccessFile

fun main() {
    val f = DataInputStream(FileInputStream("Rutes.dat"))
    while (f.available() > 0) {
        println("Ruta: " + f.readUTF())
        println("Desnivell: " + f.readInt())
        println("Desnivell acumulat: " + f.readInt())
        val punts = f.readInt()
        println("Te $punts punts")
        for (i in 1 .. punts) {
            val punt = i
            println("Punt $punt: ${f.readUTF()} ( ${f.readDouble()} , ${f.readDouble()})")
        }
        println()
    }
    f.close()
}

