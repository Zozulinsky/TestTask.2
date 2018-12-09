package zo.den.testtask2.presentation.ui.detailsoforder

import android.graphics.Bitmap
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import zo.den.testtask2.presentation.base.BaseView
import zo.den.testtask2.presentation.model.OrderModel

interface DetailsView : BaseView {

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showDetailsOfOrder(order: OrderModel)

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun inputPhotoIntoDetailsOfOrder(bitmap: Bitmap)
}