package net.andapps.nearby

import net.andapps.nearby.domain.model.Shop
import net.andapps.nearby.ui.mapper.ShopViewEntityMapper
import org.junit.Test


/**
 * Created by Joan on 20/01/2017.
 */
class ShopViewEntityMapperTest {

    fun getDefaultShop() : Shop {
        val shop: Shop = Shop()
        shop.phoneNumber = "123456789"
        shop.addressStreet = "street"
        shop.addressCity = "city"
        shop.addressPostalCode = "12345"
        shop.latitude = "41.123123"
        shop.longitude = "43.123213"

        return shop
    }

    @Test
    fun shopViewEntityAddressIsMapped() {
        val modelShop = getDefaultShop()
        val mapper: ShopViewEntityMapper = ShopViewEntityMapper()

        val shop = mapper.map(modelShop)

        assert(shop!!.address.equals(
                modelShop.addressStreet + " " +
                modelShop.addressCity + " " +
                modelShop.addressPostalCode
        ))
    }


    @Test
    fun shopViewEntityPhoneIsCorrectlyFormatted(){
        val mapper: ShopViewEntityMapper = ShopViewEntityMapper()

        val shop = mapper.map(getDefaultShop())

        assert(shop!!.phoneNumber!!.startsWith("tel:"))
    }

}