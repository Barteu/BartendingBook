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


class Tab2Fragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val cocktailRecycler : RecyclerView = inflater.inflate(R.layout.fragment_tab2, container, false) as RecyclerView

        val listCocktails=  MyApplication.Companion.getCocktailsInRange((MyApplication.cocktailsNum/2),MyApplication.cocktailsNum-1)  //A


        val adapter :CaptionedImagesAdapter = CaptionedImagesAdapter(listCocktails)
        cocktailRecycler.adapter =adapter

        val layoutManager : GridLayoutManager = GridLayoutManager(getActivity(),2)
        cocktailRecycler.layoutManager= layoutManager

        //adapter.setListener(CaptionedImagesAdapter.Listener)
        adapter.setListener(object : CaptionedImagesAdapter.Listener{
            override fun onClick(position : Int){
                val intent = Intent(getActivity(),CocktailDetailActivity::class.java)
                intent.putExtra(CocktailDetailActivity.EXTRA_COCKTAIL_ID,position+(MyApplication.cocktailsNum/2))
                getActivity()?.startActivity(intent)
            }
        })

        return cocktailRecycler

       // var adapter = ArrayAdapter(inflater.getContext(),android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.kategoria2))
       // setListAdapter(adapter)
        // Inflate the layout for this fragment
      //  return super.onCreateView(inflater, container, savedInstanceState)
        // return inflater.inflate(R.layout.fragment_tab1, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Tab2Fragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}