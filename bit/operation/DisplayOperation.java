package comm.bit.operation;
import comm.bit.book.BookList;
public class DisplayOperation implements IOperation{
    public void work(BookList bookList) {
        System.out.println("DisplayOperation");
        for (int i = 0; i < bookList.getSize(); i++) {
            System.out.println(bookList.getBook(i));
        }
    }
}
