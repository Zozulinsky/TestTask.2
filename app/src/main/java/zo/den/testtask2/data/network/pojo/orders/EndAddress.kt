package zo.den.testtask2.data.network.pojo.orders

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class EndAddress {

    @SerializedName("city")
    @Expose
    var city: String? = null
    @SerializedName("address")
    @Expose
    var address: String? = null

}
