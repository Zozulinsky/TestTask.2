package zo.den.testtask2.di

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Router
import zo.den.testtask2.presentation.ui.MainQualififer
import javax.inject.Singleton

@Module
class RouterModule {

    @Provides
    @MainQualififer
    @Singleton
    fun provideMainRouter(): Router = Router()
}