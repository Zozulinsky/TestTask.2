package zo.den.testtask2.presentation.ui.order

import com.arellomobile.mvp.InjectViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.terrakok.cicerone.Router
import zo.den.testtask2.data.dao.OrderDao
import zo.den.testtask2.presentation.ScreenFactory
import zo.den.testtask2.presentation.base.MoxyPresenter
import zo.den.testtask2.presentation.mapper.OrderModelMapper
import zo.den.testtask2.presentation.model.OrderModel
import zo.den.testtask2.presentation.ui.MainQualifier
import javax.inject.Inject

@InjectViewState
class OrderPresenter @Inject constructor() : MoxyPresenter<OrderView>(){
    @field:Inject
    lateinit var orderDao: OrderDao

    @Inject
    @field:MainQualifier
    lateinit var router: Router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        orderDao.getOrders()
                .map(OrderModelMapper())
                .toList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    viewState.showOrderList(it)
                },{
                    it.printStackTrace()
                }).toCompositeDisposable()
    }

    fun onOrder(orderModel: OrderModel) {
        router.navigateTo(ScreenFactory.getDetailsScreen(orderModel))
    }


}