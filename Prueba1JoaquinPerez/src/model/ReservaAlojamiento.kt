package model

data class ReservaAlojamiento(
    val idReserva: Int,
    val cliente: String,
    val noches: Int,
    val valorPorNoche: Int,
    val personas: Int,
    val tipo: TipoAlojamiento
) : Reserva(idReserva, cliente, noches) {

    fun valorTotal(): Int {
        return valorPorNoche * noches
    }

    override fun descripcion(): String {
        return "Reserva de ${tipo.descripcion()} para $personas persona(s)"
    }
}