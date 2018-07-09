public class Color {

    public static final int WHITE_VALUE = 255;
    private final int a;
    private final int r;
    private final int g;
    private final int b;

    public Color(int rgb) {

        // 0xff is hexadecimal representation of the decimal value 255
        // see https://www.dyclassroom.com/image-processing-project/how-to-get-and-set-pixel-value-in-java
        a = (rgb>>24) & 0xff; // ALPHA bits occupy 8 bits from index 24 to index 31
        r = (rgb>>16) & 0xff; // RED bits occupy 8 bits from index 16 to index 23
        g = (rgb>>8) & 0xff; // GREEN bits occupy 8 bits from index 8 to index 15
        b = rgb & 0xff; // BLUE bits occupy 8 bits from index 0 to index 7
    }

    int calculateLuma() {
        int luma;
        if(isWhite()) {
            luma = WHITE_VALUE;
        } else {
            luma = (int) (0.299 * r + 0.587 * g + 0.144 * b);
        }
        return luma;
    }

    private boolean isWhite() {
        return r == WHITE_VALUE && g == WHITE_VALUE && b == WHITE_VALUE;
    }

    int calculateGrayRgbValue(int luma) {
        return (a<<24) | (luma<<16) | (luma<<8) | luma;
    }
}
