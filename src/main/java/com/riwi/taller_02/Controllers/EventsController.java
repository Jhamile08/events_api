package com.riwi.taller_02.Controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.taller_02.Services.Abstract_Service.IEventsService;
import com.riwi.taller_02.Entities.Events;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/events")
@AllArgsConstructor
public class EventsController {

    @Autowired
    private final IEventsService objIEventsService;

    @GetMapping
    public ResponseEntity<Page<Events>> getAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "2") int size){

        Page<Events> listEvents = this.objIEventsService.getAll(page -1, size);
        
        return ResponseEntity.ok(listEvents);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Events> get(@PathVariable String id){
        return ResponseEntity.ok(this.objIEventsService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Events> insert(@RequestBody Events objEvents){
        LocalDate actualDate = LocalDate.now();
        if (objEvents.getDate().isBefore(actualDate) && objEvents.getCapacity() > 0) {
           return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(this.objIEventsService.save(objEvents));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Events> update(
        @RequestBody Events objEvents,
        @PathVariable Long id
    ){
        LocalDate actualDate = LocalDate.now();
        if (objEvents.getDate().isBefore(actualDate)) {
           return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(this.objIEventsService.update(objEvents));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        this.objIEventsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
