package net.andapps.nearby.ui.di.modules

import android.app.Activity
import dagger.Module
import dagger.Provides


/**
 * Created by Joan on 17/01/2017.
 */

@Module(includes = arrayOf(ViewModule::class))
class ActivityModule(private val baseActivity: Activity) {

    @Provides
    internal fun provideActivity(): Activity {
        return this.baseActivity
    }
}