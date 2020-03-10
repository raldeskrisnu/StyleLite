package com.stylethory.raldes.module.fragment.products

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.stylethory.raldes.R
import com.stylethory.raldes.model.Product
import com.stylethory.raldes.model.ProductResponse
import kotlinx.android.synthetic.main.list_item_grid_product.view.*

class ProductsAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var productResponse: ProductResponse? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MovieListViewHolder(
            LayoutInflater.from(
                parent.context
            ).inflate(R.layout.list_item_grid_product, parent, false)
        )
    }

    override fun getItemCount(): Int = productResponse!!.product.size

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        val movieViewHolder = viewHolder as MovieListViewHolder
        movieViewHolder.bindView(productResponse!!.product[position])
    }

    fun setProducts(listOfMovies: ProductResponse) {
        this.productResponse = listOfMovies
        notifyDataSetChanged()
    }
}

class MovieListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bindView(product: Product) {
        itemView.uiview_textview_title.text = product.designer[0].name
        itemView.uiview_textview_subtitle.text = product.name
        itemView.uiview_textview_price.text = product.price.amount.toString()

        Picasso.get()
            .load(product.featureImage)
            .placeholder(R.drawable.unnamed)
            .error(R.drawable.error_image)
            .into(itemView.uiview_image_product)
    }

}