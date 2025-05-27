package org.scoula.travel.dataimport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CsvLoader {
    public static void main(String[] args) {
        InputStream is = CsvLoader.class.getClassLoader().getResourceAsStream("travel.csv");

        if (is == null) {
            System.out.println("CSV 파일을 찾을 수 없습니다.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                for (String value : values) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
