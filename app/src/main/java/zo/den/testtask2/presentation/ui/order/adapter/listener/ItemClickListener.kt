package zo.den.testtask2.presentation.ui.order.adapter.listener

import android.view.View

interface ItemClickListener : View.OnClickListener{
    fun onItemClick(view: View, position: Int)
}