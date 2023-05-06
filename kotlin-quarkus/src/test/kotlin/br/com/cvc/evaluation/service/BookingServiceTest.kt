package br.com.cvc.evaluation.service

import br.com.cvc.evaluation.broker.BrokerService
import br.com.cvc.evaluation.service.mapper.HotelMapper
import br.com.cvc.evaluation.service.mapper.RoomMapper
import fixture.Fixtures
import io.mockk.every
import io.mockk.mockk
import io.quarkus.test.junit.QuarkusTest
import org.mapstruct.factory.Mappers
import org.mockito.ArgumentMatchers.anyInt
import kotlin.test.Test
import kotlin.test.assertNotNull

@QuarkusTest
class BookingServiceTest {
    private val brokerService: BrokerService = mockk()
    private val feeService: FeeService = mockk()
    private val hotelMapper: HotelMapper = Mappers.getMapper(HotelMapper::class.java)
    private val roomMapper: RoomMapper = Mappers.getMapper(RoomMapper::class.java)

    private val bookingService: BookingService = BookingService(brokerService,
        feeService, hotelMapper, roomMapper)

    private val fixtures = Fixtures()

    @Test
    fun `Getting hotel details`() {
        // Arranges
        val brokerHotel = fixtures.createValidBroketHotel()
        every { brokerService.getHotelDetails(1) } returns brokerHotel

        // Act
        var hotelDetails = bookingService.getHotelDetails(1)

        // Assert
        assertNotNull(hotelDetails)


    }
}