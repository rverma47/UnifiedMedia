package org.metadata.integration.model;


import javax.persistence.*;
import java.util.List;
@Entity
public class Metadata {
    @Id
    private String title;
    private String description;
    private String release_date;
    @ElementCollection
    private List<String> genres;
    @ElementCollection
    private List<String> cast;
    @OneToOne(cascade = CascadeType.ALL)
    private Crew crew;
    @OneToOne(cascade = CascadeType.ALL)
    private AccessControl access_control;
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<String> getCast() {
        return cast;
    }

    public void setCast(List<String> cast) {
        this.cast = cast;
    }

    public Crew getCrew() {
        return crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }

    public AccessControl getAccess_control() {
        return access_control;
    }

    public void setAccess_control(AccessControl access_control) {
        this.access_control = access_control;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
