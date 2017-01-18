package net.andapps.nearby.ui.shops

import javax.inject.Inject


/**
 * Created by Joan on 17/01/2017.
 */

class ShopsPresenter
@Inject constructor(val view: ShopsView) {

    fun onStart() {
        view.showSnack()
    }
}
