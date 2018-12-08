package zo.den.testtask2.presentation.ui

import com.arellomobile.mvp.InjectViewState
import io.reactivex.functions.Consumer
import ru.terrakok.cicerone.Router
import zo.den.testtask2.data.dao.OrderDao
import zo.den.testtask2.presentation.ScreenFactory
import zo.den.testtask2.presentation.base.MoxyPresenter
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject constructor() : MoxyPresenter<MainView>(){
    @Inject
    @field:MainQualififer
    lateinit var router: Router

    @Inject
    lateinit var orderDao: OrderDao

    fun onCreate(isRestore: Boolean) {
        if (!isRestore)
            orderDao.getOrders().subscribe(Consumer{
                    router.newRootScreen(ScreenFactory.getOrderScreen())
            }).toCompositeDisposable()
    }
}