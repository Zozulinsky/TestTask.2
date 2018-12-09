package zo.den.testtask2.presentation.ui.detailsoforder

import com.arellomobile.mvp.InjectViewState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import zo.den.testtask2.data.dao.ImageDao
import zo.den.testtask2.presentation.base.MoxyPresenter
import zo.den.testtask2.presentation.model.OrderModel
import zo.den.testtask2.presentation.ui.MainQualifier
import javax.inject.Inject

@InjectViewState
class DetailsPresenter @Inject constructor() : MoxyPresenter<DetailsView>() {

    @field:Inject
    lateinit var imageDao: ImageDao

    @Inject
    @field:DetailsQualifier
    lateinit var orderModel: OrderModel

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        imageDao.getImage(orderModel.photo)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    viewState.inputPhotoIntoDetailsOfOrder(it)
                },{it.printStackTrace()}).toCompositeDisposable()
    }
}