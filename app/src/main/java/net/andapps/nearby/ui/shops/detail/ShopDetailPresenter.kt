package net.andapps.nearby.ui.shops.detail

import net.andapps.nearby.ui.entities.ShopViewEntity
import javax.inject.Inject


/**
 * Created by Joan on 20/01/2017.
 */
class ShopDetailPresenter
@Inject constructor(val view: ShopDetailView){

    fun onStart(shop: ShopViewEntity) {
        view.showParams(shop.shopName,
                shop.address,
                shop.phoneNumber,
                shop.web)
    }

    fun onPhoneClicked(phoneNumber: String?) {
        view.openDialWithNumber(phoneNumber)
    }

    fun onWebSiteClicked(web: String?) {
        view.openWebsiteFromUrl(web)
    }


}