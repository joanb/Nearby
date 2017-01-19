package net.andapps.nearby.data.repository

import android.content.Context
import android.net.ConnectivityManager
import net.andapps.nearby.data.exceptions.ConnectivityException


/**
 * Created by Joan on 18/01/2017.
 */
class BaseRepository constructor(val context: Context) {


    fun checkConnectivity() {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val activeNetwork = cm.activeNetworkInfo

        if (activeNetwork == null || !activeNetwork.isConnectedOrConnecting)
            throw ConnectivityException(context)
    }
}