package br.com.alessi.cbs.parser.network.fetchdata

import br.com.alessi.cbs.parser.domain.MatchInfo
import br.com.alessi.cbs.parser.domain.Round
import br.com.alessi.cbs.parser.domain.Team
import org.jsoup.Jsoup
import org.jsoup.nodes.Element

class FetchRoundsFromCbf : RoundFetcher {
    private val divisor = 10
    private val games = 10
    private val turn = 190

    private val url = "https://www.cbf.com.br/futebol-brasileiro/competicoes/campeonato-brasileiro-serie-a/2018/"

    private fun checkNotNull(vararg value: Element) {
        requireNotNull(value)
    }

    override fun fetchRounds(): List<Round> {
        val rounds = mutableListOf<Round>()

        for (i in 1..games) {
            var thisRound: Round = createAndAddRound(i, rounds)

            Jsoup.connect(url.plus(i)).get().run {
                val homeTeamElement = select("div.time-left > h3.time-nome").first()
                val awayTeamElement = select("div.time-right > h3.time-nome").first()
                val date = select("div.col-sm-8 > span.text-2")[1]
                val time = select("div.col-sm-8 > span.text-2")[2]
                val info = select("div.col-sm-3 > span.color-white")[0]

                checkNotNull(homeTeamElement, awayTeamElement, date, time, info)

                val homeTeam = Team(homeTeamElement.text(), 70.0, "")
                val awayTeam = Team(awayTeamElement.text(), 70.0, "")

                val matchInfo = MatchInfo(homeTeam, awayTeam, date.text(), time.text(), info.text())

                thisRound.addMatch(matchInfo)
                if (i.rem(divisor) == 0 && i < games) {
                    thisRound = createAndAddRound(i, rounds)
                }
            }

        }

        return rounds
    }

    private fun createAndAddRound(i: Int, rounds: MutableList<Round>): Round {
        val round = Round("Round ${i.div(divisor) + 1}", i.div(turn) + 1)
        rounds.add(round)
        return round
    }

}