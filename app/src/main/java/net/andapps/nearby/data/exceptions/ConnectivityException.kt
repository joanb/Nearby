package net.andapps.nearby.data.exceptions

import android.content.Context
import net.andapps.nearby.R


/**
 * Created by Joan on 18/01/2017.
 */
class ConnectivityException constructor(context: Context): Exception() {

    override val message: String = context.getString(R.string.exception_connectivity_message)
}