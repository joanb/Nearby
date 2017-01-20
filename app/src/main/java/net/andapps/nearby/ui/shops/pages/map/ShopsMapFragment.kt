/*
Created by Helm  17/01/2017.
*/


package net.andapps.nearby.ui.shops.pages.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import net.andapps.nearby.ui.NearbyApp
import net.andapps.nearby.ui.di.components.DaggerFragmentComponent
import net.andapps.nearby.ui.di.components.FragmentComponent
import net.andapps.nearby.ui.di.modules.FragmentModule
import net.andapps.nearby.ui.di.modules.FragmentViewModule
import net.andapps.nearby.ui.entities.ShopViewEntity
import javax.inject.Inject

class ShopsMapFragment : SupportMapFragment(), ShopsMapView, OnMapReadyCallback {

    val component: FragmentComponent
        get() = DaggerFragmentComponent.builder()
                .applicationComponent((activity.application as NearbyApp).component)
                .fragmentModule(FragmentModule(this))
                .fragmentViewModule(FragmentViewModule(this))
                .build()

    fun initializeInjection() {
        component.inject(this)
    }
//
    private val TIENDEO = LatLng(41.380968, 2.185584)
    @Inject lateinit var presenter: ShopsMapPresenter
    var map: GoogleMap? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        initializeInjection()
        getMapAsync(this)
        return view
    }


    override fun showLoadingFeedback() {

    }

    override fun showShops(shops: List<ShopViewEntity>) {
        for (shop: ShopViewEntity in shops) {
            //todo: pasar directamente a objeto de vista shop con estos parámetros
            val location = LatLng(shop.latitude!!, shop.longitude!!)
            map?.addMarker(MarkerOptions().position(location).title(shop.retailerName).snippet(shop.street))
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        presenter.onStart()
        map = googleMap
        map!!.addMarker(MarkerOptions().position(TIENDEO).title("Tiendeo Office"))
        map!!.moveCamera(CameraUpdateFactory.newLatLngZoom(TIENDEO, 16f))
    }

}



