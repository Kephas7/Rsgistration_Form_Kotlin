package com.example.registrationform

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.registrationform.Adapter.Adapter
import com.example.registrationform.databinding.ActivityDestinationAcitivityBinding

class DestinationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDestinationAcitivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDestinationAcitivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Retrieve Data from Intent
        val name = intent.getStringExtra("name")
        val email = intent.getStringExtra("email")
        val gender = intent.getStringExtra("gender")
        val city = intent.getStringExtra("city")
        val country = intent.getStringExtra("country")

        // Set the Retrieved Data to TextView
        binding.output.text = """
            Name: $name
            Email: $email
            Gender: $gender
            City: $city
            Country: $country
        """.trimIndent()

        // RecyclerView Setup
        val imagelist = arrayListOf(
            R.drawable.g1,
            R.drawable.g2,
            R.drawable.g3,
            R.drawable.g4,
            R.drawable.g5,
            R.drawable.g6,
            R.drawable.g7
        )
        val namelist = arrayListOf(
            "Guitar 1", "Guitar 2", "Guitar 3", "Guitar 4",
            "Guitar 5", "Guitar 6", "Guitar 7"
        )
        val desclist = arrayListOf(
            "This is Guitar 1", "This is Guitar 2", "This is Guitar 3",
            "This is Guitar 4", "This is Guitar 5", "This is Guitar 6", "This is Guitar 7"
        )

        val adapter = Adapter(this, imagelist, namelist, desclist)

        binding.recycleView.layoutManager = LinearLayoutManager(this)
        binding.recycleView.adapter = adapter
    }
}
