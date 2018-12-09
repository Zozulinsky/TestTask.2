package zo.den.testtask2.data.dao.impl

import io.reactivex.Observable
import zo.den.testtask2.data.dao.OrderDao
import zo.den.testtask2.data.network.api.OrdersApi
import zo.den.testtask2.data.network.pojo.orders.Order
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OrdersDaoImpl @Inject constructor() : OrderDao {
    @Inject
    lateinit var ordersApi: OrdersApi

    override fun getOrders(): Observable<Order> {
        return ordersApi.getOrders()
                .flatMapObservable {
                    Observable.fromIterable(it)
                }

    }

}