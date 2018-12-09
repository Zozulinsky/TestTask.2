package zo.den.testtask2.presentation.ui.order

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import kotlinx.android.synthetic.main.fragment_orders.*
import zo.den.testtask2.R
import zo.den.testtask2.presentation.ui.order.adapter.OrderAdapter
import zo.den.testtask2.presentation.base.MoxyFragment
import zo.den.testtask2.presentation.model.OrderModel
import javax.inject.Inject
import javax.inject.Provider

class OrderFragment : MoxyFragment(), OrderView {

    companion object {
        fun getInstance(): OrderFragment = OrderFragment()
    }


    override val layout: Int = R.layout.fragment_orders

    @field:Inject
    lateinit var presenterProvider: Provider<OrderPresenter>

    @ProvidePresenter
    fun providePresenter(): OrderPresenter = presenterProvider.get()

    @InjectPresenter
    lateinit var presenter: OrderPresenter

    @field:Inject
    @field:OrderQualifier
    lateinit var orderAdapter: OrderAdapter

    override fun onViewPrepare(savedInstanceState: Bundle?) {
        super.onViewPrepare(savedInstanceState)
        orders_list.adapter = orderAdapter
        orders_list.layoutManager = LinearLayoutManager(context)
    }

    override fun showOrderList(list: List<OrderModel>) {
        orderAdapter.list = list

    }

}