package com.riwi.taller_02.Repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.riwi.taller_02.Entities.Events;

@Repository
public interface EventsRepository extends JpaRepository<Events,String>{
    public List<Events> findByName(String name);
 
}
