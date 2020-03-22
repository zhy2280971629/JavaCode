package comm.bit.operation;

import comm.bit.book.BookList;
import comm.bit.book.Book;

public class BorrowOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("BorrowOperation");
        System.out.println("输入需要借阅书籍的名称");
        String name = scanner.next();
        int i = 0;
        for (; i < bookList.getSize(); i++) {
            if(bookList.getBook(i).name.equals(name)) {
                System.out.println(bookList.getBook(i));
                break;
            }
        }
        if(i >= bookList.getSize()) {
            System.out.println("没有此书");
            return;
        }
        Book book=bookList.getBook(i);
        if(book.isBorrowed){
            System.out.println("书籍已被借阅");
        }else{
            book.isBorrowed=true;
            System.out.println("借阅成功");
        }
    }
}

