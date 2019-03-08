package br.com.alessi.cbs.parser.network.storedata.retrofit

import br.com.alessi.cbs.parser.domain.Round
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class StoreRound {

    fun store(round: Round){
        var retrofit = Retrofit.Builder().baseUrl("https://parseapi.back4app.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        var service = retrofit.create(RoundsParserService::class.java)


        var response = service.storeRound(
            "",
            "",
            round
        )
            .execute()


        println(response)


    }

}