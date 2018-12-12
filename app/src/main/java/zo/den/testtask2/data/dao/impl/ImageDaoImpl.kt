package zo.den.testtask2.data.dao.impl

import android.app.Application
import android.graphics.Bitmap
import io.reactivex.Single
import zo.den.testtask2.data.cache.BitmapCache
import zo.den.testtask2.data.dao.ImageDao
import zo.den.testtask2.data.network.api.OrdersApi
import javax.inject.Inject

class ImageDaoImpl
    @Inject constructor(application: Application)  : ImageDao {


    var bitmapCache: BitmapCache = BitmapCache(application.applicationContext)
    @Inject
    lateinit var ordersApi: OrdersApi

    override fun getImage(path: String): Single<Bitmap> {

        val bmp = bitmapCache?.load(path)
        return if (bmp == null || bmp.isRecycled) {
            ordersApi.getImageAuto(path).doOnSuccess {
                bitmapCache.save(path, it)
            }
        } else
            Single.just(bmp)
    }
}