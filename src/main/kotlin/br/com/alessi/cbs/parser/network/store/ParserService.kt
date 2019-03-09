package br.com.alessi.cbs.parser.network.store

import br.com.alessi.cbs.parser.domain.Round
import br.com.alessi.cbs.parser.domain.Team
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ParserService {


    @POST("/classes/rounds2018")
    fun saveRound(
        @Body
        round: Round

    ): Call<Round>


    @POST("/classes/teams2019")
    fun saveTeam(
        @Body
        team: Team
    ): Call<Team>


}
