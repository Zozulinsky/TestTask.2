package zo.den.testtask2.presentation.ui

import dagger.Module
import dagger.android.ContributesAndroidInjector
import zo.den.testtask2.presentation.ui.detailsoforder.DetailsFragment
import zo.den.testtask2.presentation.ui.detailsoforder.DetailsModule
import zo.den.testtask2.presentation.ui.detailsoforder.DetailsScope
import zo.den.testtask2.presentation.ui.order.OrderFragment
import zo.den.testtask2.presentation.ui.order.OrderModule
import zo.den.testtask2.presentation.ui.order.OrderScope

@Module
abstract class MainFragmentBuilder {

    @ContributesAndroidInjector(modules = [OrderModule::class])
    @OrderScope
    abstract fun buildOrderFragment(): OrderFragment

    @ContributesAndroidInjector(modules = [DetailsModule::class])
    @DetailsScope
    abstract fun buildDetailsFragment(): DetailsFragment


}