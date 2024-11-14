# Book Manager Project

Este proyecto implementa un sistema de gestión de libros en Java utilizando el patrón de diseño **Repository**. El sistema permite a los usuarios agregar, ver, eliminar y cambiar el repositorio de almacenamiento de libros desde memoria, CSV, o base de datos MySQL.

## Diagrama UML

![UML-BookManager](https://github.com/user-attachments/assets/ffaea4e6-19c1-49e4-a20e-1c7b86b457a9)


## Estructura del Proyecto

### Clases Principales

1. **Book**: Representa un libro con los atributos `isbn`, `titulo`, y `autor`. Incluye métodos de acceso (`getIsbn()`, `getTitulo()`, `getAutor()`) y una representación en cadena (`toString()`).

2. **BookManager**: Esta clase es el gestor principal de los libros. Utiliza el patrón de diseño Repository para delegar las operaciones de almacenamiento en una implementación específica de `BookRepository`.
   - **Métodos**:
     - `createLibro(String isbn, String titulo, String autor)`: Crea un nuevo libro.
     - `deleteBook(String isbn)`: Elimina un libro por ISBN.
     - `getAllBooks()`: Devuelve una lista de todos los libros.
     - `changeRepository(BookRepository bookRepository)`: Permite cambiar el repositorio de almacenamiento de libros.

3. **BookRepository**: Es una interfaz que define las operaciones para gestionar libros en el repositorio. Implementa los siguientes métodos:
   - `createBook(Book book)`: Agrega un nuevo libro al repositorio.
   - `List<Book> findAll()`: Devuelve todos los libros en el repositorio.
   - `updateLibro(Book book)`: Actualiza la información de un libro.
   - `deleteLibroByIsbn(String isbn)`: Elimina un libro por su ISBN.

### Implementaciones de `BookRepository`

1. **MemoryBookRepository**: Implementación de `BookRepository` que almacena los libros en memoria.
2. **CSVBookRepository**: Implementación de `BookRepository` que almacena los libros en un archivo CSV.
3. **MySQLBookRepository**: Implementación de `BookRepository` que almacena los libros en una base de datos MySQL.

### Clase de Presentación

1. **View**: Clase de presentación que interactúa con el usuario a través de la consola. Ofrece un menú con las opciones:
   - **Añadir Libro**: Permite agregar un nuevo libro.
   - **Ver todos los libros**: Muestra todos los libros almacenados.
   - **Eliminar libro**: Permite eliminar un libro por ISBN.
   - **Cambiar Repositorio**: Permite cambiar entre repositorios (memoria, archivo CSV, o base de datos MySQL).
   - **Salir**: Finaliza el programa.

## Configuración e Instalación

1. **Clonar el Repositorio**: 
   ```bash
   git clone https://github.com/tu_usuario/book-manager.git
