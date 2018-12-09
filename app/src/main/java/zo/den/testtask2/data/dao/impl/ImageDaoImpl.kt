package zo.den.testtask2.data.dao.impl

import android.graphics.Bitmap
import android.util.LruCache
import io.reactivex.Single
import zo.den.testtask2.data.dao.ImageDao
import zo.den.testtask2.data.network.api.OrdersApi
import javax.inject.Inject

class ImageDaoImpl @Inject constructor() : ImageDao {

    lateinit var bitmapLruCache: LruCache<String, Bitmap>
    @Inject
    lateinit var ordersApi: OrdersApi

    override fun getImage(path: String): Single<Bitmap> {
        val bmp = bitmapLruCache.get(path)
        return if(bmp==null || bmp.isRecycled){
            ordersApi.getImageAuto(path).doOnSuccess {
                bitmapLruCache.put(path, it)
            }
        }else
            Single.just(bmp)
    }
}