/*
Created by Helm  18/01/2017.
*/


package net.andapps.nearby.data.repository.shops


import net.andapps.nearby.data.model.DataShop
import retrofit2.Call
import retrofit2.http.GET
import java.util.*

interface ShopsService {

    @GET("shops.json")
    fun getShops(): Call<ArrayList<DataShop>>
}
