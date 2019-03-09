package br.com.alessi.cbs.parser

import br.com.alessi.cbs.parser.network.fetch.FetchRoundsFromCbf
import br.com.alessi.cbs.parser.network.fetch.RoundFetcher
import br.com.alessi.cbs.parser.network.store.SaveRounds
import br.com.alessi.cbs.parser.network.store.RoundsParserService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private lateinit var fetcher: RoundFetcher
private lateinit var saveRounds: SaveRounds



fun main() {
    initializeObjects()

}

fun initializeObjects() {
    fetcher = FetchRoundsFromCbf()
    saveRounds = SaveRounds(getService())

}

fun getService(): RoundsParserService {

    val retrofit = Retrofit
        .Builder()
        .baseUrl("https://parseapi.back4app.com")
        .addConverterFactory(GsonConverterFactory.create())
        .client(createClient()).build()

    return retrofit.create(RoundsParserService::class.java)
}

fun createClient(): OkHttpClient {
    return OkHttpClient.Builder().addInterceptor(createHeadInterceptor()).build()
}

fun createHeadInterceptor(): Interceptor {
    return HeaderInterceptor()
}

class HeaderInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response =
        chain.run {
            val credentials = CredentialsUtils.readCredentials()
            proceed(
                request().newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("X-Parse-Application-Id", credentials.back4appClientKey)
                    .addHeader("X-Parse-REST-API-Key", credentials.back4appRestApiKey)
                    .build()
            )
        }
}
