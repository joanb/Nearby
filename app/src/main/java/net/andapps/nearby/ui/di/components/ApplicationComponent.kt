package net.andapps.nearby.ui.di.components

import android.content.Context
import dagger.Component
import net.andapps.nearby.ui.NearbyApp
import net.andapps.nearby.ui.di.modules.ApplicationModule
import javax.inject.Singleton


/**
 * Created by Joan on 17/01/2017.
 */
@Singleton
@Component (modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(application: NearbyApp)

    fun application(): NearbyApp
    fun context(): Context
}