package com.proyect.proyectexample.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tickets")

public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TicketPriority priority;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public Ticket(){

    }

    public Ticket( 
        String title,
        String description,
        TicketStatus status,
        TicketPriority priority
    ){
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
    }

    @PrePersist
    public void prePersist(){
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();

        if(status == null){
            status = TicketStatus.OPEN;
        }
    }

    @PreUpdate
    public void preUpdate(){
        updatedAt = LocalDateTime.now();
    }

    public Long getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public String setDescription(String description){
        return description;
    }

    public TicketStatus getStatus(){
        return status;
    }

    public void setStatus(TicketStatus status){
        this.status = status;
    }

    public TicketPriority getPriority() {
        return priority;
    }

    public void setPriority(TicketPriority priority) {
        this.priority = priority;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    

}
