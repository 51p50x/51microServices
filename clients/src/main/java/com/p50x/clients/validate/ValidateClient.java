package com.p50x.clients.validate;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        value="validate",
        path="api/v1/valid-check"
)
public interface ValidateClient {
    @GetMapping(path= "{characterId}")
    public ValidResponse isValidResponse (@PathVariable("characterId") Integer characterId);
}
