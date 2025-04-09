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
        title = "Stay Focused, Stay Productive",
        description = "Break Big Goals into small steps, use our smart task manager to stay focused and accomplish more everyday."
    )

    data object SecondPage: OnBoardingModel(
        image =  R.drawable.img_2,
        title = "Organize Your Day",
        description = "Stay on Top of your tasks with a clean and simple to-do list. Plan ahead, prioritize, and get things done."
    )

    data object ThirdPage: OnBoardingModel(
        image =  R.drawable.img_3,
        title = "Your Tasks, Your Way",
        description = "Customize your workflow, set reminders, and track progress - all in one place, designed to fit your lifestyle."
    )
}