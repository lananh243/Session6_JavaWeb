package com.data.session06_javaweb.ra.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Book {
    private int bookId;
    private String title;
    private String author;
    private String category;
    private int quantity;

}
