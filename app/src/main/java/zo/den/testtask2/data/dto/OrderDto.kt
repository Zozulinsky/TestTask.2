package zo.den.testtask2.data.dto

import zo.den.testtask2.data.network.pojo.orders.Vehicle
import java.util.*

data class OrderDto(val id: Int,
                    val startAddress: String,
                    val endAddress: String,
                    val price: String,
                    val orderTime: String,
                    val vehicle: Vehicle
)