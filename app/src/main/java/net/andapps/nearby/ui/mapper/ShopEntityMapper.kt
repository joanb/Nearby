package net.andapps.nearby.ui.mapper

import net.andapps.nearby.data.mapper.BaseMapper
import net.andapps.nearby.domain.model.Shop
import net.andapps.nearby.ui.entities.ShopViewEntity
import javax.inject.Inject


/**
 * Created by Joan on 19/01/2017.
 */
class ShopEntityMapper
    @Inject constructor(): BaseMapper<Shop, ShopViewEntity>() {


    override fun map(entity: Shop?): ShopViewEntity? {
        val shop: ShopViewEntity = ShopViewEntity()
        shop.addressStreet = entity?.addressCity
        shop.addressCity = entity?.addressCity
        shop.addressPostalCode = entity?.addressPostalCode
        shop.isHasCatalogs = entity?.isHasCatalogs!!
        shop.retailerId = entity?.retailerId
        shop.retailerName = entity?.retailerName
        shop.shopId = entity?.shopId
        shop.shopName = entity?.shopName
        shop.phoneNumber = entity?.phoneNumber

        shop.latitude = java.lang.Float.valueOf(entity?.latitude?.replace(",", ".")).toDouble()
        shop.longitude = java.lang.Float.valueOf(entity?.longitude?.replace(",", ".")).toDouble()

        return shop
    }
}