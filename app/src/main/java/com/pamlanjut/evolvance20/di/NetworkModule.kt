package com.pamlanjut.evolvance20.di

import android.content.Context
import com.pamlanjut.evolvance20.R
import com.pamlanjut.evolvance20.data.remote.api.BootcampApi
import com.pamlanjut.evolvance20.data.remote.api.CheckoutApi
import com.pamlanjut.evolvance20.data.remote.api.MentoringApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        @ApplicationContext context: Context,
        client: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(context.getString(R.string.base_url))
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideBootcampApi(retrofit: Retrofit): BootcampApi {
        return retrofit.create(BootcampApi::class.java)
    }

    @Provides
    @Singleton
    fun provideCheckoutApi(retrofit: Retrofit): CheckoutApi {
        return retrofit.create(CheckoutApi::class.java)
    }

    @Provides
    @Singleton
    fun provideMentoringApi(retrofit: Retrofit): MentoringApi {
        return retrofit.create(MentoringApi::class.java)
    }
}
