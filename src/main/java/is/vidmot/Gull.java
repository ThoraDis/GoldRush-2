package is.vidmot;
import javafx.scene.shape.Rectangle;

/******************************************************************************
 *  Nafn    : Arnaldur Ólafsson, Þóra Dís Garðarsdóttir
 *  T-póstur: aro42@hi.is, tdg5@hi.is
 *
 *  Lýsing  : Viðmótsklasi fyrir gull.
 *****************************************************************************/

import java.util.Random;

public class Gull extends Rectangle {

    private static final Random rand = new Random(); // slembigjafi

    /**
     * Smiður fyrir gull. Les inn notendaviðmótið
     */
    public Gull() {
        FXML_Lestur.lesa(this, "gull-view.fxml");
    }

    public void setjaGull(Leikbord b) {
        b.getChildren().remove(this);
        setX(rand.nextInt((int) (b.getWidth() - getWidth())));
        setY(rand.nextInt((int) (b.getHeight() - getHeight())));
        b.getChildren().add(this);
    }
}
