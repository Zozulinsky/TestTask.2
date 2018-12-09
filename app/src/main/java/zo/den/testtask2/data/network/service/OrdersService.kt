package zo.den.testtask2.data.network.service

import io.reactivex.Single
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path
import zo.den.testtask2.data.network.pojo.orders.Order
import zo.den.testtask2.data.network.pojo.orders.OrderResponse

interface OrdersService {
    @GET("orders.json")
    fun getOrders() : Single<MutableList<Order>>

    @GET("images/{imageName}")
    fun getImageAuto(@Path("imageName")imageName: String): Single<ResponseBody>
}