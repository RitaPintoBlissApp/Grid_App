package com.example.grid_app.model

import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes

data class course(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int,
    @IntegerRes val numberResourceId: Int,
)
