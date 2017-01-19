package net.andapps.nearby.ui.shops.pages.map

import net.andapps.nearby.domain.model.Shop
import net.andapps.nearby.domain.usecases.GetAllShopsUseCase
import javax.inject.Inject


/**
 * Created by Joan on 17/01/2017.
 */
class ShopsMapPresenter
@Inject constructor(val view: ShopsMapView,
                    val getAllShopsUseCase: GetAllShopsUseCase) {
    fun onStart() {
        view.showLoadingFeedback()
        getAllShopsUseCase.execute(object: GetAllShopsUseCase.GetAllShopsCallback {
            override fun onError(exception: Exception) {

            }

            override fun onSuccess(param: List<Shop>) {
                view.showShops(param)
            }
        })
    }


}