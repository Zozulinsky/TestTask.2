package zo.den.testtask2.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import zo.den.testtask2.OrderApplication
import zo.den.testtask2.data.DataModule
import zo.den.testtask2.presentation.ActivityBuilder
import zo.den.testtask2.presentation.ui.order.OrderModule
import javax.inject.Singleton

@Singleton
@Component(
        modules = [
            DataModule::class,
            RouterModule::class,

            OrderModule::class,

            ActivityBuilder::class,
            AppModule::class,
            AndroidSupportInjectionModule::class]
)
interface AppComponent : AndroidInjector<OrderApplication>  {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<OrderApplication>(){

        @BindsInstance
        abstract fun application(application: Application): Builder

    }
}