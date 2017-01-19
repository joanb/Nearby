package net.andapps.nearby.ui.shops

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_shops.*
import net.andapps.nearby.R
import net.andapps.nearby.ui.BaseActivity
import net.andapps.nearby.ui.NearbyApp
import net.andapps.nearby.ui.di.components.ActivityComponent
import net.andapps.nearby.ui.di.components.DaggerActivityComponent
import net.andapps.nearby.ui.di.modules.ActivityModule
import net.andapps.nearby.ui.di.modules.ActivityViewModule
import javax.inject.Inject

class ShopsActivity : BaseActivity(), ShopsView {

    var pagerAdapter: ShopsPagerAdapter? = null
    @Inject lateinit var shopsPresenter: ShopsPresenter

    private val component : ActivityComponent
        get() = DaggerActivityComponent.builder()
                .applicationComponent((application as NearbyApp).component)
                .activityModule(ActivityModule(this))
                .activityViewModule(ActivityViewModule(this))
                .build()


    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_shops)
        super.onCreate(savedInstanceState)

    }

    override fun onViewLoaded() {
        shopsPresenter.onStart()
    }

    override fun initializeViews() {
        setSupportActionBar(toolbar)

        pagerAdapter = ShopsPagerAdapter(supportFragmentManager)
        pager?.adapter = pagerAdapter
        tabs.setupWithViewPager(pager)
    }


    override fun initializeDependencyInjection() {
        component.inject(this)
    }
}
