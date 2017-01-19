package net.andapps.nearby.data.repository

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import net.andapps.nearby.data.exceptions.ConnectivityException
import javax.inject.Inject


/**
 * Created by Joan on 19/01/2017.
 */
open class BaseRepository @Inject constructor(val context: Context){


    @Throws(ConnectivityException::class)
    protected fun thereIsConnectivity(): Boolean {

        val activeNetwork : NetworkInfo? =
                (context.getSystemService(Context.CONNECTIVITY_SERVICE)
                        as ConnectivityManager)
                .activeNetworkInfo

        return activeNetwork?.isConnectedOrConnecting ?: false
    }
}