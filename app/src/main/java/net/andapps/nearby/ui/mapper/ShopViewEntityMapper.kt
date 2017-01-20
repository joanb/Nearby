package net.andapps.nearby.ui.mapper

import net.andapps.nearby.data.mapper.BaseMapper
import net.andapps.nearby.domain.model.Shop
import net.andapps.nearby.ui.entities.ShopViewEntity
import javax.inject.Inject


/**
 * Created by Joan on 19/01/2017.
 */
class ShopViewEntityMapper
    @Inject constructor(): BaseMapper<Shop, ShopViewEntity>() {


    override fun map(entity: Shop?): ShopViewEntity? {
        val shop: ShopViewEntity = ShopViewEntity()
        shop.address = entity?.addressStreet + " " + entity?.addressCity + " " + entity?.addressPostalCode
        shop.street = entity?.addressStreet
        shop.isHasCatalogs = entity?.isHasCatalogs!!
        shop.retailerId = entity?.retailerId
        shop.retailerName = entity?.retailerName
        shop.shopId = entity?.shopId
        shop.shopName = entity?.shopName
        shop.phoneNumber = "tel:" + entity?.phoneNumber
        shop.web = entity?.web

        shop.latitude = java.lang.Float.valueOf(entity?.latitude?.replace(",", ".")).toDouble()
        shop.longitude = java.lang.Float.valueOf(entity?.longitude?.replace(",", ".")).toDouble()

        return shop
    }
}