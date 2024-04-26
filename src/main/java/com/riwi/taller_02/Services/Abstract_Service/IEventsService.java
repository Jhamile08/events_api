package com.riwi.taller_02.Services.Abstract_Service;

import org.springframework.data.domain.Page;
import com.riwi.taller_02.Entities.Events;

public interface IEventsService {
    public Events save(Events objEvents);

    public Page<Events> getAll(int page, int size);

    public Events getById(String id);

    public void delete(String id);

    public Events update(Events objEvents);

    /* SpringbootApp.bind(IProductService,ProductService) */
}

