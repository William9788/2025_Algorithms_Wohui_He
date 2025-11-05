package entities.utils;//To save in this package
import entities.Book;//import Book java 
public class BookUtils {
 /*
 * bulid a string contain the format representation of books.
 * @return null when books not found or has 0 length.
 *  @param the array of books with Book java
 * @return a full representaition of all books in this array
 */
public static String toString(Book[] books) {//Standard format and named one param with book java
if (books == null || books.length == 0) {
return "No books found";
}//To check if input wrong or books not found.
StringBuilder builder = new StringBuilder();//use StringBuilder to String that we dont need to String every time and can keep it updated.
for (int index = 0; index < books.length; index++) {//to see the numbers of books
if (index > 0) {
builder.append(System.lineSeparator());//For change line
}
builder.append(index).append(") ");
Book book = books[index];
if (book == null) {
builder.append("null");
} else {
builder.append(book.format());//to use the format in Book java from line50 to check info.
}
}
return builder.toString();//return all what it gets.
}

public static Book emptyIndex(Book[] books,int position){
 if(books==null){
  throw new IllegalArgumentException("Book must be not null!");//if detect null throw it to the user
 }
 if(position<0||position>=books.length)
 {
  throw new IllegalArgumentException("Position must be correct!");//if detect position wrong throw it to user.
 }
 Book removed = books[position];
 for(int i = position;i<books.length -1;i++){
 books[i]=books[i+1];//to cover the book.

 }
 books[books.length-1]=null;//then delete the same books  into null.
 return removed;//let user know which book removed.


}
}