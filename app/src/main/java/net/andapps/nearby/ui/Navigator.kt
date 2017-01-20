package net.andapps.nearby.ui

import android.content.Context
import android.content.Intent
import net.andapps.nearby.ui.entities.ShopViewEntity
import net.andapps.nearby.ui.shops.detail.ShopDetailActivity
import javax.inject.Inject


/**
 * Created by Joan on 20/01/2017.
 */
class Navigator
@Inject constructor() {

    fun navigateToShopDetail(context: Context, shop: ShopViewEntity) {
        val intent: Intent = ShopDetailActivity().getInitializationIntent(context, shop)
        context.startActivity(intent)
    }
}