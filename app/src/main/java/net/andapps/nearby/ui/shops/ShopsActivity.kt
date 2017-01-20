package net.andapps.nearby.ui.shops

import android.os.Bundle
import android.support.annotation.NonNull
import android.support.design.widget.BottomNavigationView
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_shops.*
import net.andapps.nearby.R
import net.andapps.nearby.ui.BaseActivity
import net.andapps.nearby.ui.NearbyApp
import net.andapps.nearby.ui.di.components.ActivityComponent
import net.andapps.nearby.ui.di.components.DaggerActivityComponent
import net.andapps.nearby.ui.di.modules.ActivityModule
import net.andapps.nearby.ui.di.modules.ActivityViewModule
import javax.inject.Inject

class ShopsActivity : BaseActivity(), ShopsView, BottomNavigationView.OnNavigationItemSelectedListener {

    var pagerAdapter: ShopsPagerAdapter? = null
    @Inject lateinit var presenter: ShopsPresenter

    private val component: ActivityComponent
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
        presenter.onStart()
    }


    override fun  onNavigationItemSelected(@NonNull item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.place -> presenter.onPlacesSeleted()
            R.id.list -> presenter.onListSelected()
        }
        return true
    }

    override fun initializeViews() {
        setSupportActionBar(toolbar)

        pagerAdapter = ShopsPagerAdapter(supportFragmentManager)
        pager?.adapter = pagerAdapter
        tabs.setupWithViewPager(pager)

        bottom_navigation.setOnNavigationItemSelectedListener(this)

    }


    override fun initializeDependencyInjection() {
        component.inject(this)
    }
}
