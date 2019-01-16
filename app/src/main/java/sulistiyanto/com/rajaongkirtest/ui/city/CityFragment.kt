package sulistiyanto.com.rajaongkirtest.ui.city


import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.View
import android.widget.ProgressBar
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
class CityFragment : BaseFragment(), CityView {

    private var rvCity: RecyclerView? = null
    private var progressBar : ProgressBar? = null
    private var realm = Realm.getDefaultInstance()

    @Inject
    lateinit var presenter: CityPresenter
    @Inject
    lateinit var cityHelper: CityHelper

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
        setHasOptionsMenu(true)
        rvCity = rootView?.findViewById(R.id.rv_city)
        progressBar = rootView?.findViewById(R.id.progressBar)
        initRecyclerView()

        presenter.checkDataCity(realm, cityHelper)
    }

    override fun displayError(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    private fun initRecyclerView() {
        rvCity?.layoutManager = LinearLayoutManager(context)
        rvCity?.itemAnimator = DefaultItemAnimator()
        rvCity?.setHasFixedSize(true)
    }

    override fun displayCity(adapter: AdapterCity) {
        rvCity?.adapter = adapter
    }

    override fun onPrepareOptionsMenu(menu: Menu?) {
        val mSearchMenuItem = menu?.findItem(R.id.action_search)
        val searchView = mSearchMenuItem?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                // do something on text submit
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                // do something when text changes
                return false
            }
        })
        super.onPrepareOptionsMenu(menu)
    }
}
