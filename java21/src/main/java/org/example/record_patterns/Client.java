package org.example.record_patterns;

public class Client {
    public static void main(String[] args) {
        // Quote -> https://www.infoq.com/jp/news/2022/06/java-record-pattern/
        Point origin = new Point(0, 0);
        Point station = new Point(3, 5);

        printSumPrevious(origin);
        printSumNewer(station);

        ColoredPoint originColored = new ColoredPoint(origin, Color.BLUE);
        ColoredPoint stationColored = new ColoredPoint(station, Color.GREEN);

        Square square = new Square(originColored, stationColored);

        printUpperLeftColoredPoint(square);
    }

    public static void printSumPrevious(Object o) {
        // java16 - instanceof でオブジェクトの変数宣言が可能
        if (o instanceof Point point) {
            System.out.println("Newer record patterns" + point.x() + point.y());
        }
    }

    public static void printSumNewer(Object o) {
        // instanceof でフィールド変数宣言までできる
        if (o instanceof Point(int x, int y)) {
            System.out.println("Newer record patterns" + (x + y));
        }
    }

    public static void printUpperLeftColoredPoint(Square square) {
        // 複雑なグラフ構造となっているrecordも分解できる
        if (square instanceof Square(ColoredPoint(Point(var x, var y), var color), var leftRight)) {
            System.out.println("upperLeft:" + (x + y));
            System.out.println("color:" + color);
            System.out.println("leftRight:" + leftRight);
        }
    }
}
