package com.demo.example.student_library_management_system.model;

import com.demo.example.student_library_management_system.enums.Category;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "publisher_name", nullable = false)
    private String publisherName;

    @Column(name = "published_date", nullable = false)
    private String publishedDate;

    @Column(name = "pages", nullable = false)
    private int pages;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "availability", nullable = false)
    private boolean availability;

    @Column(name = "category", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Category category;

    @Column(name = "rack_no", nullable = false)
    private String rackNo;

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

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getRackNo() {
        return rackNo;
    }

    public void setRackNo(String rackNo) {
        this.rackNo = rackNo;
    }

    @JoinColumn
    @ManyToOne
    private Author author;

    @JoinColumn
    @ManyToOne
    private Card card;

    @OneToMany(mappedBy = "book")
    private List<Transaction> transactionList = new ArrayList<Transaction>();

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

}
