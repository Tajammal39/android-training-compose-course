package com.example.superheroesapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Hero(@StringRes val name: Int, @StringRes val desc: Int, @DrawableRes val image: Int)