package zo.den.testtask2.presentation.base

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import com.arellomobile.mvp.MvpAppCompatActivity
import dagger.android.AndroidInjection
import zo.den.testtask2.R

abstract class MoxyActivity : MvpAppCompatActivity(), BaseView{

    protected abstract val layout: Int

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(layout)
        onViewPrepare(savedInstanceState)
    }

    protected open fun onViewPrepare(savedInstanceState: Bundle?){}

    protected open fun onViewDetach(){}

    override fun onDestroy(){
        onViewDetach()
        super.onDestroy()
    }
}