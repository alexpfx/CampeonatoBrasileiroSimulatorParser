package br.com.alessi.cbs.parser.network.fetch

import org.junit.Test

class FetchRoundsFromCbfTest {
    private val fetcher: FetchRoundsFromCbf = FetchRoundsFromCbf()

    @Test
    fun fetchRounds() {
        val rounds = fetcher.fetchRounds()
        println(rounds)
    }



}