package Tema3.ejeprin3_5

import java.io.Serializable

class Coordenades(var latitud: Double, var longitud: Double) : Serializable {
    companion object {
        private const val serialVersionUID: Long = 1
    }
}