package com.proyect.proyectexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyect.proyectexample.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
   
    
}
