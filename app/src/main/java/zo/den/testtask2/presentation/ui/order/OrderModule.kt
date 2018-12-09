package zo.den.testtask2.presentation.ui.order

import dagger.Module
import dagger.Provides
import zo.den.testtask2.presentation.adapter.OrderAdapter

@Module
class OrderModule {
    @Provides
    @OrderQualifier
    fun provideOrderAdapter(): OrderAdapter = OrderAdapter()
}