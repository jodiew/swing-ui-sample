package com.example.library;

import com.example.library.forms.BookEditor;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        // Launch the book editor form
        SwingUtilities.invokeLater(() -> {
            BookEditor bookEditor = new BookEditor();
            bookEditor.setVisible(true);

            bookEditor.setSaveButtonListener(book -> {
                System.out.println("Entered Book Details:");
                System.out.println("Book Title: " + book.getName());
                System.out.println("Author: " + book.getAuthor().getName());
                System.out.println("Genre: " + book.getGenre());
                System.out.println("Is Unavailable: " + book.isTaken());
            });
        });
    }
}
