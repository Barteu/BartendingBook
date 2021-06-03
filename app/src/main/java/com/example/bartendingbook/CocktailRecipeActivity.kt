package com.example.bartendingbook

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.widget.Toolbar
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class CocktailRecipeActivity : AppCompatActivity() {

    var cocktailId:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_cocktail_recipe)


        cocktailId  = getIntent().getExtras()?.get(CocktailDetailActivity.EXTRA_COCKTAIL_ID) as Int

        //ustawianie paska narzedzi
        val toolbar = findViewById<Toolbar>(R.id.toolbar) as Toolbar

        setSupportActionBar(toolbar)

        val actionBar : ActionBar? = getSupportActionBar()
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        val cocktail = MyApplication.getCocktailById(cocktailId)
        setTitle(cocktail.name)

        val text_ingredients = findViewById<TextView>(R.id.textIngredients2)
        text_ingredients.text = cocktail.ingredients

        val text_recipe = findViewById<TextView>(R.id.text_recipe)
        text_recipe.text = cocktail.recipe

        val img_recipe = findViewById<ImageView>(R.id.img_recipe)
        img_recipe.setImageResource(cocktail.imageResourceId)



    }

}