package com.example.io;

public class FileExamples {
    public static void main(String[] args) throws Exception {
        // Files
        // Paths
        // packages
        //// java.io -> データ・ストリーム・直列化・ファイルシステム入出力用の基本的なインターフェースとクラス
        //// java.nio.file -> ファイル・ファイル属性、ファイルシステムにアクセス
        //// java.nio.file.attribute -> ファイルおよびファイルシステム属性へのアクセスを提供
        //// java.nio.file.channels -> 入出力操作を実行できるエンティティー（ファイル、ソケットなど）への接続を表すチャネルクラスを提供
        FileUser fileUser = new FileUser();
        fileUser.showStream();
    }
}
