package com.example.creditgo.di

import android.app.Application
import androidx.room.Room
import com.example.creditgo.BuildConfig
import com.example.creditgo.repository.RepoImpl
import com.example.creditgo.api.ApiService
import com.example.creditgo.repository.MainRepository
import com.example.creditgo.utils.Constants
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import xyz.teamgravity.offlinecaching.arch.database.UserDatabase
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule{

    @Provides
    fun provideBaseUrl() = Constants.BASE_URL

    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG){
        val loggingInterceptor =HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
            .build()
    }else{
        OkHttpClient
            .Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, BASE_URL:String): Retrofit =
        Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)




    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO



    @Singleton
    @Provides
    fun provideMainRepository(api: ApiService, db: UserDatabase): MainRepository = RepoImpl(api, db)

    @Singleton
    @Provides
    fun provideDatabase(app: Application) =
        Room.databaseBuilder(app, UserDatabase::class.java, Constants.DATABASE_NAME)
            .addMigrations()
            .build()


    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

}