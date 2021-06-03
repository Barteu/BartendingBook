package com.example.bartendingbook

import android.app.Application
import android.content.Context
import android.content.Intent
import android.content.res.AssetManager
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import java.io.IOException
import java.io.InputStream


class MainActivity : AppCompatActivity() {
    lateinit var pagerAdapter : SectionsPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        pagerAdapter = SectionsPagerAdapter(supportFragmentManager,this)
        val pager = findViewById<ViewPager>(R.id.pager)


        val tabLayout = findViewById<TabLayout>(R.id.tabs)
        tabLayout.setupWithViewPager(pager)


        pager.setAdapter(pagerAdapter)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.getItemId())
        {
            R.id.action_recpie_tap -> {

                if ( CaptionedImagesAdapter.selected_cocktail != -1)
                {
                    val intent = Intent(this,CocktailRecipeActivity::class.java)
                    intent.putExtra(CocktailDetailActivity.EXTRA_COCKTAIL_ID,CaptionedImagesAdapter.selected_cocktail)
                    startActivity(intent)
                    CaptionedImagesAdapter.selected_cocktail = -1
                    CaptionedImagesAdapter.selected = -1
                    CaptionedImagesAdapter.last_selected = -1
                }
                else
                {
                    Toast.makeText(this, getString(R.string.pick_cocktail), Toast.LENGTH_SHORT).show()
                }
                return true
            }
            else ->  return super.onOptionsItemSelected(item)
        }

    }


}
