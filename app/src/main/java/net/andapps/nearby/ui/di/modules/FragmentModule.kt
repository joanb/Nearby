package net.andapps.nearby.ui.di.modules

import android.support.v4.app.Fragment
import dagger.Module
import dagger.Provides


/**
 * Created by Joan on 17/01/2017.
 */
@Module
class FragmentModule(private val baseFragment : Fragment) {

    @Provides
    internal fun provideFragment(): Fragment {
        return baseFragment
    }
}