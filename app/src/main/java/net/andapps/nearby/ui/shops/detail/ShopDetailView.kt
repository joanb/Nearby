package net.andapps.nearby.ui.shops.detail


/**
 * Created by Joan on 20/01/2017.
 */
interface ShopDetailView {
    fun showParams(shopName: String?, addressCity: String?, phoneNumber: String?, web: String?)
    fun openWebsiteFromUrl(url: String?)
    fun openDialWithNumber(phoneNumber: String?)
}