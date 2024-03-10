package com.antaler.courses;

import com.antaler.courses.proto.Sample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        var random = new Random().nextInt(100) + 2;
        System.out.printf("RANDOM: %d\n",random);
        Sample.Simple.newBuilder().setIsMan(true).addAllTasks(List.of("primera", "segunda")).setName("Name").build().writeTo(new FileOutputStream("prueba.txt"));
        var data = Sample.Simple.parseFrom(new FileInputStream("prueba.txt").readAllBytes());
        System.out.println(data.toString());
    }
}