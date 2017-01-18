package net.andapps.nearby.ui.di.components

import dagger.Component
import net.andapps.nearby.ui.di.modules.ActivityModule
import net.andapps.nearby.ui.di.scopes.PerActivity
import net.andapps.nearby.ui.shops.ShopsActivity


/**
 * Created by Joan on 17/01/2017.
 */

@PerActivity
@Component (dependencies = arrayOf(ApplicationComponent::class),
            modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(shopsActivity: ShopsActivity)
}