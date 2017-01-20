package net.andapps.nearby.ui.entities

import java.io.Serializable


/**
 * Created by Joan on 19/01/2017.
 */
class ShopViewEntity : Serializable{
    var address: String? = null
    var street: String? = null
    var isHasCatalogs: Boolean = false
    var phoneNumber: String? = null
    var retailerId: String? = null
    var retailerName: String? = null
    var shopId: String? = null
    var shopName: String? = null
    var web: String? = null
    var latitude: Double? = null
    var longitude: Double? = null
}