package com.example.midexam_2

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    private lateinit var spinnerMealType: Spinner
    private lateinit var buttonAddMeal: Button
    private val mealFragment = MealFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spinnerMealType = findViewById(R.id.spinnerMealType)
        buttonAddMeal = findViewById(R.id.buttonAddMeal)

        // Set up the spinner
        val mealTypes = arrayOf("Breakfast", "Lunch", "Dinner")
        val adapter = ArrayAdapter(this, R.layout.spinner_items, mealTypes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerMealType.adapter = adapter

        // Set up the fragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, mealFragment)
                .commit()
        }

        // Button click listener
        buttonAddMeal.setOnClickListener {
            val selectedMealType = spinnerMealType.selectedItem.toString()
            mealFragment.addMeal(selectedMealType)
        }
    }
}
