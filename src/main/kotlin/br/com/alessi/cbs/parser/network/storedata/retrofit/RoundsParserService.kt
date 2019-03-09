package br.com.alessi.cbs.parser.network.storedata.retrofit

import br.com.alessi.cbs.parser.domain.Round
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface RoundsParserService {


    @POST("/classes/Rounds2018")
    fun storeRound(
        @Body
        round: Round

    ): Call<Round>


}
