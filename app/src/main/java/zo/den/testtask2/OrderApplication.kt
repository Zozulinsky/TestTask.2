package zo.den.testtask2

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import zo.den.testtask2.di.DaggerAppComponent

class OrderApplication : DaggerApplication() {




    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).create(this)
    }

    override fun onCreate(){
        super.onCreate()

    }
}