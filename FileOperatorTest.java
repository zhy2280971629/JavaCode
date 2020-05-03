package lesson2;


import org.junit.Test;

import java.io.*;

public class FileOperatorTest {
    @Test
    public void fileRead_1() throws IOException {
        //字节流转换为字符流，需要使用字节字符转换流
        //转换流可以设置编码：java文件的编码格式、文件编码格式
        //InputStreamReader ：输入的字符字节转换流，或OutputStreamWriter：输出的字节字符转换流
        FileInputStream fis = new FileInputStream(
                new File("E:\\Java13\\io-study\\res/Excel.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(fis, "UTF-8"));
        //字符流的按行读取
//        String line;
//        while((line = br.readLine()) != null){
//            System.out.println(line);
//        }
        //字符流按字符数组读取
        char[] chars = new char[1024];
        int len;
        while((len = br.read(chars)) != -1){
            String str = new String(chars, 0, len);
            System.out.println(str);
        }
    }

    @Test
    public void fileRead_2() throws IOException {
        //字节流转换为字符流，需要使用字节字符转换流
        //转换流可以设置编码：java文件的编码格式、文件编码格式
        //InputStreamReader ：输入的字符字节转换流，或OutputStreamWriter：输出的字节字符转换流
        FileInputStream fis = new FileInputStream(
                new File("E:\\Java13\\io-study\\res/Excel.txt"));
        //按字节读取
//        byte[] bytes = new byte[1024];
//        int len;
//        while((len = fis.read(bytes, 0, 1024)) != -1){
//            String str = new String(bytes, 0, len);
//            System.out.println(str);
//        }
        byte[] bytes = new byte[1024];
        int len;
        while((len = fis.read(bytes)) != -1){
            String str = new String(bytes, 0, len);
            System.out.println(str);
        }
    }

    @Test
    public void testWrite1() throws IOException {

        FileOutputStream fos = new FileOutputStream(new File("E:\\Java13\\io-study\\res/Excel.txt"));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos, "UTF-8"));
        //使用缓冲流，输出的时候，要进行flush刷新缓冲区，否则不会真是输出数据到目的设备
        bw.write("3.舞低杨柳楼心月\n");//write写数据到内存缓冲区
        bw.write("4.歌尽桃花扇底风\n");
        bw.flush();//缓冲区刷新，发送数据到目的设备
    }

    @Test
    public void copyFile() throws Exception {
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            fis = new FileInputStream(
                    new File("E:\\Java13\\io-study\\res/Excel.txt"));
            bis = new BufferedInputStream(fis);
            fos = new FileOutputStream(
                    new File("E:\\Java13\\io-study\\res/Excel1.txt"));
            bos = new BufferedOutputStream(fos);
            byte[] bytes = new byte[1024*8];
            int len;
            while((len = fis.read(bytes)) != -1){
                bos.write(bytes);
                bos.flush();
            }
        } finally {//IO流的操作完成之后，一定要释放资源，顺序是根据依赖关系B依赖A，反向释放（先释放B，再释放A）
            if(bis != null){
                bis.close();
            }
            if(fis != null){
                fis.close();
            }
            if (bos != null){
                bos.close();
            }
            if(fos != null){
                fos.close();
            }
        }
    }
}
