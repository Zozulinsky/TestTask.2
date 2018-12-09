package zo.den.testtask2.presentation.ui.detailsoforder

import com.arellomobile.mvp.InjectViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import zo.den.testtask2.data.dao.ImageDao
import zo.den.testtask2.data.dao.OrderDao
import zo.den.testtask2.data.network.pojo.orders.Vehicle
import zo.den.testtask2.presentation.base.MoxyPresenter
import zo.den.testtask2.presentation.mapper.DetailsModelMapper
import zo.den.testtask2.presentation.mapper.ImageMapper
import zo.den.testtask2.presentation.mapper.OrderModelMapper
import zo.den.testtask2.presentation.model.DetailsModel
import zo.den.testtask2.presentation.ui.order.OrderView
import zo.den.testtask2.presentation.ui.order.adapter.OrderAdapter
import javax.inject.Inject

@InjectViewState
class DetailsPresenter @Inject constructor() : MoxyPresenter<DetailsView>() {
    @field:Inject
    lateinit var orderDao: OrderDao

    @field:Inject
    lateinit var imageDao: ImageDao

    @Inject
    lateinit var vehicle: Vehicle

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        orderDao.getOrders()
                .map(DetailsModelMapper())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    viewState.showDetailsOfOrder(it)
                },{
                    it.printStackTrace()
                }).toCompositeDisposable()

    }
}