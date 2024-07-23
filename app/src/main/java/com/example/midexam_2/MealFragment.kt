package com.example.midexam_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

class MealFragment : Fragment() {

    private lateinit var listViewMeals: ListView
    private lateinit var mealAdapter: ArrayAdapter<String>
    private val meals = mutableListOf<String>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_meal, container, false)
        listViewMeals = view.findViewById(R.id.listViewMeals)
        mealAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, meals)
        listViewMeals.adapter = mealAdapter
        return view
    }

    fun addMeal(meal: String) {
        meals.add(meal)
        mealAdapter.notifyDataSetChanged()
    }
}
