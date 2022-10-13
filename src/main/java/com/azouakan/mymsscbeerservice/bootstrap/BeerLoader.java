package com.azouakan.mymsscbeerservice.bootstrap;

import com.azouakan.mymsscbeerservice.domain.Beer;
import com.azouakan.mymsscbeerservice.repositories.BeerRepository;
import com.azouakan.mymsscbeerservice.web.model.BeerStyleEnum;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {

    private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count() == 0) {
            beerRepository.save(Beer.builder()
                    .beerName("Mango Bobs")
                    .beerStyle("IPA")
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .price(new BigDecimal("12.95"))
                    .upc(337010000001L)
                    .build()
            );

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy Cat")
                    .beerStyle("PALE_ALE")
                    .minOnHand(12)
                    .quantityToBrew(200)
                    .price(new BigDecimal("11.95"))
                    .upc(337010000002L)
                    .build()
            );
        }
    }
}
