package zo.den.testtask2.presentation.ui

import android.support.v4.app.Fragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class OrderScreen : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return OrderFragment.getInstance()
    }
}