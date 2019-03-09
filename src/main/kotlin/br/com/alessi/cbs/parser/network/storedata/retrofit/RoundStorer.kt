package br.com.alessi.cbs.parser.network.storedata.retrofit

import br.com.alessi.cbs.parser.domain.Round
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RoundStorer(private val service: RoundsParserService) {

    fun store(round: Round) {
        service.storeRound(round).execute()
    }

}