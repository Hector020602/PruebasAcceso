package Tema3

import com.squareup.moshi.*
import java.io.File

class Empleats(val empleats: List<Empleat> = listOf<Empleat>())
class Empresa(val empresa: Empleats)

fun main (args: Array<String>){
    val json = File("Empresa.json").readText()

    val moshi = Moshi.Builder().build()
    val adapter = moshi.adapter(Empresa::class.java)
    val empresa = adapter.fromJson(json)

    val llEmpleats= empresa!!.empresa.empleats
    println("Hi ha " + llEmpleats.size + " empleats:")
    for (e in llEmpleats)
        println(e.nom + " (" + e.sou  +")")
}