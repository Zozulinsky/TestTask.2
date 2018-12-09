package zo.den.testtask2.presentation.ui.detailsoforder

import android.support.v4.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen
import zo.den.testtask2.presentation.ui.order.OrderFragment

class DetailsScreen  : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return DetailsFragment.getInstance()
    }

    override fun getScreenKey(): String {
        return DetailsFragment::class.java.name
    }
}