/*
Created by Helm  19/01/2017.
*/


package net.andapps.nearby.data.mapper

import net.andapps.nearby.data.model.DataShop
import net.andapps.nearby.domain.model.Shop
import javax.inject.Inject

class ShopMapper
    @Inject constructor(): BaseMapper<DataShop, Shop>() {

    override fun map(entity: DataShop?): Shop? {
        val shop = Shop()
        shop.addressStreet = entity?.addressStreet
        shop.addressCity = entity?.addressCity
        shop.addressPostalCode = entity?.addressPostalCode
        shop.isHasCatalogs = entity?.isHasCatalogs!!
        shop.latitude = entity?.latitude
        shop.longitude = entity?.longitude
        shop.retailerId = entity?.retailerId
        shop.retailerName = entity?.retailerName
        shop.shopId = entity?.shopId
        shop.shopName = entity?.shopName
        shop.phoneNumber = entity?.phoneNumber
        shop.web = entity?.web
        return shop
    }

}
