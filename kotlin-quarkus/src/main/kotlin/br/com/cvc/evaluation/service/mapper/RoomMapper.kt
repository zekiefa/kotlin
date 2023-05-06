package br.com.cvc.evaluation.service.mapper

import br.com.cvc.evaluation.broker.dto.BrokerHotelRoom
import br.com.cvc.evaluation.domain.Room
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper
interface RoomMapper {
    @Mapping(target = "totalPrice", ignore = true)
    @Mapping(target = "priceDetail", ignore = true)
    fun toDomain(brokerHotelRoom: BrokerHotelRoom): Room
}