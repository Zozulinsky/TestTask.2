package zo.den.testtask2.data

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class DataQulifier(val name: String = "")