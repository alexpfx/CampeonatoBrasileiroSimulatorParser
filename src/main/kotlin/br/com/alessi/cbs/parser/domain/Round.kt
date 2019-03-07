package br.com.alessi.cbs.parser.domain

import br.com.alessi.cbs.parser.domain.MatchInfo

data class Round (val info: String, val turn: Int){
    private val matches: MutableList<MatchInfo> = mutableListOf()

    fun addMatch (matchInfo: MatchInfo){
        matches.add(matchInfo)
    }




}