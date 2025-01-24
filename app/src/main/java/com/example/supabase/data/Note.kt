package com.example.supabase.data

import kotlinx.serialization.Serializable

@Serializable
data class Note(
    val id: Long? = null, // id может быть null, так как Supabase его сгенерирует
    val title: String,
    val content: String,
    val created_at: String? = null // created_at также может быть null
)
