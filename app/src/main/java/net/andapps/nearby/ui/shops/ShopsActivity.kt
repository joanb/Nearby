package net.andapps.nearby.ui.shops

import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shops.*
import net.andapps.nearby.R
import net.andapps.nearby.ui.BaseActivity
import net.andapps.nearby.ui.NearbyApp
import net.andapps.nearby.ui.di.components.ActivityComponent
import net.andapps.nearby.ui.di.components.DaggerActivityComponent
import net.andapps.nearby.ui.di.modules.ActivityModule
import net.andapps.nearby.ui.di.modules.ViewModule
import javax.inject.Inject

class ShopsActivity : BaseActivity(), ShopsView {

    override fun showSnack() {
        Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show()
    }

    @Inject lateinit var shopsPresenter: ShopsPresenter

    private val component : ActivityComponent
        get() = DaggerActivityComponent.builder()
                .applicationComponent((application as NearbyApp).component)
                .activityModule(ActivityModule(this))
                .viewModule(ViewModule(this))
                .build()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shops)

        component.inject(this)
        onInitializeView()
    }

    fun onInitializeView() {
        setSupportActionBar(toolbar)

        pager?.adapter = ShopsPagerAdapter(supportFragmentManager)

        tabs.setupWithViewPager(pager)


        shopsPresenter.onStart()
    }


    override fun initializeDependencyInjection() {
        component.inject(this)
    }
}
