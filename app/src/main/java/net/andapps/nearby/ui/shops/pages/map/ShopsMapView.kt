package net.andapps.nearby.ui.shops.pages.map

import net.andapps.nearby.ui.entities.ShopViewEntity


/**
 * Created by Joan on 17/01/2017.
 */
interface ShopsMapView {
//
    fun showLoadingFeedback()

    fun showShops(shops: List<ShopViewEntity>)
}