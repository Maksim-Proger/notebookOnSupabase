package com.example.supabase.di

import com.example.supabase.data.repository.NoteRepositoryImpl
import com.example.supabase.data.source.SupabaseDataSource
import com.example.supabase.domain.repository.NoteRepository
import com.example.supabase.domain.usecase.AddNoteUseCase
import com.example.supabase.domain.usecase.DeleteNoteUseCase
import com.example.supabase.domain.usecase.GetNotesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSupabaseClient(): SupabaseClient {
        return createSupabaseClient(
            supabaseUrl = "https://zfjldzjxtlwlaiklcfkt.supabase.co",
            supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6Inpmamxkemp4dGx3bGFpa2xjZmt0Iiwicm9sZSI6ImFub24iLCJpYXQiOjE3Mzc3Mjg1MDAsImV4cCI6MjA1MzMwNDUwMH0.3ClNL-Lg7qso6gqJ331HIJ7YxjRD3a1t79WkU2Jz8R0"
        ) {
            install(Postgrest)
        }
    }

    @Provides
    @Singleton
    fun provideSupabaseDataSource(supabaseClient: SupabaseClient): SupabaseDataSource {
        return SupabaseDataSource(supabaseClient)
    }

    @Provides
    @Singleton
    fun provideNoteRepository(dataSource: SupabaseDataSource): NoteRepository {
        return NoteRepositoryImpl(dataSource)
    }

    @Provides
    @Singleton
    fun provideGetNotesUseCase(repository: NoteRepository): GetNotesUseCase {
        return GetNotesUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideAddNoteUseCase(repository: NoteRepository): AddNoteUseCase {
        return AddNoteUseCase(repository)
    }

    @Provides
    @Singleton
    fun provideDeleteNoteUseCase(repository: NoteRepository): DeleteNoteUseCase {
        return DeleteNoteUseCase(repository)
    }
}