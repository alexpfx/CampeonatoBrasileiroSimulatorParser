package br.com.alessi.cbs.parser.network.fetch

import br.com.alessi.cbs.parser.domain.Team

interface FetchTeams {
    fun fetchTeams(): List<Team>
}