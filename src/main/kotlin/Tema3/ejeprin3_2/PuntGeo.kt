package Tema3.ejeprin3_2

import java.io.Serializable

class PuntGeo(var nom: String, var coord: Coordenades) : Serializable {
    companion object {
        private const val serialVersionUID: Long = 1
    }
}