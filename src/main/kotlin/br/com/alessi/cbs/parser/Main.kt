package br.com.alessi.cbs.parser

import br.com.alessi.cbs.parser.network.fetch.FetchRoundsFromCbf
import br.com.alessi.cbs.parser.network.fetch.FetchTeams
import br.com.alessi.cbs.parser.network.fetch.FetchTeamsFromCbf
import br.com.alessi.cbs.parser.network.fetch.FetchRounds
import br.com.alessi.cbs.parser.network.store.SaveRounds
import br.com.alessi.cbs.parser.network.store.ParserService
import br.com.alessi.cbs.parser.network.store.SaveTeams
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private lateinit var fetchRounds: FetchRounds
private lateinit var fetchTeams: FetchTeams
private lateinit var saveRounds: SaveRounds
private lateinit var saveTeams: SaveTeams


fun main() {
    initializeObjects()
    fetchAndSaveTeams()
    fetchAndSaveRounds()
}

fun fetchAndSaveTeams() {
    val teams = fetchTeams.fetchTeams()
    for (team in teams) {
        saveTeams.execute(team)
    }
}

fun fetchAndSaveRounds() {
    val rounds = fetchRounds.fetchRounds()
    for (round in rounds) {
        saveRounds.execute(round)
    }
}


fun initializeObjects() {
    fetchTeams = FetchTeamsFromCbf()
    fetchRounds = FetchRoundsFromCbf()
    saveRounds = SaveRounds(getService())
    saveTeams = SaveTeams(getService())
}

fun getService(): ParserService {

    val retrofit = Retrofit
        .Builder()
        .baseUrl("https://parseapi.back4app.com")
        .addConverterFactory(GsonConverterFactory.create())
        .client(createClient()).build()

    return retrofit.create(ParserService::class.java)
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
