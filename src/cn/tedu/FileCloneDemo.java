package cn.tedu;

import java.io.*;

/**
 * @author liwei
 * @create 2022-03-29-20:55
 **/
public class FileCloneDemo {
    public static void main(String[] args) throws IOException {
        File fi = new File("./fi.txt");
        File fo = new File("./fi_copy.txt");
        if(fi.exists()){
//            fileClone(fi,fo);//字节流
            writeInFile(fi);
            fileReaderClone(new File("./fi.txt"),fo);
        }else {
            fi.createNewFile();
        }
    }

    private static File writeInFile(File fi) throws FileNotFoundException, UnsupportedEncodingException {
        FileOutputStream fos = new FileOutputStream(fi,true);//字节输出流
        OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");//字节流转字符流
        BufferedWriter bw = new BufferedWriter(osw);//高效缓冲流
        PrintWriter pr = new PrintWriter(bw);//可以刷新行的高效缓冲流
        pr.println("好好学习，");
        pr.println("天天向上.");
        pr.flush();
        return fi;
    }

    private static void fileReaderClone(File fi, File fo) throws IOException {
        FileReader fr = new FileReader(fi);//文件字符输入流
        FileWriter fw = new FileWriter(fo);//文件字符输出流
        BufferedWriter bw = new BufferedWriter(fw);//高效缓冲字符输出流
        BufferedReader br = new BufferedReader(fr);//高效缓冲字符输入流
        int len;
        while((len = br.read())!=-1){
            bw.write(len);
        }
        bw.close();
        br.close();
    }

    private static void fileClone(File fi, File fo) throws IOException {
        FileInputStream fis = new FileInputStream(fi);
        FileOutputStream fos = new FileOutputStream(fo);//低级字节流
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);//高级缓冲字节流
        int len;
        while((len = bis.read())!=-1){
            bos.write(len);
        }
        fis.close();
        fos.close();
    }

}
