package info.charith.midpractical1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

internal class CountryAdapter(
    var countryList: List<Country>,
    private var listener: OnItemClickListener
) :
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
        holder.checkBox.isChecked = country.isChecked

        holder.content.setOnClickListener {
            /**
             * Change check box state according to the on item click event
             */
            if (country.isChecked) {
                country.isChecked = false
                holder.checkBox.isChecked = false
            } else {
                country.isChecked = true
                holder.checkBox.isChecked = true
            }

            /**
             * Call on click event
             */
            listener.onItemClick(country)

        }
    }


    override fun getItemCount(): Int {
        return countryList.size
    }

    /**
     * On Item Click Listener
     */
    interface OnItemClickListener {
        fun onItemClick(county: Country)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.findViewById<TextView>(R.id.tvName)!!
        val icon = itemView.findViewById<ImageView>(R.id.icon)!!
        val checkBox = itemView.findViewById<CheckBox>(R.id.checkBox)!!
        val content = itemView.findViewById<ConstraintLayout>(R.id.contentLayout)!!
    }

}
