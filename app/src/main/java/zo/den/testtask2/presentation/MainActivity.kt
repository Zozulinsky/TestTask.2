package zo.den.testtask2.presentation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.arellomobile.mvp.presenter.InjectPresenter
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder
import zo.den.testtask2.R
import zo.den.testtask2.presentation.base.DiMoxyActivity
import zo.den.testtask2.presentation.ui.MainPresenter
import zo.den.testtask2.presentation.ui.MainQualififer
import zo.den.testtask2.presentation.ui.MainView
import javax.inject.Inject
import javax.inject.Provider

class MainActivity :  DiMoxyActivity(), MainView {

    override val layout: Int = R.layout.activity_main

    val containerId: Int = R.id.container

    @Inject
    @field:MainQualififer
    lateinit var navigatorHolder: NavigatorHolder
    @Inject
    @field:MainQualififer
    lateinit var navigator: Navigator
    @Inject
    lateinit var presenterProvider: Provider<MainPresenter>
    @InjectPresenter
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onCreate(savedInstanceState != null)

    }
    override fun onViewPrepare(savedInstanceState: Bundle?) {
        super.onViewPrepare(savedInstanceState)
    }
    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}
