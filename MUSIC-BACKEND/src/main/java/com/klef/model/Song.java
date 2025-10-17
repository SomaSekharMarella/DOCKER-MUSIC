package com.klef.model;


public class Song {
    private int id;
    private String name;
    private String movie;
    private String singer;
    private int releaseYear;

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getMovie() { return movie; }
    public void setMovie(String movie) { this.movie = movie; }

    public String getSinger() { return singer; }
    public void setSinger(String singer) { this.singer = singer; }

    public int getReleaseYear() { return releaseYear; }
    public void setReleaseYear(int releaseYear) { this.releaseYear = releaseYear; }
}
