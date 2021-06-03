package com.example.bartendingbook

import android.content.Context
import android.provider.Settings.Global.getString
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import java.security.AccessController.getContext


class SectionsPagerAdapter(fm: FragmentManager?,context: Context) : FragmentPagerAdapter(fm) {
    var con :Context = context

    
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment? {
        when (position) {
            0 -> {

                return TopFragment()}
            1 -> {

                return Tab1Fragment()
            }
            2 -> return Tab2Fragment()
        }
        return null
    }

    override fun getPageTitle(position: Int): CharSequence? {


        when (position) {
            0 -> return con.resources.getText(R.string.home_tab)
            1 -> return con.resources.getText(R.string.kat1_tab)
            2 -> return con.resources.getText(R.string.kat2_tab)
        }
        return null
    }



}


