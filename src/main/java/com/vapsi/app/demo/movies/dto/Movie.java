package com.vapsi.app.demo.movies.dto;

import java.util.Objects;

public class Movie {
    private int id;
    private String name;
    private String actorName;
    private String directorName;

    public Movie(int id, String name, String actorName, String directorName) {
        this.id = id;
        this.name = name;
        this.actorName = actorName;
        this.directorName = directorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id && Objects.equals(name, movie.name) && Objects.equals(actorName, movie.actorName) && Objects.equals(directorName, movie.directorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, actorName, directorName);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getActorName() {
        return actorName;
    }

    public String getDirectorName() {
        return directorName;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", actorName='" + actorName + '\'' +
                ", directorName='" + directorName + '\'' +
                '}';
    }
}
