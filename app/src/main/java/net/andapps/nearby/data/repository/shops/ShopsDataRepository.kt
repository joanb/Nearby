package net.andapps.nearby.data.repository.shops

import android.content.Context
import io.realm.Realm
import net.andapps.nearby.data.mapper.ShopMapper
import net.andapps.nearby.data.model.DataShop
import net.andapps.nearby.data.repository.BaseRepository
import net.andapps.nearby.domain.repository.ShopsRepository
import retrofit2.Retrofit
import java.util.*
import javax.inject.Inject
import javax.inject.Named


/**
 * Created by Joan on 18/01/2017.
 */

class ShopsDataRepository @Inject constructor(@Named("tiendeo API") val retrofit: Retrofit,
                                              val shopMapper: ShopMapper,
                                              context: Context)
    : BaseRepository(context), ShopsRepository {


    companion object {
        val TEN_MINUTES: Long = 600000
    }

    @Synchronized
    override fun getAll(callback: ShopsRepository.GetAllPlacesCallback) {

        try {
            val shops = getFromDisk() ?:
            getFromApi()

            callback.onSuccess(shopMapper.map(shops))

        } catch (e: Exception) {
            callback.onError(e)
        }
    }

    private fun getFromApi() : List<DataShop> {

        val shops = retrofit.create(ShopsService::class.java).getShops().execute().body()
        insertOrUpdate(shops)
        return shops
    }

    private fun getFromDisk(): List<DataShop>? {

        val shops : List<DataShop>  = Realm.getDefaultInstance().where(DataShop::class.java).findAll()
        if (shops?.size != 0 && shouldUseDisk(shops))
            return shops
        else
            return null
    }

    //little caching
    private fun shouldUseDisk(shops: List<DataShop>): Boolean {
        return !thereIsConnectivity()
                || System.currentTimeMillis().minus(shops[0].retrievedTimeStamp as Long) <= Companion.TEN_MINUTES
    }

    private fun insertOrUpdate(shops: ArrayList<DataShop>) {

        shops[0].retrievedTimeStamp = System.currentTimeMillis()


        val realm = Realm.getDefaultInstance()
        realm.beginTransaction()
        realm.where(DataShop::class.java).findAll().deleteAllFromRealm()
        shops.map { realm.copyToRealm(it) }
        realm.commitTransaction()
    }

}