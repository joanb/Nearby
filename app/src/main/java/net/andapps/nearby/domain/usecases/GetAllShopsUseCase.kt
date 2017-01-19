package net.andapps.nearby.domain.usecases

import net.andapps.nearby.domain.DefaultCallback
import net.andapps.nearby.domain.Interactor
import net.andapps.nearby.domain.model.Shop


/**
 * Created by Joan on 18/01/2017.
 */
interface GetAllShopsUseCase : Interactor {

    interface GetAllShopsCallback : DefaultCallback<List<Shop>>
    fun execute(getAllShopsCallback: GetAllShopsCallback)
}