package is.vidmot;

import javafx.beans.binding.Bindings;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Gildra extends ImageView {

    private static final Random rand = new Random(); // slembigjafi

    public Gildra() {
        FXML_Lestur.lesa(this, "gildra-view.fxml");
        bindaVidClip();
    }

    /**
     * Binda gildru við clip sem afmarkar ferning
     */
    private void bindaVidClip() {
        double r = ((Rectangle) getClip()).getWidth();
        ((Rectangle) getClip()).heightProperty().bind(
                Bindings.createDoubleBinding(() -> this.yProperty().get() + r,
                        this.yProperty()));
        ((Rectangle) getClip()).widthProperty().bind(
                Bindings.createDoubleBinding(() -> this.xProperty().get() + r,
                        this.xProperty()));
    }

    public void setjaGildru(Leikbord b) {
        b.getChildren().remove(this);
        setX(rand.nextInt((int) (b.getWidth() - getFitWidth())));
        setY(rand.nextInt((int) (b.getHeight() - getFitHeight())));
        b.getChildren().add(this);

    }
}

