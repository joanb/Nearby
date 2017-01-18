package net.andapps.nearby.ui.di.components

import dagger.Component
import net.andapps.nearby.ui.di.modules.FragmentModule
import net.andapps.nearby.ui.di.scopes.PerFragment
import net.andapps.nearby.ui.shops.pages.list.ShopsListFragment
import net.andapps.nearby.ui.shops.pages.map.ShopsMapFragment


/**
 * Created by Joan on 17/01/2017.
 */

@PerFragment
@Component (dependencies = arrayOf(ApplicationComponent::class),
            modules = arrayOf(FragmentModule::class))
interface FragmentComponent {

    fun inject(shopsListFragment: ShopsListFragment)
    fun inject(shopsMapFragment: ShopsMapFragment)
}