package entities.utils;

import entities.Book;
 
/**
 * Utility methods for working with {@link Book} instances.
 */
public final class BookUtils {

    private BookUtils() {
        // Utility class; prevent instantiation.
    }

    /**
     * Builds a single {@link String} containing the formatted representation of
     * every {@link Book} in the supplied array.
     * <p>
     * Each entry is prefixed with the array index and followed by the output of
     * {@link Book#format() Book.format()}. Null array elements are represented by
     * the literal {@code null}. When the array itself is {@code null} or empty, the
     * message {@code "No books found"} is returned.
     *
     * @param books the array of {@link Book} instances to render; may contain nulls
     * @return a textual representation of all books in the array, or
     *         {@code "No books found"} when no books are available
     */
    public static String toString(Book[] books) {
        if (books == null || books.length == 0) {
            return "No books found";
        }

        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < books.length; index++) {
            if (index > 0) {
                builder.append(System.lineSeparator());
            }

            builder.append(index).append(") ");
            Book book = books[index];
            if (book == null) {
                builder.append("null");
            } else {
                builder.append(book.format());
            }
        }
        return builder.toString();
    }
}
