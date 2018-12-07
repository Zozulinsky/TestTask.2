package zo.den.testtask2.data.dao

import io.reactivex.Observable
import zo.den.testtask2.data.network.pojo.orders.Order

interface OrderDao {
    fun getOrders(): Observable<Order>
}