package org.metadata.integration.model;

import javax.persistence.*;
import java.util.List;
@Entity
public class Crew {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ElementCollection
    private List<String> directors;
    private String producer;


    public String getProducer() {
        return producer;
    }

    public List<String> getDirectors() {
        return directors;
    }

    public void setDirectors(List<String> directors) {
        this.directors = directors;
    }

    public List<String> getWriters() {
        return writers;
    }

    public void setWriters(List<String> writers) {
        this.writers = writers;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @ElementCollection
    private List<String> writers;
}
