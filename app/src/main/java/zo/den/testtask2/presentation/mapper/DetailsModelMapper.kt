package zo.den.testtask2.presentation.mapper

import io.reactivex.functions.Function
import zo.den.testtask2.data.network.pojo.orders.Order
import zo.den.testtask2.data.network.pojo.orders.Vehicle
import zo.den.testtask2.presentation.model.OrderModel
import java.util.*

class DetailsModelMapper: Function<Order, OrderModel> {
    override fun apply(t: Order): OrderModel {
        val startAddress: String? = t.startAddress?.city + " " + t.startAddress?.address
        val endAddress: String? = t.endAddress?.city + " " + t.endAddress?.address
        //TODO обработать дату и время
        val dateAndTimeOfOrder: String? = t.orderTime
        val currency: Currency = Currency.getInstance(t.price?.currency)
        val amount: StringBuilder = StringBuilder()
        amount.append(t.price?.amount)
        amount.insert(amount.length - currency.defaultFractionDigits, ".")
        amount.append(" " + currency.getSymbol())
        val vehicle: Vehicle? = t?.vehicle
        val regNumber: String? = vehicle?.regNumber
        val modelName: String? = vehicle?.modelName
        //TODO исправить !!
        val photo: String = vehicle!!.photo
        val driverName: String? = vehicle?.driverName

        return OrderModel(startAddress, endAddress, dateAndTimeOfOrder,
                amount.toString(), regNumber, modelName, photo,  driverName)
    }
}