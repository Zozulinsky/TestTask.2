package zo.den.testtask2.data.network.service

import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import zo.den.testtask2.data.network.pojo.orders.Order

interface OrdersService {
    @GET("orders.json")
    fun getOrders() : Single<Order>

    @GET("images/{imageName}")
    fun getImageAuto(@Path("imageName")imageName: String): Bitmap
}