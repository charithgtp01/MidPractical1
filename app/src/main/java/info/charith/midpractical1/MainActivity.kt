package info.charith.midpractical1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import info.charith.midpractical1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var dataBinding: ActivityMainBinding
    private lateinit var countryList: List<Country>
    private lateinit var countryAdapter: CountryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setCountryData()
        setAdapter()
    }

    //Create Adapter and set to the Recycle View
    private fun setAdapter() {
        //Initiated OnItem Click Listener
        val listener = object : CountryAdapter.OnItemClickListener {
            override fun onItemClick(county: Country) {
                Toast.makeText(applicationContext, county.name, Toast.LENGTH_SHORT).show()
            }
        }

        countryAdapter = CountryAdapter(countryList, listener)
        val layoutManager = LinearLayoutManager(applicationContext)
        dataBinding.recycleView.layoutManager = layoutManager
        dataBinding.recycleView.adapter = countryAdapter


    }

    //Set Country Details
    private fun setCountryData() {
        countryList = listOf(
            Country(R.mipmap.argentina, "Argentina", false),
            Country(R.mipmap.australia, "Australia", false),
            Country(R.mipmap.bangladesh, "Bangladesh", false),
            Country(R.mipmap.canada, "Canada", false),
            Country(R.mipmap.china, "China", false),
            Country(R.mipmap.finland, "Finland", false),
            Country(R.mipmap.france, "France", false),
            Country(R.mipmap.great_britain, "Great Britain", false),
            Country(R.mipmap.india, "India", false),
            Country(R.mipmap.japan, "Japan", false),
            Country(R.mipmap.norway, "Norway", false),
            Country(R.mipmap.pakistan, "Pakistan", false),
            Country(R.mipmap.srilanka, "Sri Lanka", false),
            Country(R.mipmap.united_states, "United States", false)
        )
    }
}