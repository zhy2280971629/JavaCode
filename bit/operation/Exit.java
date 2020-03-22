package comm.bit.operation;
import comm.bit.book.BookList;

public class Exit implements IOperation{
    public void work(BookList bookList) {
        System.out.println("退出系统");
        System.exit(0);
    }
}
