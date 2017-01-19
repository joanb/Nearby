package net.andapps.nearby.data.mapper

import java.util.*


/**
 * Created by Joan on 19/01/2017.
 */
abstract class BaseMapper<Data, Model> {


    abstract fun map(entity: Data?): Model?

    fun map(collection: Collection<Data>): List<Model> {
        val list = ArrayList<Model>()
        var model: Model?
        for (entity in collection) {
            model = map(entity)
            if (model != null) {
                list.add(model)
            }
        }
        return list
    }
}