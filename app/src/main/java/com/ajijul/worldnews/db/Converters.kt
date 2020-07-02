package com.ajijul.worldnews.db

import androidx.room.TypeConverter
import com.ajijul.worldnews.models.Source


class Converters {

    @TypeConverter
    fun fromSource(source: Source): String = source.name

    @TypeConverter
    fun toSource(name: String): Source = Source(name, name)
}