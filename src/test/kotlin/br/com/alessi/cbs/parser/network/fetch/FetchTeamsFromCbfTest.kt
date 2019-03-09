package br.com.alessi.cbs.parser.network.fetch

import org.junit.Test

import org.junit.Assert.*

class FetchTeamsFromCbfTest {

    private val fetcher: FetchTeamsFromCbf = FetchTeamsFromCbf()

    @Test
    fun fetchTeams() {

        fetcher.fetchTeams()
    }
}