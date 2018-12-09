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
        private const val KEY_ORDER: String = ""
        fun getInstance(orderModel: OrderModel): DetailsFragment = DetailsFragment().also {
            it.arguments = Bundle().apply {
                putParcelable(KEY_ORDER, orderModel)

            }
        }
    }

    fun getOrderModel(): OrderModel {
        return Bundle().getParcelable(KEY_ORDER)
    }

    override val layout: Int = R.layout.fragment_details


    @field:Inject
    lateinit var presenterProvider: Provider<DetailsPresenter>

    @ProvidePresenter
    fun providePresenter(): DetailsPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: DetailsPresenter

    lateinit var detailsOfOrder: StringBuilder


    override fun onViewPrepare(savedInstanceState: Bundle?) {
        super.onViewPrepare(savedInstanceState)
        details.text = detailsOfOrder.toString()

    }

    override fun showDetailsOfOrder(order: OrderModel) {
        detailsOfOrder.append(
                order.startAddress + "\n"
                        + order.endAddress + "\n"
                        + order.dateOfOrder + "\n"
                        + order.amount + "\n"
                        + order.regNumber + "\n"
                        + order.modelName + "\n"
                        + order.driverName + "\n"
        )
    }

}