package zo.den.testtask2.data.network

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import zo.den.testtask2.data.DataQulifier
import zo.den.testtask2.data.network.service.OrdersService

@Module
class OrderServiceModule {

    @Provides
    @DataQulifier("baseURL")
    fun provideBaseUrl(): String = "https://www.roxiemobile.ru/careers/test/"

    @Provides
    fun provideOrderService(@DataQulifier("baseURL") baseUrl: String, okHttpClient: OkHttpClient): OrdersService {
        return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(OrdersService::class.java)
    }
}


