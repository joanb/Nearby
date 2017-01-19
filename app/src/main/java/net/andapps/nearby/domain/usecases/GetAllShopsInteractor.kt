package net.andapps.nearby.domain.usecases

import net.andapps.nearby.domain.model.Shop
import net.andapps.nearby.domain.repository.ShopsRepository
import net.andapps.nearby.domain.threads.PostExecutionThread
import net.andapps.nearby.domain.threads.ThreadExecutor
import javax.inject.Inject


/**
 * Created by Joan on 18/01/2017.
 */
class GetAllShopsInteractor
@Inject constructor(val executor: ThreadExecutor,
                    postExecutionThread: PostExecutionThread,
                    val shopsRepository: ShopsRepository)
    : BaseUseCase<List<Shop>>(postExecutionThread), GetAllShopsUseCase {

    lateinit var callback : GetAllShopsUseCase.GetAllShopsCallback

    override fun execute(getAllShopsCallback: GetAllShopsUseCase.GetAllShopsCallback) {
        callback = getAllShopsCallback
        executor.execute(this)
    }

    override fun run() {
        shopsRepository.getAll(object: ShopsRepository.GetAllPlacesCallback {
            override fun onError(exception: Exception) {
                notifyOnError(exception, callback)
            }

            override fun onSuccess(param: List<Shop>) {
                notifyOnSuccess(param, callback)
            }
        })
    }


}