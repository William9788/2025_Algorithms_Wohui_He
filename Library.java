import entities.Book;
import entities.utils.BookGenerator;
import entities.utils.BookUtils;

class Library {
public static void main(String[] args) {
Book[] books = BookGenerator.getRandomArray(5);

System.out.println("初始书单:");
printBooks(books);

Book removed = BookUtils.emptyIndex(books, 0);
System.out.println("\n删除位置0的书: " + describe(removed));
printBooks(books);

Book inserted = BookGenerator.generateBook();
Book displaced = BookUtils.sortedInsert(books, inserted);
System.out.println("\n插入新书: " + describe(inserted));
if (displaced != null) {
System.out.println("被挤出的书: " + describe(displaced));
}
printBooks(books);
}

static void printBooks(Book[] books) {
for (int i = 0; i < books.length; i++) {
System.out.println(i + ") " + describe(books[i]));
}
}

static String describe(Book book) {
return book == null ? "空位" : book.format();
}
}
