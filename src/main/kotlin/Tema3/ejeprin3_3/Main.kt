package Tema3.ejeprin3_3

import Tema3.ejeprin3_2.Ruta
import java.io.EOFException
import java.io.FileInputStream
import java.io.ObjectInputStream
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.OutputKeys
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult

fun main() {
    val f = ObjectInputStream(FileInputStream("Rutes.obj")) //leer obj


    val doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument() //crea el builder
    val arrel = doc.createElement("rutes") //primer nodo
    doc.appendChild(arrel) //añade el primer nodo
    try {
        while (true) {
            val e = f.readObject () as Ruta  //ccmienza a leer de ruta y lo almacena en e


            val ru = doc.createElement("ruta")  //segundo nodo, solo le crea, para cerrarlo mas tarde




            val nom = doc.createElement("nom") // a partir de aqui lee y escribe
            nom.appendChild(doc.createTextNode(e.nom)) // forma llarga: afegim un fill que és un node de text
            ru.appendChild(nom)


            val desniv = doc.createElement("desnivell")
            desniv.setTextContent(e.desnivell.toString()) // forma curta: amb setTextContent() li posem contingut
            ru.appendChild(desniv)


            val desnivAcum = doc.createElement("desnivellAcumulat")
            desnivAcum.setTextContent(e.desnivellAcumulat.toString())
            ru.appendChild(desnivAcum)


            val punts = doc.createElement("punts");
            val numPunts = e.size()


            for (i in 0 until numPunts) { //bucle con los puntos
                val punt = doc.createElement("punt")
                punt.setAttribute("num", (i + 1).toString())
                punts.appendChild(punt)


                val puntNom = doc.createElement("nom")
                puntNom.setTextContent(e.getPuntNom(i))
                punt.appendChild(desnivAcum)


                val lat = doc.createElement("latitud")
                lat.setTextContent(e.getPuntLatitud(i).toString())
                punt.appendChild(lat)


                val long = doc.createElement("longitud")
                long.setTextContent(e.getPuntLongitud(i).toString())
                punt.appendChild(long)


                punts.appendChild(punt) //se añade a puntos
            }


            arrel.appendChild(ru) //se cierra ruta
            ru.appendChild(punts) // se cierra rutas
        }


    } catch (eof: EOFException) {
        f.close()
    }


    val trans = TransformerFactory.newInstance().newTransformer()
    trans.setOutputProperty(OutputKeys.INDENT, "yes")
    trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2")
    trans.transform(DOMSource(doc), StreamResult("Rutes.xml")) // se llama al archivo
}
