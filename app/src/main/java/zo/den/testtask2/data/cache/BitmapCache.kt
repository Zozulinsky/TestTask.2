package zo.den.testtask2.data.cache

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import java.io.*


class BitmapCache constructor(context: Context)  {
    var context = context

    fun save(fileName: String, data: Bitmap) {
        val file: File = File(context.cacheDir.toString() + "/" + fileName + "-" + (System.currentTimeMillis() + 10 * 60 * 1000))
        val fileOutputStream = FileOutputStream(file)
        val bos = BufferedOutputStream(fileOutputStream, 1024)
        data.compress(Bitmap.CompressFormat.JPEG, 80, bos)
        bos.flush()
        bos.close()
    }

    fun load(filename: String) : Bitmap?{
        var bmp: Bitmap? = null
        if (context!=null) {
            val f = File(context.cacheDir.toString() + "/")
            val matchingFiles = f.listFiles(object : FilenameFilter {
                override fun accept(dir: File, name: String): Boolean {
                    return name.startsWith(filename)
                }
            })
            if (matchingFiles.size > 0)
                for (file: File in matchingFiles) {
                    var timeCreateFile: String = file.name.substring(file.name.indexOf("-") + 1, file.name.length)
                    if (System.currentTimeMillis() > timeCreateFile.toLong()) {
                        file.delete()
                        break
                    }
                    val inputstream: InputStream = FileInputStream(file)
                    val bis: BufferedInputStream = BufferedInputStream(inputstream)
                    bmp = BitmapFactory.decodeStream(bis)
                }
        }
        return bmp
    }
}