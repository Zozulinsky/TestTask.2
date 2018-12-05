package zo.den.testtask2.data.mapper

import io.reactivex.functions.Function
import zo.den.testtask2.data.dto.OrderDto
import zo.den.testtask2.data.network.pojo.orders.Order

class OrderDtoMapper : Function<Order, OrderDto> {
    override fun apply(t: Order): OrderDto {
        return OrderDto(
                t.id!!,
                t.startAddress.toString()!!,
                t.endAddress.toString()!!,
                t.price.toString()!!,
                t.orderTime!!,
                t.vehicle!!
        )
    }
}