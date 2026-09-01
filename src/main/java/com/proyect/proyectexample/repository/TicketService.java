package com.proyect.proyectexample.repository;

import java.util.List;

import org.springframework.stereotype.Service;

import com.proyect.proyectexample.entity.Ticket;

@Service
public class TicketService {
    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getAllTickets(){
        return ticketRepository.findAll();
    }

    public Ticket creaTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }

    public Ticket getTicketById(Long id){
        return ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket no encontrado"));
    }

    public Ticket updateTicket(Long id, Ticket ticketDetails){
        Ticket ticket = getTicketById(id);


        ticket.setTitle(ticketDetails.getTitle());
        ticket.setDescription(ticketDetails.getDescription());
        ticket.setPriority(ticketDetails.getPriority());
        ticket.setStatus(ticketDetails.getStatus());

        return ticketRepository.save(ticket);
    }

    public void deleteTicket(Long id){
        Ticket ticket =getTicketById(id);

        ticketRepository.delete(ticket);
    }
}
