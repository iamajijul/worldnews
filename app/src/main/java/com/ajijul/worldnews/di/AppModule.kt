package com.ajijul.worldnews.di

import android.content.Context
import androidx.room.Room
import com.ajijul.worldnews.db.ArticleDao
import com.ajijul.worldnews.db.ArticleDatabase
import com.ajijul.worldnews.helper.Constant.DATABASE_NAME
import com.ajijul.worldnews.network.NewsApi
import com.ajijul.worldnews.ui.NewsRepository
import com.ajijul.worldnews.ui.NewsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideArticleDatabase(@ApplicationContext context: Context): ArticleDatabase =
        Room.databaseBuilder(context, ArticleDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()// if I change the database version, old version will
            // remove from device and a new version will create.
            .build()


    @Singleton
    @Provides
    fun provideArticleDao(db: ArticleDatabase) = db.getArticleDao()

    @Singleton
    @Provides
    fun provideNewsRepository(api: NewsApi, dao: ArticleDao): NewsRepository =
        NewsRepositoryImpl(dao = dao, api = api)

}