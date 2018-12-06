package zo.den.testtask2.data.network.api

import io.reactivex.Single
import zo.den.testtask2.data.network.pojo.orders.Order
import zo.den.testtask2.data.network.pojo.orders.Vehicle
import zo.den.testtask2.data.network.service.OrdersService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OrdersApi @Inject constructor(private val ordersService: OrdersService){
    fun getOrders(): Single<Order> {
        return ordersService.getOrders()
    }
    fun getImageAuto(url: String): Single<Order> {

        return ordersService.getImageAuto(url)
    }

}