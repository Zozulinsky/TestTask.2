package zo.den.testtask2.data.cache

import android.graphics.Bitmap
import android.util.LruCache

class BitmapLruCache : LruCache<String, Bitmap>{
    constructor(maxSize: Int) :  super(maxSize)

    override fun entryRemoved(evicted: Boolean, key: String?, oldValue: Bitmap, newValue: Bitmap?) {
        super.entryRemoved(evicted, key, oldValue, newValue)
        if(!oldValue.isRecycled)
            oldValue.recycle()
    }
}