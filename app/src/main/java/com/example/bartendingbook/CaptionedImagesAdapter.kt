package com.example.bartendingbook

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.support.v4.content.ContextCompat
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class CaptionedImagesAdapter(
    private val cocktails: MutableList<Cocktail>
): RecyclerView.Adapter<CaptionedImagesAdapter.ViewHolder>() {

    private lateinit var listener: Listener


    companion object{
        var selected = -1;
        var last_selected =-1
        var selected2 = -1;
        var last_selected2 =-1
        var selected_cocktail = -1
    }


    interface Listener {
        fun onClick(position : Int)
    }

    fun setListener(listener : Listener){
        this.listener = listener
    }

    inner class ViewHolder(var cardView: CardView):RecyclerView.ViewHolder(cardView)
        {


    }

    override fun getItemCount(): Int {
        return cocktails.size
    }

    //CaptionedImagesAdapter.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CaptionedImagesAdapter.ViewHolder {
        val cv : CardView =  LayoutInflater.from(parent.context).inflate(R.layout.card_captioned_image, parent, false) as CardView
        return ViewHolder(cv)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val cardView : CardView = holder.cardView
        val imageView : ImageView= cardView.findViewById(R.id.info_image) as ImageView
        val drawable : Drawable? = ContextCompat.getDrawable(cardView.getContext(),cocktails[position].imageResourceId)
        imageView.setImageDrawable(drawable)
        imageView.setContentDescription(cocktails[position].name)
        val textView : TextView = cardView.findViewById(R.id.info_text) as TextView
        textView.setText(cocktails[position].name)
        textView.setTextColor(Color.parseColor("#808080"))
        imageView.colorFilter = null

        cardView.setOnClickListener{
           onClick2(it,position)
        }

        cardView.setOnLongClickListener {
            onLongClick2(it, position)

        }


    }

    private fun onLongClick2(v :View,position : Int): Boolean{


        val textView : TextView = v.findViewById(R.id.info_text) as TextView
        val imageView : ImageView= v.findViewById(R.id.info_image) as ImageView

        if (cocktails[0].id==0)
        {
            last_selected = selected
            selected = position
            if (selected != last_selected){
                selected_cocktail = cocktails[position].id
                notifyItemChanged(last_selected)
                imageView.setColorFilter(R.color.transparent_blue)
                textView.setTextColor(Color.parseColor("#234bfc"))
            }
            else if(imageView.colorFilter!=null){
                selected_cocktail = -1
                notifyItemChanged(last_selected)
            }
            else{
                selected_cocktail = cocktails[position].id
                imageView.setColorFilter(R.color.transparent_blue)
                textView.setTextColor(Color.parseColor("#234bfc"))
            }
        }
        else
        {
            last_selected2 = selected2
            selected2 = position
            if (selected2 != last_selected2){
                selected_cocktail = cocktails[position].id
                notifyItemChanged(last_selected2)
                imageView.setColorFilter(R.color.transparent_blue)
                textView.setTextColor(Color.parseColor("#234bfc"))
            }
            else if(imageView.colorFilter!=null){
                selected_cocktail = -1
                notifyItemChanged(last_selected2)
            }
            else{
                selected_cocktail = cocktails[position].id
                imageView.setColorFilter(R.color.transparent_blue)
                textView.setTextColor(Color.parseColor("#234bfc"))
            }
        }


        return true
    }

    fun onClick2(v :View,position : Int){
        if(listener!=null){
            listener.onClick(position)
        }
    }




}