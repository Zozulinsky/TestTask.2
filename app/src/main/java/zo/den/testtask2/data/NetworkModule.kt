package zo.den.testtask2.data

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import zo.den.testtask2.data.network.OrderModule
import javax.inject.Singleton
@Module(includes = [OrderModule::class])
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()
}