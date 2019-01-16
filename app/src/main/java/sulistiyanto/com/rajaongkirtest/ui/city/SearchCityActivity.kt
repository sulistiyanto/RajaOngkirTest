package sulistiyanto.com.rajaongkirtest.ui.city

import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import io.realm.Realm
import sulistiyanto.com.rajaongkirtest.R

import kotlinx.android.synthetic.main.activity_search_city.*
import kotlinx.android.synthetic.main.content_search_city.*
import sulistiyanto.com.rajaongkirtest.adapter.AdapterCity
import sulistiyanto.com.rajaongkirtest.application.MyApplication
import sulistiyanto.com.rajaongkirtest.di.subcomponent.ActivityComponent
import sulistiyanto.com.rajaongkirtest.local.city.CityHelper
import sulistiyanto.com.rajaongkirtest.ui.base.BaseActivity
import javax.inject.Inject

class SearchCityActivity : BaseActivity(), CityView {

    private var realm = Realm.getDefaultInstance()

    @Inject
    lateinit var presenter: CityPresenter
    @Inject
    lateinit var cityHelper: CityHelper

    override fun initInjection() {
        val activityComponent: ActivityComponent = (applicationContext as MyApplication)
            .appComponent
            .activityComponent()
            .build()
        activityComponent.inject(this)
    }

    override fun initLayout() {
        setContentView(R.layout.activity_search_city)
        setSupportActionBar(toolbar)

        rvCity.layoutManager = LinearLayoutManager(this)
        rvCity.itemAnimator = DefaultItemAnimator()
        rvCity.setHasFixedSize(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return super.onOptionsItemSelected(item)
    }

    override fun displayCity(adapter: AdapterCity) {

    }

    override fun displayError(message: String) {
    }


}
