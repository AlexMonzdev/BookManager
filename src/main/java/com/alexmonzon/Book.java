package com.alexmonzon;

public class Book {
    private String isbn;
    private String titulo;
    private String autor;

    public Book(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "isbn='" + isbn + "| titulo='" + titulo + "| autor='" + autor +'\n';
    }
}
