package com.yyatsiuk.codingpatterns.io;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Read4 {

    private final BufferedReader bufferedReader;

    public Read4() {
        try {
            this.bufferedReader = Files.newBufferedReader(Paths.get("src/main/resources/static/data1.txt"));
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @SneakyThrows
    protected int read4(char[] buf4) {
        int readBytes = bufferedReader.read(buf4);
        return readBytes == -1 ? 0 : readBytes;
    }

}
