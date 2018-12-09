package zo.den.testtask2.presentation.ui.order.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.order.view.*
import zo.den.testtask2.R
import zo.den.testtask2.presentation.model.OrderModel
import zo.den.testtask2.presentation.ui.order.adapter.listener.ItemClickListener
import android.widget.AdapterView.OnItemClickListener
import zo.den.testtask2.R.id.parent


class OrderAdapter : RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    lateinit var mItemClickListener:OnItemClickListener

    var list: List<OrderModel> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): OrderViewHolder {
        return OrderViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.order, p0, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }


    override fun onBindViewHolder(p0: OrderViewHolder, p1: Int) {
        p0.bind(list[p1])

    }



    inner class OrderViewHolder(view: View)
        : RecyclerView.ViewHolder(view), View.OnClickListener {

        init {
            view.setOnClickListener(this)}

        fun bind(orderModel: OrderModel) {
            itemView.startAddress.text = orderModel.startAddress
            itemView.endAddress.text = orderModel.endAddress
            itemView.dateOfOrder.text = orderModel.dateOfOrder
            itemView.amount.text = orderModel.amount
        }

        override fun onClick(v: View?) {

        }
    }
}