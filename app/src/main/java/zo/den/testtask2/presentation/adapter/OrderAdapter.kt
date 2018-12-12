package zo.den.testtask2.presentation.adapter

import android.content.Context
import android.content.res.Resources
import android.provider.Settings.System.getString
import android.support.v4.content.res.TypedArrayUtils.getText
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.order.view.*
import zo.den.testtask2.R
import zo.den.testtask2.presentation.model.OrderModel
import java.text.SimpleDateFormat
import java.util.*

class OrderAdapter : RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    var listener: OnItemClickListener? = null

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
        : RecyclerView.ViewHolder(view){

        var cardView: CardView? = null

        fun bind(orderModel: OrderModel) {
            val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
            val sdf2 = SimpleDateFormat("dd.MM.yyyy")
            val date: Date = sdf.parse(orderModel.dateOfOrder)
            val time: String = sdf2.format(date)
            cardView = itemView.cardview
            itemView.startAddress.text = orderModel.startAddress
            itemView.endAddress.text = orderModel.endAddress
            itemView.dateOfOrder.text = time
            itemView.amount.text = orderModel.amount
            itemView.setOnClickListener(View.OnClickListener {
                listener?.onItemClick(orderModel)
            })
        }
    }

    interface OnItemClickListener {
        fun onItemClick(orderModel: OrderModel)
    }
}