package zo.den.testtask2.data.network.pojo.orders

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import io.reactivex.annotations.NonNull

class Price {

    @SerializedName("amount")
    @Expose
    var amount: Int? = null
    @SerializedName("currency")
    @Expose
    var currency: String? = null

    override fun toString(): String {
        var amountInRub: Float = 0f
        val amount = amount
        if (amount!= null)
        amountInRub= amount.toFloat()/100
        return amountInRub.toString()+ " " + currency

    }

}
