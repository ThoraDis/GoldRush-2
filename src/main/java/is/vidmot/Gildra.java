package is.vidmot;

import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Gildra extends Rectangle {

    private static final Random rand = new Random(); // slembigjafi

    public Gildra() {
        FXML_Lestur.lesa(this, "gildra-view.fxml");
    }

    public Gildra(int breidd, int haed) {
        this(); // kallar á smiðinn sem er án parametra
        setX(rand.nextInt((int) (breidd - getWidth())));
        setY(rand.nextInt((int) (haed - getHeight())));
    }
}
