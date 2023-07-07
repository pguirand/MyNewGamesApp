package com.example.mysecondapi.di

import com.example.mynewgamesapp.data.remote.GameCall
import com.example.mynewgamesapp.data.remote.ApiDetails
import com.example.mynewgamesapp.data.remote.CharCall
import com.example.mynewgamesapp.data.repository.RepoImpl
import com.example.mynewgamesapp.data.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module //state current class is a module
@InstallIn(SingletonComponent::class) // informs the scope of class of items inside
class AppModule {

    @Provides
    fun provideOkHttpInstance(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    @Provides
    fun provideRetrofitInstance(
        client: OkHttpClient
    ) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiDetails.Base_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    @Provides
    fun provideGameAPI(
        retrofit: Retrofit
    ): GameCall {
        return retrofit.create(GameCall::class.java)

    }

    @Provides
    fun provideCharAPI(
        retrofit: Retrofit
    ): CharCall {
        return retrofit.create(CharCall::class.java)

    }

    @Provides
    fun provideRepository(
        gameCall: GameCall,
        charCall: CharCall
    ) : Repository {
        return RepoImpl(gameCall, charCall)
    }

}