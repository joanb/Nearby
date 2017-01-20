package net.andapps.nearby.ui.shops.pages.list

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_shops_list.*
import net.andapps.nearby.R
import net.andapps.nearby.ui.NearbyApp
import net.andapps.nearby.ui.di.components.DaggerFragmentComponent
import net.andapps.nearby.ui.di.components.FragmentComponent
import net.andapps.nearby.ui.di.modules.FragmentModule
import net.andapps.nearby.ui.di.modules.FragmentViewModule
import net.andapps.nearby.ui.entities.ShopViewEntity
import javax.inject.Inject


/**
 * Created by Joan on 17/01/2017.
 */
class ShopsListFragment : Fragment(), ShopsListView {

    @Inject
    lateinit var presenter: ShopsListPresenter


    var recyclerViewAdapter: ShopsAdapter? = null

    val component: FragmentComponent
        get() = DaggerFragmentComponent.builder()
                .applicationComponent((activity.application as NearbyApp).component)
                .fragmentModule(FragmentModule(this))
                .fragmentViewModule(FragmentViewModule(this))
                .build()


    fun initializeInjection() {
        component.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_shops_list, container, false)
        initializeInjection()
        return view
    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onStart()
    }

    override fun initializeViews() {
        recyclerViewAdapter = ShopsAdapter(presenter)
        shops_recycler_view.adapter = recyclerViewAdapter
        shops_recycler_view.layoutManager = LinearLayoutManager(activity)
    }

    override fun showLoadingFeedback() {

    }

    override fun showShops(shops: List<ShopViewEntity>) {
        recyclerViewAdapter?.setShops(shops)
    }

    override fun retrieveActivityContext(): Context = activity
}
