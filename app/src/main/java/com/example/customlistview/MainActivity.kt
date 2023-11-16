package com.example.customlistview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import com.example.customlistview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var listAdapter: ListAdapter
    private lateinit var listData: ListData
    var dataArrayList = ArrayList<ListData?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nameList = arrayOf("First Aid", "Sewing", "Landscaping", "Life Skills", "Child Minding", "Cooking", "Gardening")

        val timeList =
            arrayOf("6 Months", "6 Months", "6 Months", "6 Months", "6 Weeks", "6 Weeks", "6 Weeks")

        val priceList = arrayOf("R1 500", "R1 500", "R1 500", "R1 500", "R750", "R750", "R750")

        val imageList = intArrayOf(
            R.drawable.firstaid,
            R.drawable.sewing,
            R.drawable.landscaping,
            R.drawable.lifeskills,
            R.drawable.childcare,
            R.drawable.cooking,
            R.drawable.gardenmaintenance
        )
        val ingredientList = intArrayOf(
            R.string.firstaidPurpose,
            R.string.sewingPurpose,
            R.string.landscapingPurpose,
            R.string.lifeskillsPurpose,
            R.string.childmindingPurpose,
            R.string.cookingPurpose,
            R.string.gardenPurpose
        )
        val descList = intArrayOf(
            R.string.firstaidDesc,
            R.string.sewingDesc,
            R.string.landscapingDesc,
            R.string.lifeskillsDesc,
            R.string.childmindingDesc,
            R.string.cookingDesc,
            R.string.gardenDesc
        )
        for (i in imageList.indices) {
            listData = ListData(
                nameList[i],
                timeList[i], priceList[i], ingredientList[i], descList[i], imageList[i]
            )
            dataArrayList.add(listData)
       }
        listAdapter = ListAdapter(this@MainActivity, dataArrayList)
        binding.listview.adapter = listAdapter
        binding.listview.isClickable = true
        binding.listview.onItemClickListener =
            AdapterView.OnItemClickListener { adapterView, view, i, l ->
                val intent = Intent(this@MainActivity, DetailedActivity::class.java)
                intent.putExtra("name", nameList[i])
                intent.putExtra("time", timeList[i])
                intent.putExtra("price", priceList[i])
                intent.putExtra("ingredients", ingredientList[i])
                intent.putExtra("desc", descList[i])
                intent.putExtra("image", imageList[i])
                startActivity(intent)
            }
    }
}