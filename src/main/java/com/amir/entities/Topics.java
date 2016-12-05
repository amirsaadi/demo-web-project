package com.amir.entities;

import com.amir.util.LocalDateConverter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "TOPICS")
public class Topics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TOPIC_ID")
    private Long id ;

    @Column(name = "TOPIC_TITLE")
    private String title;

    @Column(name = "TOPIC_CONTENT")
    private String content;

    @Column(name = "TOPIC_AUTHOR")
    private String author ;

    @Column(name = "APPOINTMENT_DT")
    @Convert(converter = LocalDateConverter.class)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate date;

    public Topics(String title, String content) {
        this.title = title;
        this.content = content;
        date= LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
