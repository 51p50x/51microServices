package com.p50x.validate;

import com.p50x.clients.validate.ValidResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/valid-check")
@AllArgsConstructor
@Slf4j
public class ValidController {
    private final ValidateCheckService validateCheckService;

    @GetMapping(path= "{characterId}")
    public ValidResponse isValidResponse (@PathVariable("characterId") Integer characterId){
        Boolean validCharacter = validateCheckService.isValidCharacter(characterId);
        log.info("validation response values {}",validCharacter);
        return  new ValidResponse(validCharacter);
    }
}
