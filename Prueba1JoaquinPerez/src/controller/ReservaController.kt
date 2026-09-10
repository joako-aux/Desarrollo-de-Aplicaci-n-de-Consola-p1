package controller

import model.ReservaAlojamiento
import model.TipoAlojamiento
import service.ReservaService

class ReservaController(
    private val service: ReservaService
) {

    fun registrar(reserva: ReservaAlojamiento) {
        try {
            val registrada = service.registrar(reserva)
            println("Reserva registrada correctamente: ${registrada.id}")
        } catch (e: IllegalArgumentException) {
            println("Error de validación al registrar reserva: ${e.message}")
        } catch (e: Exception) {
            println("Ocurrió un error inesperado: ${e.message}")
        }
    }

    fun mostrarReservas() {

        val reservas = service.obtenerReservas()

        println("\n========== RESERVAS ==========")

        reservas.forEach { reserva ->

            println("ID: ${reserva.id}")
            println("Cliente: ${reserva.nombreCliente}")
            println("Noches: ${reserva.cantidadNoches}")
            println("Valor por noche: ${reserva.valorPorNoche}")
            println("Personas: ${reserva.personas}")
            println("Tipo: ${reserva.tipo.descripcion()}")
            println("Total: ${reserva.valorTotal()}")
            println("Descripción: ${reserva.descripcion()}")
            println("------------------------------")
        }
    }

    fun mostrarTotal() {
        println("Total recaudado: ${service.calcularTotal()}")
    }

    fun mostrarReservasPorTipo(tipo: TipoAlojamiento) {

        val reservas = service.obtenerReservasPorTipo(tipo)

        println("\n========== RESERVAS DE TIPO ${tipo.descripcion().uppercase()} ==========")

        if (reservas.isEmpty()) {
            println("No se encontraron reservas para este tipo de alojamiento.")
        } else {
            reservas.forEach { reserva ->
                println("ID Reserva     : ${reserva.id}")
                println("Cliente        : ${reserva.nombreCliente}")
                println("Tipo Alojamiento: ${reserva.tipo.descripcion()}")
                println("Noches         : ${reserva.cantidadNoches}")
                println("Personas       : ${reserva.personas}")
                println("Valor por noche: \$${reserva.valorPorNoche}")
                println("Total          : \$${reserva.valorTotal()}")
                println("Descripción    : ${reserva.descripcion()}")
                println("----------------------------------------------")
            }
        }
    }
}