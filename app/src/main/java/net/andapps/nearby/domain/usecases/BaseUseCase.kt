package net.andapps.nearby.domain.usecases

import net.andapps.nearby.domain.DefaultCallback
import net.andapps.nearby.domain.threads.PostExecutionThread
import javax.inject.Inject


/**
 * Created by Joan on 18/01/2017.
 */
open class BaseUseCase<T>
@Inject constructor(val postExecutionThread: PostExecutionThread){


    fun notifyOnError(exception: Exception, callback: DefaultCallback<T>) {
        postExecutionThread.post(Runnable { callback.onError(exception) })
    }

    fun notifyOnSuccess(param: T, callback: DefaultCallback<T>) {
        postExecutionThread.post(Runnable { callback.onSuccess(param) })
    }
}