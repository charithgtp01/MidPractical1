package info.charith.midpractical1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

internal class CountryAdapter(var countryList: List<Country>) :
    RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.country_list_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val country = countryList[position]
        holder.tvName.text = country.name
        holder.icon.setImageResource(country.img)
//        holder.checkBox.isChecked = country.isChecked
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.findViewById<TextView>(R.id.tvName)!!
        val icon = itemView.findViewById<ImageView>(R.id.icon)!!
        val checkBox = itemView.findViewById<CheckBox>(R.id.checkBox)!!
    }

}
