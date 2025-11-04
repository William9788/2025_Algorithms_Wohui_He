package entities;

public class Book implements Comparable<Book> {
   private final String isbn;
   private final String title;
   private final String author;

   public Book(String isbn, String title, String author) {
      validateISBN(isbn);
      this.isbn = isbn;
      this.title = title;
      this.author = author;
   }

   private static void validateISBN(String isbn) {
      if (isbn == null || isbn.length() != 10) {
         throw new IllegalArgumentException("All books must contain a valid ISBN value. A valid ISBN contains 10 characters.");
      }
   }

   public String getIsbn() {
      return this.isbn;
   }

   public String getTitle() {
      return this.title;
   }

   public String getAuthor() {
      return this.author;
   }

   public boolean equals(Object o) {
      if (o != null && this.getClass() == o.getClass()) {
         Book book = (Book)o;
         return this.isbn.equals(book.isbn);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.isbn.hashCode();
   }

   public String toString() {
      return "Book{isbn='" + this.isbn + "', title='" + this.title + "', author='" + this.author + "'}";
   }

   public String format() {
      return "\"" + this.title + "\" by " + this.author + " - ISBN: " + this.isbn;
   }

   public int compareTo(Book other) {
      if (other == null) {
         throw new IllegalArgumentException("Cannot compare to a null Book");
      } else {
         int titleComparison = this.title.compareTo(other.title);
         return titleComparison == 0 ? this.author.compareTo(other.author) : titleComparison;
      }
   }
}
