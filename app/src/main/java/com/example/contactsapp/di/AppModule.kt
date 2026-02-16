package com.example.contactsapp.di

import com.example.contactsapp.data.datasource.ContactsDataSource
import com.example.contactsapp.data.repo.ContactsRepository
import com.example.contactsapp.retrofit.ApiUtils
import com.example.contactsapp.retrofit.ContactsDao
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
    fun provideContactsDataSource(cdao: ContactsDao) : ContactsDataSource{
        return ContactsDataSource(cdao)
    }

    @Provides
    @Singleton
    fun provideContactsRepository(cds : ContactsDataSource) : ContactsRepository {
        return ContactsRepository(cds)
    }

    @Provides
    @Singleton
    fun provideContactsDao() : ContactsDao {
        return ApiUtils.getContactsDao()
    }
}