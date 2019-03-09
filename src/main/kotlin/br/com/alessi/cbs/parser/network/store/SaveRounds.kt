package br.com.alessi.cbs.parser.network.store

import br.com.alessi.cbs.parser.domain.Round

class SaveRounds(private val service: ParserService) {

    fun execute(round: Round) {
        service.saveRound(round).execute()
    }

}