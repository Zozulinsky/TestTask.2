package zo.den.testtask2.presentation.ui.order

import android.support.v4.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen
import zo.den.testtask2.presentation.ui.order.OrderFragment

class OrderScreen : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return OrderFragment()
    }
}