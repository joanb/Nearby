package net.andapps.nearby.ui.di.modules

import android.support.v4.app.Fragment
import dagger.Module
import dagger.Provides
import net.andapps.nearby.domain.di.DomainModule


/**
 * Created by Joan on 17/01/2017.
 */
@Module(includes = arrayOf(FragmentViewModule::class, DomainModule::class))
class FragmentModule(private val baseFragment : Fragment) {

    @Provides
    internal fun provideFragment(): Fragment {
        return baseFragment
    }
}