package service

import model.ReservaAlojamiento
import repository.ReservaRepository

class ReservaService(
    private val repository: ReservaRepository
) {

    fun registrar(reserva: ReservaAlojamiento): ReservaAlojamiento {
        if (reserva.id <= 0) {
            throw IllegalArgumentException("El identificador debe ser mayor que cero")
        }
        if (reserva.cliente.isBlank()) {
            throw IllegalArgumentException("El nombre del cliente no puede estar vacío")
        }
        if (reserva.noches <= 0) {
            throw IllegalArgumentException("La cantidad de noches debe ser mayor que cero")
        }
        if (reserva.valorPorNoche <= 0) {
            throw IllegalArgumentException("El valor por noche debe ser mayor que cero")
        }

        val existe = repository.obtenerTodas().any { it.id == reserva.id }
        if (existe) {
            throw IllegalArgumentException("Ya existe una reserva con el ID ${reserva.id}")
        }

        repository.guardar(reserva)
        return reserva
    }

    fun obtenerReservas(): List<ReservaAlojamiento> {
        return repository.obtenerTodas()
            .filterIsInstance<ReservaAlojamiento>()
    }

    fun calcularTotal(): Int {
        return obtenerReservas()
            .sumOf { it.valorTotal() }
    }

    fun obtenerReservasPorTipo(
        tipo: model.TipoAlojamiento
    ): List<ReservaAlojamiento> {
        return obtenerReservas()
            .filter { it.tipo == tipo }
    }
}