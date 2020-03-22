package comm.bit.user;

import comm.bit.book.BookList;
import comm.bit.operation.IOperation;
public abstract class User {
    protected String name;
    protected IOperation[] operations;

    public abstract int menu();
        // 根据用户选项执行操作
    public void doOperation(int choice, BookList bookList) {
            operations[choice].work(bookList);
        }
    }
