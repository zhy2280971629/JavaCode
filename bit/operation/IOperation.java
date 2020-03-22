package comm.bit.operation;
import comm.bit.book.BookList;
import java.util.Scanner;
public interface IOperation {
    Scanner scanner=new Scanner(System.in);
    void work(BookList bookList);
}
