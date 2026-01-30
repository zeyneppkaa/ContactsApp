package com.example.contactsapp.di

import com.example.contactsapp.data.datasource.ContactsDataSource
import com.example.contactsapp.data.repo.ContactsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideContactsDataSource() : ContactsDataSource{
        return ContactsDataSource()
    }

    @Provides
    @Singleton
    fun provideContactsRepository(cds : ContactsDataSource) : ContactsRepository {
        return ContactsRepository(cds)
    }
}