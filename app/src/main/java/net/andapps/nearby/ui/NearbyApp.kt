package net.andapps.nearby.ui

import android.app.Application
import android.content.Context
import net.andapps.nearby.ui.di.components.ApplicationComponent
import net.andapps.nearby.ui.di.components.DaggerApplicationComponent
import net.andapps.nearby.ui.di.modules.ApplicationModule


/**
 * Created by Joan on 17/01/2017.
 */
class NearbyApp : Application() {

    val component: ApplicationComponent
        get() = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()

    override fun onCreate() {
        super.onCreate()

        component.inject(this)
    }

    companion object {
        operator fun get(context: Context): NearbyApp {
            return context.applicationContext as NearbyApp
        }
    }
}