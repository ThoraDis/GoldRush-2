package is.vidmot;
/******************************************************************************
 *  Nafn    : Arnaldur Ólafsson, Þóra Dís Garðarsdóttir
 *  T-póstur: aro42@hi.is, tdg5@hi.is
 *
 *  Lýsing  :  Viðmótsklasi fyrir gullgrafara. Er Rectangle
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
     * Grafarinn færist og passar að grafarinn fer ekki af leikborðinu
     */
    public void afram() {
        Leikbord parent = (Leikbord) this.getParent();
        double newX = getX() + (Math.cos(Math.toRadians(getStefna()))) * hradi % (parent.getWidth() - getImage().getWidth());
        double newY = getY() - Math.sin(Math.toRadians(getStefna())) * hradi % (parent.getHeight() - getImage().getHeight());

        if (newX < 0) {
            newX = (parent.getWidth()) - (getImage().getWidth());

        } else if (newX > parent.getWidth()) {
            newX=0+getImage().getWidth();
        }

        setX(newX);

        if (newY < 0) {
            newY = (parent.getHeight()) - (getImage().getHeight());

        } else if (newY > parent.getHeight()) {
            newY=0+getImage().getHeight();
        }

        setY(newY);
    }

    // get og set aðferðir

    private double getStefna() {
        return stefna;
    }

    public void setStefna(int gradur) {
        this.stefna = gradur;
    }

}
