package br.com.alessi.cbs.parser.network.fetchdata

import org.junit.Test

class FetchRoundsFromCbfTest {
    private val fetcher: FetchRoundsFromCbf = FetchRoundsFromCbf()

    @Test
    fun fetchRounds() {
        val rounds = fetcher.fetchRounds()
        println(rounds)
    }



}