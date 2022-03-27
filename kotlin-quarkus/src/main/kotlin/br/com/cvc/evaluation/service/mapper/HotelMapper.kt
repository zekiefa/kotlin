package br.com.cvc.evaluation.service.mapper

import br.com.cvc.evaluation.broker.dto.BrokerHotel
import br.com.cvc.evaluation.domain.Hotel
import org.mapstruct.Mapper

@Mapper
interface HotelMapper {
    fun toDomain(brokerHotel: BrokerHotel): Hotel
}