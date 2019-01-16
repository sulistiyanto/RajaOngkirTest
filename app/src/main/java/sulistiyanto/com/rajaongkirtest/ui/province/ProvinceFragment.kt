package sulistiyanto.com.rajaongkirtest.ui.province

import android.support.v4.app.Fragment
import android.view.View
import android.widget.Toast
import io.realm.Realm

import sulistiyanto.com.rajaongkirtest.R
import sulistiyanto.com.rajaongkirtest.application.MyApplication
import sulistiyanto.com.rajaongkirtest.di.subcomponent.FragmentComponent
import sulistiyanto.com.rajaongkirtest.local.province.ProvinceHelper
import sulistiyanto.com.rajaongkirtest.ui.base.BaseFragment
import sulistiyanto.com.rajaongkirtest.utilities.ConnectingNetwork
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 *
 */
class ProvinceFragment : BaseFragment(), ProvinceView {

    private var realm = Realm.getDefaultInstance()

    @Inject
    lateinit var presenter: ProvincePresenter
    @Inject
    lateinit var connectingNetwork: ConnectingNetwork
    @Inject
    lateinit var provinceHelper: ProvinceHelper

    override fun getFragmentLayout(): Int = R.layout.fragment_province

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

        presenter.checkDataProvince(realm, provinceHelper)
    }

    override fun displayError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    private fun initRecyclerView() {

    }
}
