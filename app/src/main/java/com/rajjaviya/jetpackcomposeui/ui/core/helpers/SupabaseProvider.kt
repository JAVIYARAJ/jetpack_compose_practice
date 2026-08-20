package com.rajjaviya.jetpackcomposeui.ui.core.helpers

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

object SupabaseProvider {

    val client: SupabaseClient by lazy {

        createSupabaseClient(
            supabaseUrl = "",
            supabaseKey = ""
        ) {
            install(Auth)
            install(Postgrest)
        }
    }
}