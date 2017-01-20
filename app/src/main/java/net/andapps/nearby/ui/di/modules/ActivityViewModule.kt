package net.andapps.nearby.ui.di.modules

import android.app.Activity
import dagger.Module
import dagger.Provides
import net.andapps.nearby.ui.shops.ShopsView
import net.andapps.nearby.ui.shops.detail.ShopDetailView


/**
 * Created by Joan on 17/01/2017.
 */
@Module
class ActivityViewModule(val activity: Activity) {


    @Provides
    fun providesShopsView(): ShopsView = activity as ShopsView

    @Provides
    fun providesDetailView(): ShopDetailView = activity as ShopDetailView

}