package com.stylethory.raldes.module.fragment.color

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stylethory.raldes.R
import com.stylethory.raldes.model.ColorsList
import com.stylethory.raldes.model.ColorsResponse
import kotlinx.android.synthetic.main.list_item_grid_color.view.*


class ColorsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var colorResponse: ColorsResponse? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ColorListViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(R.layout.list_item_grid_color, parent, false)
        )
    }

    override fun getItemCount(): Int = colorResponse!!.color.size

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val movieViewHolder = viewHolder as ColorListViewHolder
        movieViewHolder.bindView(colorResponse!!.color[position])
    }

    fun setColors(colorResponseList: ColorsResponse) {
        this.colorResponse = colorResponseList
        notifyDataSetChanged()
    }
}

class ColorListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindView(color: ColorsList) {
        itemView.uiview_circle_color.setCardBackgroundColor((Color.parseColor(color.code)))
    }
}