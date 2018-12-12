package zo.den.testtask2.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ContextQualifier(val name: String = "")