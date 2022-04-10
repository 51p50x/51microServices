package com.p50x.animecharacter;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/character")
@AllArgsConstructor
public class CharacterController {

    public CharacterService characterService;

    @GetMapping("/getCharacters")
    public List<Character> getCharacters(){
       return characterService.getCharacters();
    }

    @PostMapping("/addCharacter")
    public void addCharacter(@RequestBody CharacterRequest characterRequest){
        characterService.addCharacter(characterRequest);
    }

    @PutMapping("/modifyCharacter/{characterId}")
    public void modifyCharacter(@PathVariable("characterId") Long characterId,
                                @RequestBody(required = false) CharacterRequest characterRequest){
        characterService.modifyCharacter(characterId,characterRequest);
    }

    @DeleteMapping("/deleteCharacter/{characterId}")
    public void deleteCharacter(@PathVariable("characterId") Long characterId){
        characterService.deleteCharacter(characterId);
    }

}
