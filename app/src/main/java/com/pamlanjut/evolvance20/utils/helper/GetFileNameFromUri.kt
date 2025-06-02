package com.pamlanjut.evolvance20.utils.helper

import android.annotation.SuppressLint
import android.net.Uri
import android.provider.OpenableColumns

@SuppressLint("Range")
fun getFileNameFromUri(context: android.content.Context, uri: Uri): String {
    var result = "Unknown"
    if (uri.scheme == "content") {
        val cursor = context.contentResolver.query(uri, null, null, null, null)
        cursor?.use {
            if (it.moveToFirst()) {
                val displayNameIndex = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
                if (displayNameIndex != -1) {
                    result = it.getString(displayNameIndex)
                }
            }
        }
    }
    if (result == "Unknown") {
        result = uri.path?.let { path ->
            val cut = path.lastIndexOf('/')
            if (cut != -1) path.substring(cut + 1) else path
        } ?: "Unknown"
    }
    return result
}