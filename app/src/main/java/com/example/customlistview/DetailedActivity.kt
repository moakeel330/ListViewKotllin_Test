package com.example.customlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customlistview.databinding.ActivityDetailedBinding

class DetailedActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetailedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = this.intent
        if (intent != null) {
            val name = intent.getStringExtra("name")
            val time = intent.getStringExtra("time")
            val price = intent.getStringExtra("price")
            val ingredients = intent.getIntExtra("ingredients", R.string.firstaidPurpose)
            val desc = intent.getIntExtra("desc", R.string.firstaidDesc)
            val image = intent.getIntExtra("image", R.drawable.firstaid)
            binding.detailName.text = name
            binding.detailTime.text = time
            binding.detailPrice.text = price
            binding.detailDesc.setText(desc)
            binding.detailIngredients.setText(ingredients)
            binding.detailImage.setImageResource(image)
        }
    }

}