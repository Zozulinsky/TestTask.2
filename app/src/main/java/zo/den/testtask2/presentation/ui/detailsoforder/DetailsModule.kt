package zo.den.testtask2.presentation.ui.detailsoforder

import dagger.Module
import dagger.Provides
import zo.den.testtask2.presentation.model.OrderModel

@Module
class DetailsModule {
    @Provides
    @DetailsQualifier
    fun provideDetails(detailsFragment: DetailsFragment): OrderModel = detailsFragment.getOrderModel()
}