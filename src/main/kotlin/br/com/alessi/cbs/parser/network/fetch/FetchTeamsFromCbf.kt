package br.com.alessi.cbs.parser.network.fetch

import br.com.alessi.cbs.parser.domain.Team
import org.jsoup.Jsoup

class FetchTeamsFromCbf : FetchTeams {

    private val url = "https://www.cbf.com.br/futebol-brasileiro/competicoes/campeonato-brasileiro-serie-a"

    override fun fetchTeams(): List<Team> {
        val teams = mutableListOf<Team>()

        Jsoup.connect(url).get().run {
            val table = select("table").get(0)
            val tbody = table.select("tbody").first()

            val tr = tbody.select("tr.expand-trigger")
            for (t in tr){
                val tds = t.select("td")
                var teamSelect = tds[0].select("span").text()
                teams.add(Team(teamSelect, 0.0, ""))
            }
        }
        return teams
    }
}