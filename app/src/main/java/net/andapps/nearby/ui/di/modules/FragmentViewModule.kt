package net.andapps.nearby.ui.di.modules

import android.support.v4.app.Fragment
import dagger.Module
import dagger.Provides
import net.andapps.nearby.ui.shops.pages.list.ShopsListView
import net.andapps.nearby.ui.shops.pages.map.ShopsMapView


/**
 * Created by Joan on 18/01/2017.
 */


@Module
class FragmentViewModule (val fragment: Fragment){

    @Provides
    fun providesShopsListView(): ShopsListView = fragment as ShopsListView


    @Provides
    fun providesShopsMapView(): ShopsMapView = fragment as ShopsMapView
}