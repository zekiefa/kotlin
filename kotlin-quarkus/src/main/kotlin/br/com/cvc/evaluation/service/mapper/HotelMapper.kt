package br.com.cvc.evaluation.service.mapper

import br.com.cvc.evaluation.broker.dto.BrokerHotel
import br.com.cvc.evaluation.domain.Hotel
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper
import org.mapstruct.MappingConstants

@Mapper(uses = [RoomMapper::class],
    componentModel = MappingConstants.ComponentModel.JAKARTA_CDI,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR)
interface HotelMapper {
    fun toDomain(brokerHotel: BrokerHotel): Hotel

}