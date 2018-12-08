package zo.den.testtask2.presentation.ui

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import zo.den.testtask2.data.dao.OrderDao
import zo.den.testtask2.presentation.base.MoxyPresenter
import zo.den.testtask2.presentation.mapper.OrderModelMapper
import javax.inject.Inject

class OrderPresenter @Inject constructor() : MoxyPresenter<OrderView>(){
    @field:Inject
    lateinit var orderDao: OrderDao

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

}