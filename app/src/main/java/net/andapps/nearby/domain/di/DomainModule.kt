package net.andapps.nearby.domain.di

import dagger.Module
import dagger.Provides
import net.andapps.nearby.domain.usecases.GetAllShopsInteractor
import net.andapps.nearby.domain.usecases.GetAllShopsUseCase


/**
 * Created by Joan on 18/01/2017.
 */

@Module
class DomainModule {

    @Provides
    fun providesGetAllShopsUseCase(getAllShopsInteractor: GetAllShopsInteractor) : GetAllShopsUseCase = getAllShopsInteractor
}