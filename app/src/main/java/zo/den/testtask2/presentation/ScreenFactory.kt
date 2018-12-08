package zo.den.testtask2.presentation

import ru.terrakok.cicerone.android.support.SupportAppScreen
import zo.den.testtask2.presentation.ui.order.OrderScreen

object ScreenFactory {
    fun getOrderScreen(): SupportAppScreen
    {
        return OrderScreen()
    }
}