package zo.den.testtask2.data.network.pojo.orders

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Order {

    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("startAddress")
    @Expose
    var startAddress: StartAddress? = null
    @SerializedName("endAddress")
    @Expose
    var endAddress: EndAddress? = null
    @SerializedName("price")
    @Expose
    var price: Price? = null
    @SerializedName("orderTime")
    @Expose
    var orderTime: String? = null
    @SerializedName("vehicle")
    @Expose
    var vehicle: Vehicle? = null

}
