// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package entities.utils;

import entities.Book;
import java.util.Arrays;
import java.util.Random;

public class BookGenerator {
   private static String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
   private static Random randomGen = new Random();
   private static String[] authors = new String[]{"William Shakespeare", "Jane Austen", "Mark Twain", "Charles Dickens", "Leo Tolstoy", "Rick Riordan", "George Orwell", "J.K. Rowling", "Ernest Hemingway", "F. Scott Fitzgerald", "Agatha Christie", "J.R.R. Tolkien", "Toni Morrison", "Suzanne Collins", "Lewis Carroll", "Thomas Flintham"};
   private static String[] titles = new String[]{"Charlotte's Web", "Matilda", "The Very Hungry Caterpillar", "The Tale of Peter Rabbit", "The Cat in the Hat", "Where the Wild Things Are", "Winnie-the-Pooh", "Alice's Adventures in Wonderland", "The Wind in the Willows", "The Little Prince", "Percy Jackson and the Olympians: The Lightning Thief", "The Hunger Games", "Divergent", "The Maze Runner", "Twilight", "The Fault in Our Stars", "The Giver", "A Wrinkle in Time", "Pride and Prejudice", "Jane Eyre", "Wuthering Heights", "To Kill a Mockingbird", "The Great Gatsby", "1984", "Moby-Dick", "Crime and Punishment", "Great Expectations", "Frankenstein", "Brave New World", "Fahrenheit 451", "The Handmaid's Tale", "Animal Farm", "Lord of the Flies", "The Road", "Never Let Me Go", "The Book Thief", "Station Eleven", "The Power", "Life of Pi", "The Alchemist", "The Kite Runner", "The Shadow of the Wind", "The Secret Garden", "Anne of Green Gables", "Little Women", "Coraline", "Goodnight Moon", "Peter Pan"};

   public BookGenerator() {
   }

   public static Book[] getRandomArray(int numBooks) {
      Book[] books = new Book[numBooks];

      for(int i = 0; i < numBooks; ++i) {
         books[i] = generateBook();
      }

      Book duplicate = books[books.length - 1];
      int numDuplicates = randomGen.nextInt(1, 5);

      for(int i = 0; i < numDuplicates; ++i) {
         int randomIndex = randomGen.nextInt(books.length);
         books[randomIndex] = duplicate;
      }

      return books;
   }

   public static Book generateBook() {
      int authorIndex = randomGen.nextInt(authors.length);
      String randomAuthor = authors[authorIndex];
      int titleIndex = randomGen.nextInt(titles.length);
      String randomTitle = titles[titleIndex];
      String randomIsbn = generateISBN();
      return new Book(randomIsbn, randomTitle, randomAuthor);
   }

   public static String generateISBN() {
      StringBuilder isbn = new StringBuilder();

      for(int i = 0; i < 10; ++i) {
         int charIndex = randomGen.nextInt(characters.length());
         isbn.append(characters.charAt(charIndex));
      }

      return isbn.toString();
   }

   public static void main(String[] args) {
      Book randomBook = generateBook();
      System.out.println(randomBook.format());
      Book[] books = getRandomArray(10);
      Book[] var3 = books;
      int var4 = books.length;

      int var5;
      Book b;
      for(var5 = 0; var5 < var4; ++var5) {
         b = var3[var5];
         System.out.println(b);
      }

      System.out.println("----------------------");
      Arrays.sort(books);
      var3 = books;
      var4 = books.length;

      for(var5 = 0; var5 < var4; ++var5) {
         b = var3[var5];
         System.out.println(b);
      }

   }
}
