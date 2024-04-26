package com.riwi.taller_02.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.riwi.taller_02.Entities.Events;
import com.riwi.taller_02.Repositories.EventsRepository;
import com.riwi.taller_02.Services.Abstract_Service.IEventsService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EventService implements IEventsService{
    
    @Autowired
    private final EventsRepository objEventsRepository;

    @Override
    public Events save(Events objEvents) {
        return this.objEventsRepository.save(objEvents);
    }

    @Override
    public Page <Events> getAll(int page, int size) {
                /* Validar que la página no sea menor a 0 */
        if (page < 0) {
            page = 0;
        }

        /* Crear la paginación */
        Pageable objPage = PageRequest.of(page, size);

        return this.objEventsRepository.findAll(objPage);
    }

    @Override
    public Events getById(String id) {
       return this.objEventsRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(String id) {
       Events events = this.objEventsRepository.findById(id).orElseThrow();
       this.objEventsRepository.delete(events);
    }

    @Override
    public Events update(Events objEvents) {
        return this.objEventsRepository.save(objEvents);
    }
    
}
