package br.com.alessi.cbs.parser.network.storedata.retrofit

import br.com.alessi.cbs.parser.domain.Round
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface RoundsParserService {

    @Headers(
        "Content-Type: application/json"
    )


    @POST("/classes/Rounds")
    fun storeRound(
        @Header("X-Parse-Application-Id")
        appId: String,
        @Header("X-Parse-REST-API-Key")
        restApiKey: String,
        @Body
        round: Round

    ): Call<Round>


}
