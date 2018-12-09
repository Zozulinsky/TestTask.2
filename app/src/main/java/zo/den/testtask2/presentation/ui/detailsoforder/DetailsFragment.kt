package zo.den.testtask2.presentation.ui.detailsoforder

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import dagger.Provides
import kotlinx.android.synthetic.main.abc_activity_chooser_view.view.*
import kotlinx.android.synthetic.main.fragment_details.*
import zo.den.testtask2.R
import zo.den.testtask2.presentation.base.MoxyFragment
import zo.den.testtask2.presentation.model.OrderModel
import javax.inject.Inject
import javax.inject.Provider

class DetailsFragment : MoxyFragment(), DetailsView {
    override fun inputPhotoIntoDetailsOfOrder(bitmap: Bitmap) {
        imageAuto.setImageBitmap(bitmap)
    }

    companion object {
        private const val KEY_ORDER: String = "ordermodel"
        fun getInstance(orderModel: OrderModel): DetailsFragment = DetailsFragment().also {
            it.arguments = Bundle().apply {
                putParcelable(KEY_ORDER, orderModel)

            }
        }
    }

    fun getOrderModel(): OrderModel {
        //TODO исправить !!
        var orderModel: OrderModel =this.arguments!!.getParcelable(KEY_ORDER)
        return orderModel
    }

    override val layout: Int = R.layout.fragment_details


    @field:Inject
    lateinit var presenterProvider: Provider<DetailsPresenter>

    @ProvidePresenter
    fun providePresenter(): DetailsPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: DetailsPresenter

    @field:Inject
    @field:DetailsQualifier
    lateinit var detailsOfOrder: OrderModel


    override fun onViewPrepare(savedInstanceState: Bundle?) {
        super.onViewPrepare(savedInstanceState)
        var sb: StringBuilder = java.lang.StringBuilder(" ")
        sb.append(
                detailsOfOrder.startAddress + "\n"
                        + detailsOfOrder.endAddress + "\n"
                        + detailsOfOrder.dateOfOrder + "\n"
                        + detailsOfOrder.amount + "\n"
                        + detailsOfOrder.regNumber + "\n"
                        + detailsOfOrder.modelName + "\n"
                        + detailsOfOrder.driverName + "\n"
        )
        details.text = sb.toString()
    }

    override fun showDetailsOfOrder(order: OrderModel) {
        detailsOfOrder = order
    }
}