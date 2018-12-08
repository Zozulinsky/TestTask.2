package zo.den.testtask2.presentation.ui

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.android.support.SupportAppNavigator


@Module(includes = [MainFragmentBuilder::class])
class MainModule {

    @Provides
    @MainQualififer
    @MainScope
    fun provideCicerone(@MainQualififer router: Router): Cicerone<Router> = Cicerone.create(router)

    @Provides
    @MainQualififer
    fun provideNavigatorHolder(@MainQualififer cicerone: Cicerone<Router>): NavigatorHolder = cicerone.navigatorHolder

    @Provides
    @MainQualififer
    fun provideNavigator(mainActivity: MainActivity): Navigator =
            SupportAppNavigator(mainActivity, mainActivity.containerId)

}