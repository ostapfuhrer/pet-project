package com.example.coronaproject.screens.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.coronaproject.R
import com.example.coronaproject.model.CountryItem

class CountryStatsRecyclerAdapter(var onItemClick: ((String) -> Unit)) :
    Adapter<CountryStatsRecyclerAdapter.ViewHolder>() {

    private var listAttributes = emptyList<CountryItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_country, parent, false)
        return ViewHolder(view)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var tvCountryName: TextView = itemView.findViewById(R.id.tv_countryName)
        private var tvConfirmedCases: TextView = itemView.findViewById(R.id.tv_confirmedCases)
        private var tvLastUpdated: TextView = itemView.findViewById(R.id.tv_lastUpdated)
        private var container: LinearLayout = itemView.findViewById(R.id.container)

        @SuppressLint("SetTextI18n")
        fun bind(countryItem: CountryItem) {
            tvCountryName.text = "Country region: " + countryItem.nameOfCountry
            tvConfirmedCases.text = "Confirmed cases: " + countryItem.confirmedCases.toString()
            tvLastUpdated.text = "Last update: " + countryItem.lastUpdate
            container.setOnClickListener {
                onItemClick(countryItem.nameOfCountry)
            }
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val model = listAttributes[position]
        holder.bind(model)

    }

    override fun getItemCount(): Int {
        return listAttributes.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setCountryList(countryList: List<CountryItem>) {
        this.listAttributes = countryList
        notifyDataSetChanged()
    }
}