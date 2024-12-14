package com.example.registrationform

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.registrationform.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {
    lateinit var  binding:ActivityRegistrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var countries = arrayOf("Nepal", "India", "China", "Turkey","USA")
        val countryAdapter = ArrayAdapter(this@RegistrationActivity,android.R.layout.simple_spinner_item,countries).apply {
            setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        }
        binding.countrySpinner.adapter = countryAdapter
        var cities = arrayOf("Kathmandu","Lalitpur","Kritipur","Kanchanpur","Lamjung")
        val citiesAdapter = ArrayAdapter(this@RegistrationActivity,android.R.layout.simple_dropdown_item_1line,cities)
        binding.city.setAdapter(citiesAdapter)

        binding.submit.setOnClickListener {
            val username = binding.name.text.toString().trim()
            val password = binding.password.text.toString().trim()
            val email = binding.email.text.toString().trim()
            val genderSelected= binding.genderGroup.checkedRadioButtonId
            val country=binding.countrySpinner.selectedItem.toString()
            val city = binding.city.text.toString().trim()
            val termsAccepted=binding.termsCheckbox.isChecked

//            var gender = ""
//            if(genderSelected==R.id.male){
//                gender="Male"
//            }else if(genderSelected==R.id.female){
//                gender ="Female"
//            }
            val gender =when(genderSelected){
                R.id.male ->"Male"
                R.id.female ->"Female"
                else -> ""
            }

            when{
                username.isEmpty()->binding.name.error="Name can't be empty"
                email.isEmpty()->binding.email.error="Email can't be empty"
                password.isEmpty()->binding.password.error="Password can't be empty"
                gender.isEmpty() -> showToast("Please select a gender")
                city.isEmpty() -> binding.city.error = "City can't be empty"
                country.isEmpty() -> showToast("Please select a country")
                !termsAccepted -> showToast("You must agree to the Terms and Conditions")

                else->{
                    val intent = Intent(this@RegistrationActivity,DestinationActivity::class.java).apply {
                        putExtra("name",username)
                        putExtra("email", email)
                        putExtra("gender", gender)
                        putExtra("city", city)
                        putExtra("country", country)

                    }
                    startActivity(intent)
                }


            }


        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.male)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this@RegistrationActivity,message,Toast.LENGTH_SHORT).show()

    }
}