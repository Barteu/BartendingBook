package com.example.bartendingbook

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.ActionBar

import android.support.v7.widget.Toolbar
import android.view.Menu
import android.widget.ImageView
import android.widget.TextView

import android.view.MenuItem
import android.view.View
import android.widget.Toast

class CocktailDetailActivity : AppCompatActivity() {

    companion object{
        val EXTRA_COCKTAIL_ID : String = "cocktailId"
    }

    var cocktailId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cocktail_detail)

        //ustawianie paska narzedzi
        val toolbar = findViewById<Toolbar>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val actionBar : ActionBar? = getSupportActionBar()
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        //wyswietlanie informacji
        cocktailId  = getIntent().getExtras()?.get(EXTRA_COCKTAIL_ID) as Int

        val cocktail = MyApplication.getCocktailById(cocktailId)

        val cocktailName : String = cocktail.name
        val textView = findViewById<TextView>(R.id.cocktail_text)
        textView.text = cocktailName
        val cocktailImage :Int = cocktail.imageResourceId
        val imageView = findViewById<ImageView>(R.id.cocktail_image)
        imageView.setImageDrawable(ContextCompat.getDrawable(this,cocktailImage))
        imageView.contentDescription = cocktailName

        val cocktailDescription = findViewById<TextView>(R.id.cocktail_description)
        cocktailDescription.text = cocktail.description

        val cocktailIngredients = findViewById<TextView>(R.id.textIngredients)
        cocktailIngredients.text = cocktail.ingredients
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.getItemId())
        {
            R.id.action_recpie -> {
                val intent = Intent(this,CocktailRecipeActivity::class.java)
                intent.putExtra(EXTRA_COCKTAIL_ID,cocktailId)
                startActivity(intent)
                return true
            }
            else ->  return super.onOptionsItemSelected(item)
        }

    }
    
    fun onClickFAB(view: View){

        val intent = Intent(this,CocktailRecipeActivity::class.java)
        intent.putExtra(EXTRA_COCKTAIL_ID,cocktailId)
        startActivity(intent)

    }

}