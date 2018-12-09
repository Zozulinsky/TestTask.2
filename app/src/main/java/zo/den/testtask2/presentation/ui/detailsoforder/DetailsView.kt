package zo.den.testtask2.presentation.ui.detailsoforder

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import zo.den.testtask2.presentation.base.BaseView
import zo.den.testtask2.presentation.model.DetailsModel

interface DetailsView : BaseView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showDetailsOfOrder(details: DetailsModel)

}