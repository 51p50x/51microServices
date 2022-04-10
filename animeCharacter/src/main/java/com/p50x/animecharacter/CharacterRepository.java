package com.p50x.animecharacter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CharacterRepository extends JpaRepository<Character, Long> {

    @Query("SELECT c FROM Character c WHERE c.series=?1 and c.name=?2")
    Optional<Character> findCharacterBySeries(String series, String name);


}
