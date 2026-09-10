package model
enum class TipoAlojamiento {
    HABITACION,
    CABANA,
    DEPARTAMENTO;

    fun descripcion(): String {return when (this) {
            HABITACION -> "Habitación"
            CABANA -> "Cabaña"
            DEPARTAMENTO -> "Departamento"
        }
    }
}