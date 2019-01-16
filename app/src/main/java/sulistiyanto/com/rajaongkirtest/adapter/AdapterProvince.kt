package sulistiyanto.com.rajaongkirtest.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_province.view.*
import sulistiyanto.com.rajaongkirtest.R
import sulistiyanto.com.rajaongkirtest.local.province.Province

class AdapterProvince (private var items: List<Province>) : RecyclerView.Adapter<AdapterProvince.ProvinceHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ProvinceHolder {
        return ProvinceHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_province, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: ProvinceHolder, position: Int) {
        holder.bindData(items[position])
    }

    class ProvinceHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val txtProvince = itemView.txt_city

        fun bindData(province: Province) {
            txtProvince.text = province.province
        }

    }
}