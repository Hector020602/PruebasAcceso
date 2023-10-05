package Tema2

import java.io.File

fun main() {
    val text = "Contingut per al fitxer. Ara ja sense por a caràcters especials: ç, à, ù, ..."
    File("f5.txt").writeText(text)
}