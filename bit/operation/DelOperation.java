package comm.bit.operation;
import comm.bit.book.Book;
import comm.bit.book.BookList;
public class DelOperation implements IOperation {
    @Override
    public void work(BookList bookList) {
        System.out.println("DelOperation");
        System.out.println("输入需要删除书籍的名称");
        String name = scanner.next();
        //不会从bookList-》进行删除-》isBorrowed true
        int i = 0;
        for (; i < bookList.getSize(); i++) {
            if (bookList.getBook(i).name.equals(name)) {
                int pos = i;
                for (int j = pos; pos < bookList.getSize() - 1; j++) {
                    Book booknext = bookList.getBook(j + 1);
                    bookList.setBooks(j, booknext);
                }
                bookList.setSize(bookList.getSize()-1);
                System.out.println("删除成功");
                break;
            }
            if (i >= bookList.getSize()) {
                System.out.println("没有此书");
                return;
            }
        }
    }
}
