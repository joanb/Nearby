package net.andapps.nearby.data.executor

import net.andapps.nearby.domain.threads.ThreadExecutor
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import javax.inject.Inject


/**
 * Created by Joan on 18/01/2017.
 */
class JobExecutor
@Inject constructor(): ThreadExecutor {


    private val INITIAL_POOL_SIZE = 3
    private val MAX_POOL_SIZE = 5
    private val KEEP_ALIVE_TIME = 10
    private val KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS


    private val workQueue: BlockingQueue<Runnable> = LinkedBlockingQueue<Runnable>()
    private val threadPoolExecutor: ThreadPoolExecutor

    init {
        threadPoolExecutor = ThreadPoolExecutor(INITIAL_POOL_SIZE, MAX_POOL_SIZE,
                KEEP_ALIVE_TIME.toLong(), KEEP_ALIVE_TIME_UNIT, workQueue)
    }


    override fun execute(runnable: Runnable?) {
        if (runnable == null) {
            throw IllegalArgumentException("Runnable to execute cannot be null")
        }
        this.threadPoolExecutor.execute(runnable)
    }
}