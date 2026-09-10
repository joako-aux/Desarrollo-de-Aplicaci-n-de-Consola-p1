import controller.ReservaController
import model.ReservaAlojamiento
import model.TipoAlojamiento
import repository.ReservaRepository
import service.ReservaService
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


fun main()= runBlocking {

    val repository = ReservaRepository()
    val service = ReservaService(repository)
    val controller = ReservaController(service)

    println("Consultando disponibilidad...")

    delay(1000)

    println("Disponibilidad consultada.\n")

    // Reserva 1
    controller.registrar(
        ReservaAlojamiento(
            idReserva = 1,
            cliente = "MOISE PERKIN",
            noches = 3,
            valorPorNoche = 45000,
            personas = 2,
            tipo = TipoAlojamiento.HABITACION
        )
    )

    // Reserva 2
    controller.registrar(
        ReservaAlojamiento(
            idReserva = 2,
            cliente = "MATIAS PERKIN",
            noches = 5,
            valorPorNoche = 60000,
            personas = 4,
            tipo = TipoAlojamiento.CABANA
        )
    )

    // Reserva 3
    controller.registrar(
        ReservaAlojamiento(
            idReserva = 3,
            cliente = "CAMILIN PERKIN",
            noches = 2,
            valorPorNoche = 80000,
            personas = 3,
            tipo = TipoAlojamiento.DEPARTAMENTO
        )
    )

    // Reserva inválida
    controller.registrar(
        ReservaAlojamiento(
            idReserva = 4,
            cliente = "",
            noches = 2,
            valorPorNoche = 50000,
            personas = 2,
            tipo = TipoAlojamiento.HABITACION
        )
    )

    // Mostrar reservas
    controller.mostrarReservas()

    // Total
    println()
    controller.mostrarTotal()

    // Consulta adicional
    controller.mostrarReservasPorTipo(
        TipoAlojamiento.HABITACION
    )

    // Demostración de polimorfismo =)
    val reserva: model.Reserva = ReservaAlojamiento(
        idReserva = 5,
        cliente = "EL LOCO CARLOS",
        noches = 2,
        valorPorNoche = 70000,
        personas = 2,
        tipo = TipoAlojamiento.CABANA
    )

    println("\n========== POLIMORFISMO ==========")
    println(reserva.descripcion())
}