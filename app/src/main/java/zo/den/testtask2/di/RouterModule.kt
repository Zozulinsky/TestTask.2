package zo.den.testtask2.di

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router
import zo.den.testtask2.presentation.ui.MainQualifier
import javax.inject.Singleton

@Module
class RouterModule {

    @Provides
    @MainQualifier
    @Singleton
    fun provideMainRouter(): Router = Router()
}