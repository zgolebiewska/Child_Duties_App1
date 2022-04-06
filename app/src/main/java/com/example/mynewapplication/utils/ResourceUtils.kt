package com.example.mynewapplication.utils

import android.content.Context
import java.security.AccessControlContext

object ResourceUtils {

    fun getResourceDrawableId(drawableName: String?, context: Context): Int{
        val id = context.resources.getIdentifier(drawableName,"drawable", context.packageName)
        return id
    }
}