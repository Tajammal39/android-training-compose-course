package com.example.topic

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(@StringRes val name: Int, val course: Int, @DrawableRes val imageResource: Int)
