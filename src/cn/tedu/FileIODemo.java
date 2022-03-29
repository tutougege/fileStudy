package cn.tedu;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

/**
 * @author liwei
 * @create 2022-03-29-20:39
 **/
/*
lambda表达式:
    (参数列表)->{方法体};
 */
public class FileIODemo {
    public static void main(String[] args) throws IOException {
        File file = new File("fos.txt");//连接文档
        if(file.exists()){
            file.getName();
            if(file.isDirectory()){//判断file是否为一个文件夹
                File[] files = file.listFiles(new FileFilter() {//匿名内部类使用过滤器
                    @Override
                    public boolean accept(File pathname) {
                        return pathname.getName().contains("a");
                    }
                });//遍历目录下的文件名
                File[] files1 = file.listFiles(f->f.getName().contains("a"));//lambda表达式使用过滤器

            }
//            file.mkdirs();//mkdir为建立当前文件夹 makdirs为多级文件夹
        }else{
            file.createNewFile();
        }
    }
}
