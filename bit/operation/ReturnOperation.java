package comm.bit.operation;
import comm.bit.book.Book;
import comm.bit.book.BookList;
public class ReturnOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("ReturnOperation");
        System.out.println("输入需要归还的书籍名称");
        String name = scanner.next();
        int i=0;
        for(;i<bookList.getSize();i++){
            if(bookList.getBook(i).name.equals(name)){
                break;
            }
        }
        if(i>=bookList.getSize()){
            System.out.println("没有此书");
        }
        Book book=bookList.getBook(i);
        if(book.isBorrowed){
            book.isBorrowed=false;
            System.out.println("归还成功");
        }else{
            System.out.println("归还失败");
        }
    }
}
