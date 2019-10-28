package com.zz.coreJava2.chapter1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangbenchao
 * @date 2019-10-28 10:47
 * 文件描述：
 */
public class CountLongWords {
    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("src/text/alice30.txt")), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("\\PL+"));
        System.out.println(words);
        long count=0;
        for(String w:words){
            if(w.length()>6){
                count++;
            }
        }
        System.out.println(count);

        count = words.stream().filter(w ->w.length()>6).count();
        System.out.println(count);

        count = words.parallelStream().filter(w ->w.length()>6).count();
        System.out.println(count);
    }
}
