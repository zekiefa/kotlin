package fixture

import br.com.cvc.evaluation.broker.dto.BrokerHotel
import br.com.cvc.evaluation.broker.dto.BrokerHotelRoom
import br.com.cvc.evaluation.broker.dto.Price
import br.com.cvc.evaluation.domain.Hotel
import net.datenstrudel.kotlin_fixture_magic.FixtureFactory


class Fixtures {
    var fixture = FixtureFactory.build { randomStringLength = 20 }

    fun createValidHotel(): Hotel {
        return fixture.createInstance()
    }

    fun createValidBroketHotel(): BrokerHotel {
        return fixture.createInstance()
    }
}