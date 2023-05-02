package edu.guilford;

import java.util.Random;

import javax.swing.SortOrder;

public class Movie {

    // attributes for the movie
    private String title;
    private String director;
    private int year;
    private int durationInMin;
    private double rating;

    // constructor with random generation of attributes

    public Movie() {
        // array of 10 random titles
        String[] titles = { "Bugs Life", "Toy Story", "Toy Story 2", "Toy Story 3", "Monsters Inc",
                "Monsters University",
                "Finding Nemo", "Finding Dory", "Cars", "Cars 2" };
        // array of 10 random directors
        String[] directors = { "John Lasseter", "Andrew Stanton", "Lee Unkrich", "Pete Docter", "Brad Bird",
                "Dan Scanlon",
                "Andrew Stanton", "Andrew Stanton", "John Lasseter", "John Lasseter" };
        Random rand = new Random();

        // random title and director from the arrays
        this.title = titles[rand.nextInt(titles.length)];
        this.director = directors[rand.nextInt(directors.length)];
        // random year between 1995 and 2023
        this.year = rand.nextInt(24) + 1995;
        // random duration between 60 and 180 minutes
        this.durationInMin = rand.nextInt(121) + 60;
        // random rating between 0 and 10 that rounds to the second decimal place
        this.rating = Math.round((rand.nextDouble() * 10) * 100.0) / 100.0;
    }

    // getters and setters
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // director getter

    public String getDirector() {
        return this.director;
    }

    // director setter

    public void setDirector(String director) {
        this.director = director;
    }

    // year getter

    public int getYear() {
        return this.year;
    }

    // year setter

    public void setYear(int year) {
        this.year = year;
    }

    // duration getter

    public int getDurationInMin() {
        return this.durationInMin;
    }

    // duration setter

    public void setDurationInMin(int durationInMin) {
        this.durationInMin = durationInMin;
    }

    // rating getter

    public double getRating() {
        return this.rating;
    }

    // rating setter

    public void setRating(double rating) {
        this.rating = rating;
    }

    // toString method
    @Override
    public String toString() {
        return "Title: " + this.title + "\nDirector: " + this.director + "\nYear: " + this.year + "\nDuration: "
                + this.durationInMin + " minutes" + "\nRating: " + this.rating + "\n ";
    }

}
