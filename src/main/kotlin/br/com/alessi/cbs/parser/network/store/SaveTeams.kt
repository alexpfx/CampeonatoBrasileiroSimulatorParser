package br.com.alessi.cbs.parser.network.store

import br.com.alessi.cbs.parser.domain.Team

class SaveTeams (private val service: ParserService) {

    fun execute(team: Team){
        service.saveTeam(team)
    }

}