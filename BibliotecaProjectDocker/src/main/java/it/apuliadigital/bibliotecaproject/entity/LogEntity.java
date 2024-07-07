package it.apuliadigital.bibliotecaproject.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class LogEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String path;
    private String message;
    private LocalDateTime timestamp;

    public LogEntity() {
    }

    public LogEntity(String path, String message, LocalDateTime timestamp) {
        this.path = path;
        this.message = message;
        this.timestamp = timestamp;
    }

    public LogEntity(Long id, String path, String message, LocalDateTime timestamp) {
        this.id = id;
        this.path = path;
        this.message = message;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "LogEntity ID: " + id + "\n" + "" +
                "Path: " + path + "\n" +
                "Message: " + message + "\n" +
                "Timestamp: " + timestamp;
    }
}
