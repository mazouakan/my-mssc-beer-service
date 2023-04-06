package com.azouakan.mymsscbeerservice.services;

import com.azouakan.mymsscbeerservice.domain.Beer;
import com.azouakan.mymsscbeerservice.repositories.BeerRepository;
import com.azouakan.mymsscbeerservice.web.controller.NotFoundException;
import com.azouakan.mymsscbeerservice.web.mappers.BeerMapper;
import com.azouakan.mymsscbeerservice.web.model.BeerDto;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@RequiredArgsConstructor
public class BeerServiceImpl implements BeerService {

    private final BeerRepository beerRepository;
    private final BeerMapper beerMapper;
    @Override
    public BeerDto getBeerById(UUID beerId) {
        return beerMapper.beerToBeerDto(beerRepository.findById(beerId).orElseThrow(NotFoundException::new));
    }

    @Override
    public BeerDto saveNewBeer(BeerDto beerDto) {

        return beerMapper.beerToBeerDto(beerRepository.save(beerMapper.beerDtoToBeer(beerDto)));
    }

    @Override
    public BeerDto updateBeerById(UUID beerId, BeerDto beerDto) {

        Beer beer = beerRepository.findById(beerId).orElseThrow(NotFoundException::new);
        beer.setBeerName(beerDto.getBeerName());
        beer.setBeerStyle(beerDto.getBeerStyle().name());
        beer.setPrice(beerDto.getPrice());
        beer.setUpc(beerDto.getUpc());
        return beerMapper.beerToBeerDto(beerRepository.save(beer));
    }
}
