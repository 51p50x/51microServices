package com.p50x.animecharacter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CharacterService {

    private final CharacterRepository characterRepository;

    private final RestTemplate restTemplate;

    public List<Character> getCharacters(){
        return characterRepository.findAll();
    }

    public void addCharacter(CharacterRequest characterRequest){
        Character character = Character.builder()
                .name(characterRequest.name())
                .series(characterRequest.series())
                .createdDate(LocalDate.now())
                .build();
        characterRepository.save(character);
        ValidResponse validResponse = restTemplate.getForObject(
                "http://localhost:8082/api/v1/valid-check/{characterId}",
                ValidResponse.class,
                character.getId()
        );

        if(!validResponse.isValid()){
            throw new IllegalStateException("not valid");
        }
    }

    public void deleteCharacter(Long characterId){
        boolean characterExist = characterRepository.existsById(characterId);
        if(!characterExist){
            throw new IllegalStateException(
              "Anime character with id "+characterId+" does not exist"
            );
        }
        characterRepository.deleteById(characterId);
    }

    @Transactional
    public void modifyCharacter(Long characterId, CharacterRequest characterRequest){

        Character character = characterRepository.findById(characterId)
                .orElseThrow(()-> new IllegalStateException(
                        "Anime Character with id "+characterId+" does not exist"
                ));

        if(characterRequest.name() != null &&
                characterRequest.name().length() > 0 &&
                !Objects.equals(character.getName(), characterRequest.name())){
            character.setName(characterRequest.name());
        }

        if(characterRequest.series() != null &&
                characterRequest.series().length() > 0 &&
                !Objects.equals(character.getSeries(), characterRequest.series())){
            character.setSeries(characterRequest.series());
        }
    }
}
