package sulistiyanto.com.rajaongkirtest.ui.home

import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import io.realm.Realm

import sulistiyanto.com.rajaongkirtest.R
import sulistiyanto.com.rajaongkirtest.adapter.AdapterCity
import sulistiyanto.com.rajaongkirtest.application.MyApplication
import sulistiyanto.com.rajaongkirtest.di.subcomponent.FragmentComponent
import sulistiyanto.com.rajaongkirtest.local.city.CityHelper
import sulistiyanto.com.rajaongkirtest.ui.base.BaseFragment
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : BaseFragment(), HomeView {

    private var spinner: Spinner? = null
    private var etOrigin: EditText? = null
    private var etDestination: EditText? = null
    private var etWeight: EditText? = null
    private var realm = Realm.getDefaultInstance()

    @Inject
    lateinit var presenter: HomePresenter
    @Inject
    lateinit var cityHelper: CityHelper

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
        etOrigin = rootView?.findViewById(R.id.et_origin)
        etDestination = rootView?.findViewById(R.id.et_destination)
        etWeight = rootView?.findViewById(R.id.et_weight)

        initSpinner(rootView)

        presenter.getCost()
    }

    override fun onPrepareOptionsMenu(menu: Menu?) {
        val mSearchMenuItem = menu?.findItem(R.id.action_search)
        val searchView = mSearchMenuItem?.actionView as SearchView
        mSearchMenuItem.isVisible = false
        searchView.visibility = View.GONE
    }

    override fun displayError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    private fun initSpinner(rootView: View?) {
        spinner = rootView?.findViewById(R.id.spinner)
        val list = arrayOf("JNE", "POS", "TIKI")
        val adapter = ArrayAdapter(context!!, android.R.layout.simple_spinner_item, list)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner?.adapter = adapter
    }

}
