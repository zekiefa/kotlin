package br.com.cvc.evaluation.service

import br.com.cvc.evaluation.broker.BrokerService
import br.com.cvc.evaluation.broker.dto.BrokerHotel
import br.com.cvc.evaluation.broker.dto.BrokerHotelRoom
import br.com.cvc.evaluation.domain.Hotel
import br.com.cvc.evaluation.domain.Room
import br.com.cvc.evaluation.service.BookingConstants.ONE_DAY
import br.com.cvc.evaluation.service.BookingConstants.ONE_PAX
import br.com.cvc.evaluation.service.mapper.HotelMapper
import br.com.cvc.evaluation.service.mapper.RoomMapper
import org.eclipse.microprofile.rest.client.inject.RestClient
import java.math.BigDecimal
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import javax.enterprise.context.ApplicationScoped
import javax.inject.Inject

@ApplicationScoped
class BookingService @Inject constructor(
    @RestClient val brokerService: BrokerService,
    val feeService: FeeService,
    val hotelMapper: HotelMapper,
    val roomMapper: RoomMapper) {

    private fun calculateTotaPrice(paxPrice: BigDecimal, days: Long): BigDecimal {
        val fee = this.feeService.calculateFee(paxPrice, days)

        return paxPrice.add(fee).multiply(BigDecimal.valueOf(days))
    }

    private fun calculatePeriod(checkin: LocalDate, checkout: LocalDate):Long {
        return checkin.until(checkout, ChronoUnit.DAYS)
    }

    private fun calculateTotalPrice(brokerHotelRoom: BrokerHotelRoom, days: Long, adults: Int, child: Int): Room {
        val room = this.roomMapper.toDomain(brokerHotelRoom)
        var totalPrice = BigDecimal.ZERO

        if (adults > 0) {
            room.priceDetail.pricePerDayAdult = this.calculateTotaPrice(brokerHotelRoom.price.adult, ONE_DAY)
            totalPrice = totalPrice.add(room.priceDetail.pricePerDayAdult.multiply(BigDecimal.valueOf(days)))
        }

        if (child > 0) {
            room.priceDetail.pricePerDayChild = this.calculateTotaPrice(brokerHotelRoom.price.child, ONE_DAY)
            totalPrice = totalPrice.add(room.priceDetail.pricePerDayChild.multiply(BigDecimal.valueOf(days)))
        }

        room.totalPrice = totalPrice

        return room
    }

    private fun calculateBooking(brokerHotel: BrokerHotel, days: Long, adults: Int, child: Int): Hotel {
        val hotel = this.hotelMapper.toDomain(brokerHotel)
        hotel.rooms = brokerHotel.rooms.map { this.calculateTotalPrice(it, days, adults, child) }

        return hotel
    }

    fun getHotelDetails(codeHotel:Int): Hotel? {
        var hotel: Hotel?
        val details = this.brokerService.getHotelDetails(codeHotel)

        details.let { hotel = this.calculateBooking(it, ONE_DAY, ONE_PAX, ONE_PAX) }

        return hotel
    }

    fun findHotels(cityCode: Int, checkin: LocalDate, checkout: LocalDate, adults: Int, child: Int): List<Hotel> {
        val hotels = this.brokerService.findHotelsByCity(cityCode)
        val period = this.calculatePeriod(checkin, checkout)

        return hotels.map { this.calculateBooking(it, period, adults, child) }
    }


}