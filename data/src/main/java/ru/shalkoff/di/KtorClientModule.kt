package ru.shalkoff.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import ru.shalkoff.Urls
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object KtorClientModule {

    @Singleton
    @Provides
    @Schedule
    fun provideKtorHttpClient(): HttpClient {
        return HttpClient(Android) {
            install(Logging) {
                level = LogLevel.ALL
            }
            install(DefaultRequest) {
                url(Urls.BASE_API_URL)
            }
            install(ContentNegotiation) {
                json(Json {
                    // игнорируем ошибку, если в response мы обрабатываем не все поля
                    ignoreUnknownKeys = true
                })
            }
        }
    }

    @Singleton
    @Provides
    @Cats
    fun provideCatsKtorHttpClient(): HttpClient {
        return HttpClient(Android) {
            install(Logging) {
                level = LogLevel.ALL
            }
            install(DefaultRequest) {
                url(Urls.BASE_CAT_API_URL)
                header(HttpHeaders.ContentType, ContentType.Application.Json)
                header("x-api-key", Urls.CAT_API_KEY)
            }
            install(ContentNegotiation) {
                json(Json {
                    // игнорируем ошибку, если в response мы обрабатываем не все поля
                    ignoreUnknownKeys = true
                })
            }
        }
    }
}