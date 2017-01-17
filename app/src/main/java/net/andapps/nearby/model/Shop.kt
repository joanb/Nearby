package net.andapps.nearby.model

import com.google.gson.annotations.SerializedName


/**
 * Created by Joan on 17/01/2017.
 */
class Shop {
    @SerializedName("address_city") var addressCity: String? = null
    @SerializedName("address_postal_code") var addressPostalCode: String? = null
    @SerializedName("address_street") var addressStreet: String? = null
    @SerializedName("has_catalogs") var isHasCatalogs: Boolean = false
    @SerializedName("latitude") var latitude: String? = null
    @SerializedName("longitude") var longitude: String? = null
    @SerializedName("phone_number") var phoneNumber: String? = null
    @SerializedName("retailer_id") var retailerId: String? = null
    @SerializedName("retailer_name") var retailerName: String? = null
    @SerializedName("shop_id") var shopId: String? = null
    @SerializedName("shop_name") var shopName: String? = null
    @SerializedName("web") var web: String? = null
}