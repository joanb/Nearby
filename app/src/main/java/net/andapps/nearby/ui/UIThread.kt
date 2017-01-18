package net.andapps.nearby.ui

import android.os.Handler
import android.os.Looper
import net.andapps.nearby.domain.threads.PostExecutionThread
import javax.inject.Inject


/**
 * Created by Joan on 17/01/2017.
 */
class UIThread
@Inject constructor(): PostExecutionThread {


    private val handler: Handler = Handler(Looper.getMainLooper())

    override fun post(runnable: Runnable) {
        handler.post(runnable)
    }
}