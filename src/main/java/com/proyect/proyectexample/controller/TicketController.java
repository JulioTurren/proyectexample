package com.proyect.proyectexample.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyect.proyectexample.entity.Ticket;
import com.proyect.proyectexample.repository.TicketService;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets(){
        return ResponseEntity.ok(ticketService.getAllTickets());
    }

    @PostMapping
    public ResponseEntity<Ticket>createTicket(@RequestBody Ticket ticket){
        Ticket savedTicket = ticketService.creaTicket(ticket);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedTicket);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id){
        Ticket ticket = ticketService.getTicketById(id);

        return ResponseEntity.ok(ticket);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ticket> updateTicket( @PathVariable Long id, @RequestBody Ticket ticket){
        Ticket updatTicket = ticketService.updateTicket(id, ticket);
        return ResponseEntity.ok(updatTicket);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {

        ticketService.deleteTicket(id);

        return ResponseEntity.noContent().build();
    }

}
