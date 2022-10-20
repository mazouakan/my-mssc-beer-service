package com.azouakan.mymsscbeerservice.web.mappers;

import com.azouakan.mymsscbeerservice.domain.Beer;
import com.azouakan.mymsscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    Beer beerDtoToBeer(BeerDto beerDto);
    BeerDto beerToBeerDto(Beer beer);
}
