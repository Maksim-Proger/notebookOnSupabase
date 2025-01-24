package com.example.supabase.data

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

object Supabase {
    const val SUPABASE_URL = "https://zfjldzjxtlwlaiklcfkt.supabase.co"
    const val SUPABASE_KEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Inpmamxkemp4dGx3bGFpa2xjZmt0Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3Mzc3Mjg1MDAsImV4cCI6MjA1MzMwNDUwMH0.3ClNL-Lg7qso6gqJ331HIJ7YxjRD3a1t79WkU2Jz8R0"

    val client: SupabaseClient = createSupabaseClient(
        supabaseUrl = SUPABASE_URL,
        supabaseKey = SUPABASE_KEY
    ) {
        install(Postgrest)
    }
}