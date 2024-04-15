package is.vidmot;
/******************************************************************************
 *  Nafn    : Ebba Þóra Hvannberg
 *  T-póstur: ebba@hi.is
 *  Viðmótsforritun 2024
 *
 *  Viðmótsklasi fyrir gullgrafara. Er Rectangle
 *  Grafari hefur stefnu og veit hvað hann fer hratt
 *
 *****************************************************************************/

import javafx.beans.binding.Bindings;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class Grafari extends ImageView {
    // fastar
    private static final double HRATT = 15;
    private final double hradi = HRATT; // hve hratt fer grafarinn
    private int stefna; // í hvaða stefnu fer grafarinn

    /**
     * Smiður les inn notendaviðmót og setur stefnuna niður
     */
    public Grafari() {
        FXML_Lestur.lesa(this, "grafari-view.fxml");
        setLayoutX(getImage().getWidth() / 20);
        setLayoutY(getImage().getHeight() / 20);
        bindaVidClip();
    }

    // Bindur grafara við clip
    private void bindaVidClip() {
        double r = ((Rectangle) getClip()).getWidth();
        double r2 = ((Rectangle) getClip()).getHeight();
        ((Rectangle) getClip()).heightProperty().bind(
                Bindings.createDoubleBinding(() -> this.yProperty().get() + r2,
                        this.yProperty()));
        ((Rectangle) getClip()).widthProperty().bind(
                Bindings.createDoubleBinding(() -> this.xProperty().get() + r,
                        this.xProperty()));
    }


    /**
     * Boltinn færist áfram. Ef komið er að vinstri jaðrinum kemstu ekki lengra. Ef komið er að hægri jaðrinum
     * ferðu hringinn að vinstri jaðrinum. Sama með efri og neðri jaðarinn
     */
    public void afram() {
        Leikbord parent = (Leikbord) this.getParent();
        setX((int) (getX() < 0 || getX() > parent.getWidth() ? 0 : getX() + Math.cos(Math.toRadians(getStefna())) * hradi) % (parent.getWidth() - getImage().getWidth()));
        setY((int) (getY() < getImage().getHeight() || getY() > parent.getHeight() ? getImage().getHeight() : getY() - Math.sin(Math.toRadians(getStefna())) * hradi) % (parent.getHeight() - getImage().getHeight()));
    }

    // get og set aðferðir

    private double getStefna() {
        return stefna;
    }

    public void setStefna(int gradur) {
        this.stefna = gradur;
    }

    public boolean snertirGildru(Gildra r) {
        return getBoundsInParent().intersects(r.getBoundsInParent());
    }
}
