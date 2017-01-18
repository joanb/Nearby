package net.andapps.nearby.ui.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import net.andapps.nearby.ui.NearbyApp
import javax.inject.Singleton


/**
 * Created by Joan on 17/01/2017.
 */
@Module
class ApplicationModule(private val application: NearbyApp) {


    @Provides
    @Singleton
    fun providesApplication(): NearbyApp {
        return application
    }

    @Singleton
    @Provides
    fun provideContext() : Context {
        return application
    }

}