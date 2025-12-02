package com.example.library.forms;

import com.example.library.*;

import javax.swing.*;

public class BookEditor extends JFrame{
    private JPanel contentPane;
    private JTextField bookNameField;
    private JTextField authorNameField;
    private JComboBox<Genre> genreComboBox;
    private JCheckBox isTakenCheckBox;
    private JButton saveButton;
    private JButton cancelButton;

    private SaveButtonListener saveButtonListener;

    public BookEditor()  {
        setTitle("Book Editor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(contentPane);
        pack();

        populateGenreComboBox();

        setLocationRelativeTo(null);

        saveButton.addActionListener(e -> saveChanges());

        cancelButton.addActionListener(e -> cancelChanges());

        setVisible(true);
    }

    private void cancelChanges() {
        bookNameField.setText("");
        authorNameField.setText("");
        genreComboBox.setSelectedIndex(0);
        isTakenCheckBox.setSelected(false);
    }

    private void saveChanges() {
        String authorName = authorNameField.getText();
        String bookName = bookNameField.getText();
        Genre genre = (Genre) genreComboBox.getSelectedItem();
        boolean isTaken = isTakenCheckBox.isSelected();

        Author author = new Author(authorName, "");

        Book book = new Book(author, genre, null, bookName);
        book.setTaken(isTaken);

        if (saveButtonListener != null) {
            saveButtonListener.onSaveClicked(book);
        }

        authorNameField.setText("");
        bookNameField.setText("");
        genreComboBox.setSelectedIndex(0);
        isTakenCheckBox.setSelected(false);
    }

    private void populateGenreComboBox() {
        DefaultComboBoxModel<Genre> comboBoxModel = (DefaultComboBoxModel<Genre>) genreComboBox.getModel();

        for (Genre genre : Genre.values()) {
            comboBoxModel.addElement(genre);
        }
    }

    public void setSaveButtonListener(SaveButtonListener listener) {
        this.saveButtonListener = listener;
    }
}
