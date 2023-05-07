package br.com.cvc.evaluation.service

import br.com.cvc.evaluation.broker.BrokerService
import br.com.cvc.evaluation.service.mapper.HotelMapper
import br.com.cvc.evaluation.service.mapper.HotelMapperImpl
import br.com.cvc.evaluation.service.mapper.RoomMapper
import fixture.Fixtures
import io.mockk.every
import io.mockk.mockk
import io.quarkus.test.junit.QuarkusTest
import org.mapstruct.factory.Mappers
import java.math.BigDecimal
import kotlin.test.Test
import kotlin.test.assertNotNull

@QuarkusTest
class BookingServiceTest {
    private val brokerService: BrokerService = mockk()
    private val feeService: FeeService = mockk()
    private val roomMapper: RoomMapper = Mappers.getMapper(RoomMapper::class.java)
    private val hotelMapper: HotelMapper = HotelMapperImpl(roomMapper)
    private val bookingService: BookingService = BookingService(brokerService,
        feeService, hotelMapper, roomMapper)

    private val fixtures = Fixtures()

    @Test
    fun `Getting hotel details`() {
        // Arranges
        val brokerHotel = fixtures.createValidBroketHotel()
        every { brokerService.getHotelDetails(1) } returns brokerHotel
        every { feeService.calculateFee(any(), any()) } returns BigDecimal.valueOf(15)

        // Act
        val hotelDetails = bookingService.getHotelDetails(1)

        // Assert
        assertNotNull(hotelDetails)


    }
}