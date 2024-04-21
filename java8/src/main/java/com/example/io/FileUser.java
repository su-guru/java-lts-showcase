package com.example.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

// java.io.File -> ディスクに保存されているファイルやディレクトリをオブジェクトとして表現するクラス
// File の欠点 -> https://docs.oracle.com/cd/E26537_01/tutorial/essential/io/legacy.html -> 8以降はPathを使う
// file.toPath() が追加
public class FileUser {
    public void showStream() throws Exception {
        File linux = new File("/"); // 抽象パス名の導入により、システム非依存のパス名に内部でしてくれる
        File windows = new File("D:\\");
        File resource = new File("resource");
        System.out.println("ありがと");
        System.out.println(linux.getAbsoluteFile());
        System.out.println(windows.getAbsoluteFile());
        System.out.println(resource.getAbsoluteFile());
        System.out.println(resource.toPath());

        Path inputFile = Paths.get("java8"
                , "src"
                , "main"
                , "resources"
                , "com"
                , "example"
                , "io"
                , "input.txt");
        System.out.println(inputFile.toAbsolutePath());
        Path io = Paths.get("resources", "io");

        // stream (network)
        // プログラムからファイルへのデータの書き出しや逆にファイルからプログラムへのデータの読み込みが発生する
        // -> データの送受信を連続的に行うものをストリーム
        //
        // 入力ストリームと出力ストリーム
        // バイトストリームとキャラクタストリーム -> byte単位, char単位でデータを読み書きする
        // バイトストリーム abstract OutputStream InputStream
        // ファイルからbyte単位の読み書きを行うストリーム
        try (FileInputStream inputStream = new FileInputStream(inputFile.toFile());
             FileOutputStream outputStream = new FileOutputStream(inputFile.getParent().resolve("output.txt").toFile())) {
            int data = 0;
            while ((data = inputStream.read()) != -1) {
                outputStream.write(data);
            }

            // 基本データ型のデータを読み書きできるストリーム
            // try (DataInputStream dataInputStream = new DataInputStream(inputStream);
            //      DataOutputStream dataOutputStream = new DataOutputStream(outputStream)) {
            // }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("ありがとう", e);
        }
        // キャラクタストリーム abstract Writer Reader
        // ファイルからchar単位の読み書きを行うストリーム
        try (FileReader fileReader = new FileReader(io.toFile());
             FileWriter fileWriter = new FileWriter(io.toFile())) {
            // char単位で文字、配列、行をバッファリングしながら読み書き
            try (BufferedReader bufferedReader = new BufferedReader(fileReader);
                BufferedWriter bufferedwriter = new BufferedWriter(fileWriter);) {

            }
        }
    }
}
