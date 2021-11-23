package com.vapsi.app.demo.movies.dto;

import java.util.Objects;

public class Movies {
    private String name;
    private String actorName;
    private String directorName;

    public Movies(String name, String actorName, String directorName) {
        this.name = name;
        this.actorName = actorName;
        this.directorName = directorName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movies)) return false;
        Movies movies = (Movies) o;
        return Objects.equals(name, movies.name) && Objects.equals(actorName, movies.actorName) && Objects.equals(directorName, movies.directorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, actorName, directorName);
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
        return "Movies{" +
                "name='" + name + '\'' +
                ", actorName='" + actorName + '\'' +
                ", directorName='" + directorName + '\'' +
                '}';
    }
}
