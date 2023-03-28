package com.example.sharedpreferenceexercise

import android.content.Context

internal class UserPreference(context: Context) {
    companion object {
        private const val USER_PREF_NAME = "user_pref"
        private const val NAME = "name"
        private const val EMAIL = "email"
        private const val AGE = "age"
        private const val PHONE_NUMBER = "phone"
        private const val LOVE_MU = "isLove"
    }

    private val sharedPreferences = context.getSharedPreferences(USER_PREF_NAME, Context.MODE_PRIVATE)

    fun setUser(value: UserModel) {
        val editor = sharedPreferences.edit()
        editor.putString(NAME, value.name)
        editor.putString(EMAIL, value.email)
        editor.putInt(AGE, value.age)
        editor.putString(PHONE_NUMBER, value.phoneNumber)
        editor.putBoolean(LOVE_MU, value.isLove)
        editor.apply()
    }

    fun getUser(): UserModel {
        val model = UserModel()
        model.name = sharedPreferences.getString(NAME, "")
        model.email = sharedPreferences.getString(EMAIL, "")
        model.age = sharedPreferences.getInt(AGE, 0)
        model.phoneNumber = sharedPreferences.getString(PHONE_NUMBER, "")
        model.isLove = sharedPreferences.getBoolean(LOVE_MU, false)

        return model
    }
}