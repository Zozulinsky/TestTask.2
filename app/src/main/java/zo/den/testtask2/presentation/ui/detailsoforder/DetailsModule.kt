package zo.den.testtask2.presentation.ui.detailsoforder

import android.widget.TextView
import dagger.Module
import dagger.Provides
import zo.den.testtask2.presentation.ui.order.adapter.OrderAdapter

@Module
class DetailsModule {
    @Provides
    @DetailsQualifier
    fun provideDetails(): String = ""
}