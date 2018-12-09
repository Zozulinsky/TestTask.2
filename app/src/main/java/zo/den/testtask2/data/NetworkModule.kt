package zo.den.testtask2.data

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import zo.den.testtask2.data.network.OrderServiceModule
import javax.inject.Singleton
@Module(includes = [OrderServiceModule::class])
class NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().build()
}