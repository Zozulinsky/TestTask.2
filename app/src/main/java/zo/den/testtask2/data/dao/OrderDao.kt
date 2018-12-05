package zo.den.testtask2.data.dao

import io.reactivex.Observable
import zo.den.testtask2.data.dto.OrderDto

interface OrderDao {
    fun getOrder(id: Int?): Observable<OrderDto>
    fun getOrders(): Observable<OrderDto>
}