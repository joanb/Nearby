package net.andapps.nearby.domain.threads


/**
 * Created by Joan on 18/01/2017.
 */
interface PostExecutionThread {

    fun post(runnable: Runnable)
}