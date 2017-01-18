package net.andapps.nearby.ui.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import net.andapps.nearby.data.di.DataModule
import net.andapps.nearby.data.executor.JobExecutor
import net.andapps.nearby.domain.threads.PostExecutionThread
import net.andapps.nearby.domain.threads.ThreadExecutor
import net.andapps.nearby.ui.NearbyApp
import net.andapps.nearby.ui.UIThread
import javax.inject.Singleton


/**
 * Created by Joan on 17/01/2017.
 */
@Module(includes = arrayOf(DataModule::class))
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

    @Singleton
    @Provides
    fun providesThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor = jobExecutor

    @Singleton
    @Provides
    fun providesPostExecutionThread(uiThread: UIThread): PostExecutionThread = uiThread


}