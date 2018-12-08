package zo.den.testtask2.data.dao

import android.graphics.Bitmap
import io.reactivex.Single
import java.util.*

interface ImageDao {
    fun getImage(path: String): Single<Bitmap>
}