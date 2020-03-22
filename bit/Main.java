package comm.bit;

import comm.bit.book.BookList;
import comm.bit.user.Admin;
import comm.bit.user.NormalUser;
import comm.bit.user.User;

import java.util.Scanner;
public class Main {
    public static User login() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入你的姓名");
        String name=scanner.next();
        System.out.println("请输入用户类型：");
        System.out.println("1.普通用户");
        System.out.println("0.管理员");
        int choice=scanner.nextInt();
        if(choice==0){
            User user=new Admin(name);
            return user;
        } else{
            User user=new NormalUser(name);
            return user;
        }
    }
    public static void main(String[] args) {
        System.out.println("欢迎进入图书管理系统");
        BookList bookList=new BookList();
        User user=login();
        while(true){
            int choice=user.menu();
            user.doOperation(choice,bookList);
        }
    }
}
