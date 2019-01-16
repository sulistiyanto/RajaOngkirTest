package sulistiyanto.com.rajaongkirtest.ui

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import sulistiyanto.com.rajaongkirtest.R
import sulistiyanto.com.rajaongkirtest.ui.city.CityFragment
import sulistiyanto.com.rajaongkirtest.ui.home.HomeFragment
import sulistiyanto.com.rajaongkirtest.ui.province.ProvinceFragment

class MainActivity : AppCompatActivity() {

    private var fragmentTransaction: FragmentTransaction? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                replaceItem(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_city -> {
                replaceItem(CityFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_province -> {
                replaceItem(ProvinceFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        //add home fragment
        fragmentTransaction = supportFragmentManager?.beginTransaction()
        fragmentTransaction?.add(R.id.container, HomeFragment())
        fragmentTransaction?.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return super.onOptionsItemSelected(item)
    }
    private fun replaceItem(fragment: Fragment) {
        fragmentTransaction = supportFragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.container, fragment)
        fragmentTransaction?.commit()
    }
}
