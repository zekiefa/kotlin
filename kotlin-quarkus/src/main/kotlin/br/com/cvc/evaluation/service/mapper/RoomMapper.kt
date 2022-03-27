package br.com.cvc.evaluation.service.mapper

import br.com.cvc.evaluation.broker.dto.BrokerHotelRoom
import br.com.cvc.evaluation.domain.Room
import org.mapstruct.Mapper

@Mapper
interface RoomMapper {
    fun toDomain(brokerHotelRoom: BrokerHotelRoom): Room
}