package zo.den.testtask2.data

import dagger.Binds
import dagger.Module
import zo.den.testtask2.data.dao.ImageDao
import zo.den.testtask2.data.dao.OrderDao
import zo.den.testtask2.data.dao.impl.ImageDaoImpl
import zo.den.testtask2.data.dao.impl.OrdersDaoImpl

@Module
abstract class DataBinder {
    @Binds
    abstract fun bindOrderDao(dao: OrdersDaoImpl): OrderDao
    @Binds
    abstract fun bindImageDao(dao: ImageDaoImpl): ImageDao
}