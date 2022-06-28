package com.p50x.validate;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/valid-check")
@AllArgsConstructor
public class ValidController {
    private final ValidateCheckService validateCheckService;

    @GetMapping(path= "{characterId}")
    public ValidResponse isValidResponse (@PathVariable("characterId") Integer characterId){
        Boolean validCharater = validateCheckService.isValidCharacter(characterId);
        return  new ValidResponse(validCharater);
    }
}
