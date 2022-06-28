package com.p50x.validate;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class ValidateCheckService {

    private final ValidCheckHistoryRepository validCheckHistoryRepository;

    public boolean isValidCharacter(Integer characterId){
        validCheckHistoryRepository.save(
                ValidCheckHistory.builder()
                        .characterId(characterId)
                        .isInvalid(false)
                        .createdAt(LocalDateTime.now())
                        .build()
        );
        return true;
    }
}
