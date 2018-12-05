package zo.den.testtask2.data.dao.impl

import io.reactivex.Observable
import zo.den.testtask2.data.dao.OrderDao
import zo.den.testtask2.data.dto.OrderDto
import zo.den.testtask2.data.mapper.OrderDtoMapper
import zo.den.testtask2.data.network.api.OrdersApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OrdersDaoImpl @Inject constructor(): OrderDao {
    @Inject
    lateinit var ordersApi: OrdersApi

    @Inject
    lateinit var orderDao: OrderDao

    override fun getOrder(id: Int?): Observable<OrderDto> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getOrders(): Observable<OrderDto> {
        return orderDao.getOrders().flatMap { ordersApi.getOrders(
                it.id,
                it.startAddress,
                it.endAddress,
                it.price,
                it.orderTime,
                it.vehicle
        ) }

    }
}