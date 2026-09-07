package com.shelflife.bookstorereactspringboot;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private String genre;
    private String conditionGrade;
    private String edition;
    private double price;
    private String description;
    private String coverUrl;
    private int stock;

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public String getConditionGrade() { return conditionGrade; }
    public void setConditionGrade(String conditionGrade) { this.conditionGrade = conditionGrade; }
    public String getEdition() { return edition; }
    public void setEdition(String edition) { this.edition = edition; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public String getCoverUrl() { return coverUrl; }
    public void setCoverUrl(String coverUrl) { this.coverUrl = coverUrl; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
}