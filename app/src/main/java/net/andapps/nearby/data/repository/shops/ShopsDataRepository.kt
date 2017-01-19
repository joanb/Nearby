package net.andapps.nearby.data.repository.shops

import net.andapps.nearby.domain.model.Shop
import net.andapps.nearby.domain.repository.ShopsRepository
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Named


/**
 * Created by Joan on 18/01/2017.
 */

//TODO: add class mapper
class ShopsDataRepository @Inject constructor(@Named("tiendeo API") val retrofit: Retrofit)
    : ShopsRepository {


    override fun getAll(callback: ShopsRepository.GetAllPlacesCallback) {
        //TODO: check connectivity


        val shops : List<Shop> = retrofit.create(ShopsService::class.java).shops.execute().body()
        callback.onSuccess(shops)
    }

}