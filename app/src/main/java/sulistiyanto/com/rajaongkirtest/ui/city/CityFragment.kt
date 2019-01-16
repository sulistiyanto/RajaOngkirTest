package sulistiyanto.com.rajaongkirtest.ui.city


import android.support.v4.app.Fragment
import android.view.View
import android.widget.Toast

import sulistiyanto.com.rajaongkirtest.R
import sulistiyanto.com.rajaongkirtest.application.MyApplication
import sulistiyanto.com.rajaongkirtest.di.subcomponent.FragmentComponent
import sulistiyanto.com.rajaongkirtest.ui.base.BaseFragment
import sulistiyanto.com.rajaongkirtest.utilities.ConnectingNetwork
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 *
 */
class CityFragment : BaseFragment(), CityView {

    @Inject
    lateinit var presenter: CityPresenter
    @Inject
    lateinit var connectingNetwork: ConnectingNetwork

    override fun getFragmentLayout(): Int = R.layout.fragment_city

    override fun initInjection() {
        val fragmentComponent: FragmentComponent = (activity?.applicationContext as MyApplication)
            .appComponent
            .fragmentComponent()
            .build()

        fragmentComponent.inject(this)
    }

    override fun initLayout(rootView: View?) {
        presenter.attach(this)
        initRecyclerView()
        presenter.getCityFromAPI()
    }

    override fun displayError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    private fun initRecyclerView() {

    }
}
