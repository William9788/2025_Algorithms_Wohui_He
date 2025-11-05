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

/*
 * This method use for delete the book that dont want.
 * @param books the array for use from Book java
 * @param position to check the position of array and to delete.
 * @throw  first to if detect null.
 * @throw second to if decete position incorrect.
 * @return return the book that already deleted
 */
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
/*
 * This method is to delete a book using boolean.
 * @param books the array for use from BOOK JAVA
 * @param target  target the book that needs to be removed.
 * @return true if found it and deleted it .false otherwise.
 */
public static boolean delete(Book[] books, Book target){
    if(books==null||books.length==0){
    return false;//if null or length incorrect output false.
    }
    for(int index=0;index<books.length;index++){
        if((books[index]==null&&target==null)||(books[index]!=null&&books[index].equals(target)))//to create the requirement to check the book if exist
        {
            for(int i=index;i<books.length-1;i++){//if found it ,replace it 
                books[i]=books[i+1];//for replace
            }
            books[books.length-1]=null;//for replace
            return true;
        }
    }
    return false;
}
public static int deleteAll(Book[] books,Book target){
    if(books==null||books.length==0){
        return 0;
    }
    int index=0;
    int count=0;
    for(int indexx=0;indexx<books.length;indexx++){
        Book current =books[indexx];
        boolean match=(current==null&&target==null)||(current!=null&&current.equals(target));
        if(match){
            count++;
        }
        else{
            books[index++]=current;
        }
    }
    while(index<books.length){
        books[index++]=null;
    }
    return count;
}
}