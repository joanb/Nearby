package net.andapps.nearby.ui.di.modules

import android.app.Activity
import dagger.Module
import dagger.Provides
import net.andapps.nearby.domain.di.DomainModule


/**
 * Created by Joan on 17/01/2017.
 */
@Module(includes = arrayOf(ActivityViewModule::class, DomainModule::class))
class ActivityModule(private val baseActivity: Activity) {

    @Provides
    internal fun provideActivity(): Activity {
        return this.baseActivity
    }
}