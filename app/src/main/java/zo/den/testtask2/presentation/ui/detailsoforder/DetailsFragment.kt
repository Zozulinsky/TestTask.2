package zo.den.testtask2.presentation.ui.detailsoforder

import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_details.*
import zo.den.testtask2.R
import zo.den.testtask2.presentation.base.MoxyFragment
import zo.den.testtask2.presentation.model.DetailsModel
import javax.inject.Inject
import javax.inject.Provider

class DetailsFragment : MoxyFragment(), DetailsView {
    companion object {
        fun getInstance(): DetailsFragment = DetailsFragment()
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

    override fun showDetailsOfOrder(details: DetailsModel) {
        detailsOfOrder.append(
                details.startAddress + "\n"
                        + details.endAddress + "\n"
                        + details.dateAndTimeOfOrder + "\n"
                        + details.amount + "\n"
                        + details.regNumber + "\n"
                        + details.modelName + "\n"
                        + details.driverName + "\n"
        )
    }
}