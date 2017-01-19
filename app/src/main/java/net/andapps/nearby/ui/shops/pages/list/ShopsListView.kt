package net.andapps.nearby.ui.shops.pages.list

import net.andapps.nearby.domain.model.Shop


/**
 * Created by Joan on 17/01/2017.
 */
interface ShopsListView {

    fun initializeViews()
    fun showLoadingFeedback()
    fun showShops(shops: List<Shop>)
}