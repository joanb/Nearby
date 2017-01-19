package net.andapps.nearby.ui.shops.pages.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import net.andapps.nearby.R
import net.andapps.nearby.domain.model.Shop
import java.util.*


/**
 * Created by Joan on 19/01/2017.
 */
class ShopsAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var shops = ArrayList<Shop>()

    fun setShops(shops: List<Shop>) {
        this.shops.addAll(shops)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ShopViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_shop, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ShopViewHolder).bind(shops[position])
    }

    override fun getItemCount(): Int {
        return shops.size
    }

    internal inner class ShopViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var shopNameView: TextView
        var shopAddressView: TextView

        init {
            shopNameView = itemView.findViewById(R.id.shop_name_view) as TextView
            shopAddressView = itemView.findViewById(R.id.shop_address_view) as TextView
        }

        fun bind(shop: Shop) {
            shopNameView.text = shop.shopName
            shopAddressView.text = shop.addressStreet + " " + shop.addressCity + " " + shop.addressPostalCode
        }
    }
}