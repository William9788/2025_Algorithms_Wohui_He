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
/* This method is to delete the books if target and show how many books deleted.
 * @param books the array for use from Book java
 * @param target target the books,from Book java
 * @return 0 if null or length incorrect,return the slot  if match.
 */
public static int deleteAll(Book[] books,Book target){
if(books==null||books.length==0){//
return 0;//return 0 if null or length incorrect
}
int index=0;//set a index to track ifdont need to delete.
int count=0;//set a count to count how many books deleted.
for(int indexx=0;indexx<books.length;indexx++){
Book current =books[indexx];
boolean match=(current==null&&target==null)||(current!=null&&current.equals(target));
if(match){
count++;//if match then count+;
}
else{
books[index++]=current;//to put this book into next space then to the next book.
}
}
while(index<books.length){
books[index++]=null;//to set null which is blank.
}
return count;
}
/*
 * This method is to target the book and replace it using Boolean.
 * @param books the array to use with Book java
 * @param target to target the book ,with Book java
 * @replacement instance to replace the old one
 * @return the numbers that were overwritten.
 */
public static int replace(Book[] books,Book target,Book replacement){
if(books==null||books.length==0){
return 0;//return 0 if null or length incorrect
}
int count=0;//set a count to count how many replaced
for(int i=0;i<books.length;i++){
Book current=books[i];//To take this one out and store into current.
boolean match=(current==null&&target==null)||(current!=null&&current.equals(target));//Boolean it to check if both of them are null otherwise no 
if(match){
books[i]=replacement;//if match then replace it to the new one using replacement.
count++;//if match then one more count;
}
}
return count;//return how many books that replaced.
}
/*
 * This method is to insert a new book into the array.
 * @param books the array for use ,with Book java
 * @param book the book that nedds to be inserted.
 * @return to show  the book on which is deleted.
 */
public static Book sortedInsert(Book[] books, Book book){
if(books==null||books.length==0||book==null){
return null;//to check if its null or length incorrect then return null.
}
int index=-1;//to set a position which is illegal at first then if find a proper insert point then change it .
for(int i =0;i<books.length;i++){
Book current=books[i];//take this book out and store into current.
if(current==null){
index=i;
break;
}//return null if null;
if(book.compareTo(current)<0){//so state  that it should be before current
index=i;//if found then set index to i .
break;
}
}
if(index==-1){
return null;
}//if not found that means index==-1 then return null straghtly.
Book delete=books[books.length-1];//to match the question that use delete to store books[books.length-1],then return delete at last.
for(int a= books.length-1;a>index;a--){
books[a]=books[a-1];//to move  which the elements on the right. copy the element to the next one

}
books[index]=book;//to put the new book into the array
return delete;//return the book which is out the array to the user.
}
}
