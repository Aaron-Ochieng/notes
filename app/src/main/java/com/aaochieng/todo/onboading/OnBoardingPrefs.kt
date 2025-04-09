package com.aaochieng.todo.onboading

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

object OnBoardingPrefs {
    private const val PREFS_NAME = "MyPrefs"
    private const val ONBOARDING_COMPLETED_KEY = "onBoardingCompleted"

    fun isOnBoardingCompleted(context: Context): Boolean {
        val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return prefs.getBoolean(ONBOARDING_COMPLETED_KEY, false)
    }

    fun setOnBoardingCompleted(context: Context) {
        val prefs: SharedPreferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        prefs.edit() {
            putBoolean(ONBOARDING_COMPLETED_KEY, true)
        }
    }
}