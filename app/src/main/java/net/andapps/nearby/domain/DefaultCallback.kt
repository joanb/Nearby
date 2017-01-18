package net.andapps.nearby.domain


/**
 * Created by Joan on 18/01/2017.
 */
interface DefaultCallback<T> {

    fun onError(exception: Exception)
    fun onSuccess(param: T)
}