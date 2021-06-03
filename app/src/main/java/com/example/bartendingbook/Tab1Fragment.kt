package com.example.bartendingbook

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.ListFragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast


class Tab1Fragment : Fragment(){ //, CaptionedImagesAdapter.Listener
    lateinit var adapter : CaptionedImagesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val cocktailRecycler : RecyclerView = inflater.inflate(R.layout.fragment_tab1, container, false) as RecyclerView

        val listCocktails=  MyApplication.Companion.getCocktailsInRange(0,(MyApplication.cocktailsNum/2)-1)  //ArrayList<Cocktail>()

         adapter= CaptionedImagesAdapter(listCocktails) // :CaptionedImagesAdapter

        cocktailRecycler.adapter =adapter

        val layoutManager : GridLayoutManager = GridLayoutManager(getActivity(),2)
        cocktailRecycler.layoutManager= layoutManager

        //adapter.setListener(CaptionedImagesAdapter.Listener)
        adapter.setListener(object : CaptionedImagesAdapter.Listener{
            override fun onClick(position : Int){
                val intent = Intent(getActivity(),CocktailDetailActivity::class.java)
                intent.putExtra(CocktailDetailActivity.EXTRA_COCKTAIL_ID,position)
                getActivity()?.startActivity(intent)
            }
        })

        return cocktailRecycler

    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Tab1Fragment().apply {
                arguments = Bundle().apply {

                }
            }
    }




}