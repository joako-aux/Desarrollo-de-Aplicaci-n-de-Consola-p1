package repository

import model.Reserva

class ReservaRepository {

    private val reservas = mutableListOf<Reserva>()

    fun guardar(reserva: Reserva) {
        reservas.add(reserva)
    }

    fun obtenerTodas(): List<Reserva> {
        return reservas.toList()
    }
}