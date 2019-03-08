package br.com.alessi.cbs.parser.network.storedata.retrofit

import br.com.alessi.cbs.parser.domain.Round
import org.junit.Test

import org.junit.Assert.*

class StoreRoundTest {
    var storeRound:StoreRound = StoreRound()

    @Test
    fun store() {
        storeRound.store(Round("round 1", 1))

    }
}