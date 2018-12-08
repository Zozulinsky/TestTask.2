package zo.den.testtask2.presentation.ui

import dagger.Module
import dagger.android.ContributesAndroidInjector
import zo.den.testtask2.data.network.OrderModule
import zo.den.testtask2.presentation.ui.order.OrderFragment
import zo.den.testtask2.presentation.ui.order.OrderScope

@Module
abstract class MainFragmentBuilder {

    @ContributesAndroidInjector(modules = [OrderModule::class])
    @OrderScope
    abstract fun buildOrderFragment(): OrderFragment


}