package net.andapps.nearby.ui.shops

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import net.andapps.nearby.ui.shops.pages.list.ShopsListFragment
import net.andapps.nearby.ui.shops.pages.map.ShopsMapFragment


/**
 * Created by Joan on 17/01/2017.
 */
class ShopsPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    val titles = listOf("List", "map")

    override fun getItem(position: Int): Fragment {
        var pageFragment : Fragment? = null
        when (position) {
            0 -> pageFragment = ShopsListFragment()
            1 -> pageFragment = ShopsMapFragment()
        }
        return pageFragment!!
    }

    override fun getCount(): Int {
        return titles.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return titles[position]
    }
}