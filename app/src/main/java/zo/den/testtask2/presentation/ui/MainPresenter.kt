package zo.den.testtask2.presentation.ui

import com.arellomobile.mvp.InjectViewState
import ru.terrakok.cicerone.Router
import zo.den.testtask2.presentation.ScreenFactory
import zo.den.testtask2.presentation.base.MoxyPresenter
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor() : MoxyPresenter<MainView>() {
    @Inject
    @field:MainQualifier
    lateinit var router: Router


    fun onCreate(isRestore: Boolean) {
        if (!isRestore){
            router.newRootScreen(ScreenFactory.getOrderScreen())

        }


    }
}