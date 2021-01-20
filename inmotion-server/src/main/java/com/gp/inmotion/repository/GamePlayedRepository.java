package com.gp.inmotion.repository;

import com.gp.inmotion.models.GamePlayed;
import com.gp.inmotion.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;


@Repository
public interface GamePlayedRepository extends JpaRepository<GamePlayed, Long> {
   List<GamePlayed> getAllByPlayer(Patient patient);
}
