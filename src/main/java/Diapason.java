/**
 * @author RoSteik (Telegram: @RoSteik)
 * Project: Lab-1-DSA
 * Package: PACKAGE_NAME
 * Class: Diapason
 */

public class Diapason {

    int leftEdge;
    int rightEdge;

    Diapason(int leftEdge, int rightEdge) {
        this.leftEdge = leftEdge;
        this.rightEdge = rightEdge;
    }

    public int middle() {
        return (leftEdge + rightEdge) / 2;
    }

}
