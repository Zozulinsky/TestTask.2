package zo.den.testtask2.presentation.ui.order

import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import zo.den.testtask2.presentation.base.BaseView
import zo.den.testtask2.presentation.model.OrderModel

interface OrderView : BaseView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showOrderList(list: List<OrderModel>)
}