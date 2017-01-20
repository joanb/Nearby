package net.andapps.nearby.ui.shops.detail

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_shops_detail.*
import net.andapps.nearby.R
import net.andapps.nearby.ui.BaseActivity
import net.andapps.nearby.ui.NearbyApp
import net.andapps.nearby.ui.di.components.ActivityComponent
import net.andapps.nearby.ui.di.components.DaggerActivityComponent
import net.andapps.nearby.ui.di.modules.ActivityModule
import net.andapps.nearby.ui.di.modules.ActivityViewModule
import net.andapps.nearby.ui.entities.ShopViewEntity
import javax.inject.Inject


/**
 * Created by Joan on 20/01/2017.
 */
class ShopDetailActivity : BaseActivity(), ShopDetailView{


        @Inject lateinit var presenter : ShopDetailPresenter

        val component: ActivityComponent
            get() = DaggerActivityComponent.builder()
                    .applicationComponent((application as NearbyApp).component)
                    .activityModule(ActivityModule(this))
                    .activityViewModule(ActivityViewModule(this))
                    .build()

    private val SHOP_KEY: String = "shop"

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_shops_detail)
        super.onCreate(savedInstanceState)
    }

    fun getInitializationIntent(context: Context, shopViewEntity: ShopViewEntity) : Intent {
        val intent: Intent = Intent(context, ShopDetailActivity::class.java)
        intent.putExtra(SHOP_KEY, shopViewEntity)
        return intent
    }

    override fun initializeDependencyInjection() {
        component.inject(this)
    }

    override fun onViewLoaded() {
        toolbar.title ="Shop Info"
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val shop: ShopViewEntity = intent.getSerializableExtra(SHOP_KEY) as ShopViewEntity
        presenter.onStart(shop)
    }

    override fun showParams(shopName: String?, address: String?, phoneNumber: String?, web: String?) {
        shopNameTV.text = shopName
        shopAddressTV.text = address
        phoneImageView.setOnClickListener { presenter.onPhoneClicked(phoneNumber) }
        webSiteImageView.setOnClickListener { presenter.onWebSiteClicked(web) }
    }

    override fun openWebsiteFromUrl(url: String?) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
    }

    override fun openDialWithNumber(phoneNumber: String?) {
        startActivity(Intent(Intent.ACTION_DIAL, Uri.parse(phoneNumber)))
    }
}