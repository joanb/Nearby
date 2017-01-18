package net.andapps.nearby.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity


/**
 * Created by Joan on 17/01/2017.
 */
abstract class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initializeDependencyInjection()
        onViewLoaded()
    }

    abstract fun initializeDependencyInjection()

    abstract fun onViewLoaded()

}