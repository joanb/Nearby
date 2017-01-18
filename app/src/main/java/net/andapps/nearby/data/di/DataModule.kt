package net.andapps.nearby.data.di

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named


/**
 * Created by Joan on 18/01/2017.
 */

@Module
class DataModule {

    private val TIENDEO_API_URL = "https://interview-test-45073.firebaseio.com/"

    @Provides
    @Named("tiendeo API")
    fun provideRetrofit() : Retrofit {
        return Retrofit.Builder()
                .baseUrl(TIENDEO_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}