package br.com.alessi.cbs.parser.network.store

import br.com.alessi.cbs.parser.domain.Round
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RoundsParserService {


    @POST("/classes/Rounds2018")
    fun saveRound(
        @Body
        round: Round

    ): Call<Round>


}
