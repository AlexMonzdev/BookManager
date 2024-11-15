# Book Manager Project

Este proyecto implementa un sistema de gestión de libros en Java utilizando el patrón de diseño **Repository**. El sistema permite a los usuarios agregar, ver, eliminar y cambiar el repositorio de almacenamiento de libros desde memoria, CSV, o base de datos MySQL.

# Principios de Diseño Aplicados

Este sistema de gestión de libros está diseñado siguiendo principios de diseño orientados a objetos para garantizar modularidad, extensibilidad y facilidad de mantenimiento. A continuación, se describen algunos de los principios aplicados:

## 1. Inversión de Dependencia
El sistema utiliza el principio de inversión de dependencia mediante la interfaz `BookRepository`. La clase `BookManager` depende de `BookRepository` en lugar de depender de una implementación específica, como `InMemoryBookRepository` o `MySQLBookRepository`. Esto permite que `BookManager` pueda funcionar con cualquier implementación de `BookRepository`, haciendo que el sistema sea flexible y permitiendo cambiar la fuente de datos sin modificar el código del gestor de libros.

## 2. Open/Closed Principle (Principio Abierto/Cerrado)
El sistema sigue el principio de abierto/cerrado, donde las clases están abiertas a la extensión pero cerradas a la modificación:
- **Abierto a la Extensión:** Se pueden añadir nuevas implementaciones de `BookRepository` (por ejemplo, para almacenar datos en una API o en otro tipo de base de datos) sin necesidad de modificar las clases existentes.
- **Cerrado a la Modificación:** `BookManager` y `ConsoleView` no necesitan ser modificados para soportar nuevos tipos de almacenamiento, ya que solo dependen de la interfaz `BookRepository`.

## 3. Separación de Responsabilidades
Cada clase en el sistema tiene una única responsabilidad clara:
- `ConsoleView` maneja la interacción con el usuario.
- `BookManager` gestiona la lógica de negocio de los libros.
- `BookRepository` y sus implementaciones (`InMemoryBookRepository` y `MySQLBookRepository`) se encargan de la persistencia de datos.

Esta separación facilita el mantenimiento y la expansión del sistema, ya que los cambios en una parte no afectan directamente a las demás.

---

Este diseño modular y flexible permite que el sistema sea fácilmente expandible para soportar nuevos tipos de almacenamiento o interfaces de usuario (por ejemplo, una interfaz gráfica), mejorando su capacidad de adaptación a futuras necesidades.



## Diagrama UML

![Clase UML](https://github.com/user-attachments/assets/4a262a6b-f1e5-40d4-b5be-17f3b38192c2)


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
