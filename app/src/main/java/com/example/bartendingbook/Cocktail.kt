package com.example.bartendingbook

data class Cocktail(
    var id: Int = -1,
    var name : String = "",
    var imageResourceId : Int = 0,
    var description : String = "",
    var recipe : String = "",
    var ingredients : String = ""
)