package sulistiyanto.com.rajaongkirtest.ui.home

import android.support.v4.app.Fragment
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.View

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
class HomeFragment : BaseFragment(), HomeView {

    @Inject
    lateinit var presenter: HomePresenter
    @Inject
    lateinit var connectingNetwork: ConnectingNetwork

    override fun getFragmentLayout(): Int = R.layout.fragment_home

    override fun initInjection() {
        val fragmentComponent: FragmentComponent = (activity?.applicationContext as MyApplication)
            .appComponent
            .fragmentComponent()
            .build()

        fragmentComponent.inject(this)
    }

    override fun initLayout(rootView: View?) {
        presenter.attach(this)
        setHasOptionsMenu(true)

    }

    override fun onPrepareOptionsMenu(menu: Menu?) {
        val mSearchMenuItem = menu?.findItem(R.id.action_search)
        val searchView = mSearchMenuItem?.actionView as SearchView
        mSearchMenuItem.isVisible = false
        searchView.visibility = View.GONE
    }

    override fun displayError(message: String) {

    }
}
