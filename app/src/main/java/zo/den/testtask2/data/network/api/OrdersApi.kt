package zo.den.testtask2.data.network.api

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import io.reactivex.Single
import zo.den.testtask2.data.network.pojo.orders.OrderResponse
import zo.den.testtask2.data.network.service.OrdersService
import java.io.BufferedInputStream
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OrdersApi @Inject constructor(private val ordersService: OrdersService){
    fun getOrders(): Single<OrderResponse> {
        return ordersService.getOrders()
    }

    fun getImageAuto(url: String): Single<Bitmap>{
        return ordersService.getImageAuto(url).map {
            val buffer =BufferedInputStream(it.byteStream())
            buffer.use { stream ->
                BitmapFactory.decodeStream(stream)
            }
        }
    }


}