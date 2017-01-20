package net.andapps.nearby.ui.shops.pages.list

import net.andapps.nearby.domain.model.Shop
import net.andapps.nearby.domain.usecases.GetAllShopsUseCase
import net.andapps.nearby.ui.Navigator
import net.andapps.nearby.ui.entities.ShopViewEntity
import net.andapps.nearby.ui.mapper.ShopViewEntityMapper
import javax.inject.Inject


/**
 * Created by Joan on 17/01/2017.
 */
class ShopsListPresenter
@Inject constructor(val view: ShopsListView,
                    val getAllShopsUseCase: GetAllShopsUseCase,
                    val shopViewMapper: ShopViewEntityMapper,
                    val navigator: Navigator) {


    fun onStart() {
        view.initializeViews()
        view.showLoadingFeedback()
        getAllShopsUseCase.execute(object : GetAllShopsUseCase.GetAllShopsCallback {
            override fun onError(exception: Exception) {
            }

            override fun onSuccess(param: List<Shop>) {
                view.showShops(shopViewMapper.map(param))
            }
        })
    }

    fun navigateToShopDetail(shop: ShopViewEntity) {
        navigator.navigateToShopDetail(view.retrieveActivityContext(), shop)
    }


}