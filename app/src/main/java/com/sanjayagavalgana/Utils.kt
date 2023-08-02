package com.sanjayagavalgana

import android.content.Context
import android.content.SharedPreferences

object Utils {
    // shared preference key
    private const val SHARED_PREF_KEY = "com.sanjayagavalgana.SHARED_PREF_KEY"

    // method to get the shared preference key
    fun getSharedPrefKey(): String {
        return SHARED_PREF_KEY
    }

    /**
     * method to save the shared preference choice
     * @param context
     * @param key
     * @param value
     * @return
     */
    fun saveSharedPrefString(context: Context, key: String, value: String) {
        val mSharedPreferences =
            context.getSharedPreferences(SHARED_PREF_KEY, Context.MODE_PRIVATE)
        val editor = mSharedPreferences.edit()
        editor.putString(key, value)
        editor.apply()
    }

    /**
     * method to save the shared preference choice
     * @param context
     * @param key
     * @param value
     * @return
     */
    fun saveSharedPrefInt(context: Context, key: String, value: Int) {
        val mSharedPreferences =
            context.getSharedPreferences(SHARED_PREF_KEY, Context.MODE_PRIVATE)
        val editor = mSharedPreferences.edit()
        editor.putInt(key, value)
        editor.apply()
    }

    /**
     * method to save the shared preference choice
     * @param context
     * @param key
     * @param value
     * @return
     */
    fun saveSharedPrefBool(context: Context, key: String, value: Boolean) {
        val mSharedPreferences =
            context.getSharedPreferences(SHARED_PREF_KEY, Context.MODE_PRIVATE)
        val editor = mSharedPreferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    /**
     * method to get the shared preference choice
     * @param context
     * @param key
     * @return
     */
    fun getSharedPrefString(context: Context, key: String): String? {
        val mSharedPreferences =
            context.getSharedPreferences(SHARED_PREF_KEY, Context.MODE_PRIVATE)
        return mSharedPreferences.getString(key, "")
    }

    /**
     * method to get the shared preference choice
     * @param context
     * @param key
     * @return
     */
    fun getSharedPrefInt(context: Context, key: String): Int? {
        val mSharedPreferences =
            context.getSharedPreferences(SHARED_PREF_KEY, Context.MODE_PRIVATE)
        return mSharedPreferences.getInt(key, -1)
    }

    /**
     * method to get the shared preference choice
     * @param context
     * @param key
     * @return
     */
    fun getSharedPrefBool(context: Context, key: String): Boolean? {
        val mSharedPreferences =
            context.getSharedPreferences(SHARED_PREF_KEY, Context.MODE_PRIVATE)
        return mSharedPreferences.getBoolean(key, false)
    }
}