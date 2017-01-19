package net.andapps.nearby.domain.repository

import net.andapps.nearby.domain.DefaultCallback
import net.andapps.nearby.domain.model.Shop


/**
 * Created by Joan on 18/01/2017.
 */
interface ShopsRepository {

    interface GetAllPlacesCallback: DefaultCallback<List<Shop>>
    fun getAll(getAllPlacesCallback: GetAllPlacesCallback)
}