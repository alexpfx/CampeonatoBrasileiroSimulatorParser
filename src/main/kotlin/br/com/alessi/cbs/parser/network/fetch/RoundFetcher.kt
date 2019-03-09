package br.com.alessi.cbs.parser.network.fetch

import br.com.alessi.cbs.parser.domain.Round


interface RoundFetcher {
    fun fetchRounds(): List<Round>
}