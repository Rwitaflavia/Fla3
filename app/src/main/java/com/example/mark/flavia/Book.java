package com.example.mark.flavia;

public class Book {

    private int id;
    private String title;
    private String Notes;

    public Book(){}

    public Book(String title, String Notes) {
        super();
        this.title = title;
        this.Notes = Notes;
    }

    //getters & setters


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", Notes=" + Notes
                + "]";
    }
}