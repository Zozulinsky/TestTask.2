package zo.den.testtask2.presentation.ui

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class MainQualififer(val name: String = "")