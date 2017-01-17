package net.andapps.nearby.ui.shops

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_shops.*
import net.andapps.nearby.R

class ShopsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shops)

        onInitializeView()
    }

    fun onInitializeView() {
        setSupportActionBar(toolbar)

        pager?.adapter = ShopsPagerAdapter(supportFragmentManager)

        tabs.setupWithViewPager(pager)
    }
}
