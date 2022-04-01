package com.tang.modernjavainaction.chap9;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @Title: Test
 * @Description:
 * @author: tangyao
 * @date: 2022/3/21 16:02
 * @Version: 1.0
 */

interface Task {
    void execute();
}

interface BufferedReaderProcessor{
    String process(BufferedReader b) throws IOException;
}


public class Test {

    public static void doSomething(Task task) {
        task.execute();
    }

    public static void doSomething(Runnable r) {
        r.run();
    }

    public static void main(String[] args) throws IOException {

        doSomething((Task) () -> {
        });

        String oneLine = processFile((BufferedReader b) -> b.readLine());

    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        File file;
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }

    }
}