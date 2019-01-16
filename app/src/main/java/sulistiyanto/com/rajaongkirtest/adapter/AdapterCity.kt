package sulistiyanto.com.rajaongkirtest.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_city.view.*
import sulistiyanto.com.rajaongkirtest.R
import sulistiyanto.com.rajaongkirtest.local.city.City

class AdapterCity(private var items: List<City>) : RecyclerView.Adapter<AdapterCity.CityHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): CityHolder {
        return CityHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_city, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: CityHolder, position: Int) {
        holder.bindData(items[position])
    }

    class CityHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val txtCity = itemView.txt_city
        private val txtProvince = itemView.txt_province

        fun bindData(city: City) {
            txtCity.text = city.cityName
            txtProvince.text = city.province
        }

    }
}