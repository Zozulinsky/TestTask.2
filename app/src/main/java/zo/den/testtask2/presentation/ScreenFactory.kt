package zo.den.testtask2.presentation

import ru.terrakok.cicerone.android.support.SupportAppScreen
import zo.den.testtask2.presentation.model.OrderModel
import zo.den.testtask2.presentation.ui.detailsoforder.DetailsScreen
import zo.den.testtask2.presentation.ui.order.OrderScreen

object ScreenFactory {
    fun getOrderScreen(): SupportAppScreen
    {
        return OrderScreen()
    }

    fun getDetailsScreen(orderModel: OrderModel): SupportAppScreen
    {
        return DetailsScreen(orderModel)
    }
}