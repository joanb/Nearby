package net.andapps.nearby.ui.shops.pages.list

import android.content.Context
import net.andapps.nearby.ui.entities.ShopViewEntity


/**
 * Created by Joan on 17/01/2017.
 */
interface ShopsListView {

    fun initializeViews()
    fun showLoadingFeedback()
    fun showShops(shops: List<ShopViewEntity>)
    fun retrieveActivityContext(): Context
}