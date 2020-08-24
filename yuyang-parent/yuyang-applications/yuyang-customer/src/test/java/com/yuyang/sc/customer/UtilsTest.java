package com.yuyang.sc.customer;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.CollectionUtils;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class UtilsTest {
    /**
     * 批量重命名文件
     * @throws Exception
     */
    @Test
    public void renameFile()throws Exception{
        String filePath="E:\\DNF\\86\\Script\\equipment\\character\\partset";
        File directory=new File(filePath);
        if(directory.exists()&&directory.isDirectory()){
            //获取文件列表
            File [] files=directory.listFiles();
            if(files!=null&&files.length>0){
                for (int i = 0; i < files.length; i++) {
                    String newFileName=files[i].getName().replaceAll("\\.","_cre\\.");
                    File newFile=new File(filePath+"\\"+newFileName);
                    FileUtils.moveFile(files[i],newFile);
                }
            }
        }
    }

    /**
     * 针对文件替换内容
     * @throws Exception
     */
    @Test
    public void updateFileContent()throws Exception{
        String filePath="E:\\DNF\\86\\Script\\equipment\\creature";
        File d1=new File(filePath);
        File[] d2=d1.listFiles();
        for (int i = 0; i < d2.length; i++) {
            File [] f3=d2[i].listFiles();
            for (int j = 0; j < f3.length; j++) {
                File everyFile=f3[j];
                InputStream is=new FileInputStream(everyFile);
                InputStreamReader isr = new InputStreamReader(is, "UTF-8");
                // 使用 BufferedReader 进行读取
                List<String> lines=FileUtils.readLines(everyFile,"utf-8");
                for (int k = 0; k < lines.size(); k++) {
                    String line=lines.get(k);
                    if(line.equals("[part set index]")){
                        lines.set(k+1,lines.get(k+1).replaceAll("11\t","11"));
                    }
                }
                System.out.println(filePath+"\\"+d2[i].getName()+"\\"+everyFile.getName());
                FileUtils.writeLines(new File(filePath+"\\"+d2[i].getName()+"\\"+everyFile.getName()),lines);
            }
        }
    }

}
