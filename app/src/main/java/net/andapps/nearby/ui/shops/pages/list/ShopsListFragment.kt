package net.andapps.nearby.ui.shops.pages.list

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import net.andapps.nearby.R


/**
 * Created by Joan on 17/01/2017.
 */
class ShopsListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_shops_list, container, false)
        return view
    }
}