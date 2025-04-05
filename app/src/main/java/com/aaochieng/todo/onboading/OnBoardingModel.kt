package com.aaochieng.todo.onboading

import androidx.annotation.DrawableRes
import com.aaochieng.todo.R

sealed class OnBoardingModel(
    @DrawableRes val image: Int,
    val title: String,
    val description: String,

) {

    data object FirstPage: OnBoardingModel(
        image =  R.drawable.img_1,
        title = "lorem ipsum",
        description = "lorem ipsum"
    )

    data object SecondPage: OnBoardingModel(
        image =  R.drawable.img_2,
        title = "lorem ipsum",
        description = "lorem ipsum"
    )

    data object ThirdPage: OnBoardingModel(
        image =  R.drawable.img_3,
        title = "lorem ipsum",
        description = "lorem ipsum"
    )
}