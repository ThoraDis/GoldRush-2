package is.vidmot;
/******************************************************************************
 *  Nafn    : Arnaldur Ólafsson, Þóra Dís Garðarsdóttir
 *  T-póstur: aro42@hi.is, tdg5@hi.is
 *
 *  Viðmótsklasi fyrir Leikborð. Hefur grafara, gull og gildru. Er tengdur við leikinn.
 *  Er Framhlið fyrir vinnsluna, grafarann, gullið og gildrunar.
 *
 *  Framleiðir gull, færir grafara áfram, athuga hvort grafari grefur gull eða gildru, ákveður
 *  hvort á að framleiða meira gull eða gildru, spilar hljóð þegar grafið er gildru og gull
 *  Flest virkni er áframsend annað
 *****************************************************************************/

import is.vinnsla.Leikur;
import is.vidmot.Gull;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

public class Leikbord extends Pane {

    // viðmótshlutir
    @FXML
    private Grafari fxGrafari;  // Grafarinn

    private ObservableList<Gull> gullid = FXCollections.observableArrayList(); // gullið

    private ObservableList<Gildra> gildran = FXCollections.observableArrayList(); // gullið

    Sound sound = new Sound();

    // vinnslan
    private Leikur leikur;

    public Leikbord() {
        FXML_Lestur.lesa(this, "leikbord-view.fxml");
    }

    /**
     * Framleiðir gull
     */

    private void framleidaGull() {
        Gull g = new Gull();
        gullid.add(g);
        g.setjaGull(this);
    }

    /**
     * Framleiðir gildrur
     */
    private void framleidaGildru() {
        Gildra r = new Gildra();
        gildran.add(r);
        r.setjaGildru(this);
    }


    /**
     * Færir grafara áfram, athugar hvort hann grefur gull og hækkar stigin til samræmis
     */
    public void afram() {
        fxGrafari.afram();
        if (erGrefurGull()) {
            leikur.haekkaStigin();
            playSE(3);
        } else if (erStigurAGildru()) {
            leikur.laekkaStigin();
            playSE(1);
        }
    }

    /**
     * Athugar hvort grafari grefur gull og fjarlægir gullið af borðinu
     *
     * @return
     */
    private boolean erGrefurGull() {
        for (Gull g : gullid) {
            if (g.intersects(fxGrafari.getBoundsInParent())) {
                gullid.remove(g);
                getChildren().remove(g);
                return true;
            }
        }
        return false;
    }

    /**
     * Athugar hvort grafari grefur gull og fjarlægir gullið af borðinu
     *
     * @return
     */
    private boolean erStigurAGildru() {
        for (Gildra g : gildran) {
            if (g.intersects(fxGrafari.getBoundsInParent())) {
                gildran.remove(g);
                getChildren().remove(g);
                return true;
            }
        }
        return false;
    }

    /**
     * Ákveður hvort eigi að framleiða meira gull
     */
    public void meiraGull() {
        if (leikur.erMeiraGull()) {
            framleidaGull();
        }
    }


    public void geraGull() {
        framleidaGull();
    }

    /**
     * Ákveður hvort eigi að framleiða meiri gildrur MINN KLASSI!!!!!!!!!!!!!!
     */
    public void meiriGildrur() {
        if (leikur.erMeiriGildrur()) {
            framleidaGildru();
        }
    }


    public void playMusic(int i) {
        sound.setFile(i);
        sound.play();
        sound.loop();
    }

    public void stopMusic() {
        sound.stop();
    }

    public void playSE(int i) {
        sound.setFile(i);
        sound.play();
    }

    /**
     * Hefja nýjan leik. Allt gullið og allar gildrur tekin af borðinu
     */

    public void nyrLeikur() {
        getChildren().removeAll(gullid);
        gullid.removeAll();
        getChildren().removeAll(gildran);
        gildran.removeAll();
        leikur.nyrLeikur();
        fxGrafari.setX(10);
        fxGrafari.setY(10);
    }


    // set og get aðferðir
    public void setLeikur(Leikur leikur) {
        this.leikur = leikur;
    }

    public void setStefna(int gradur) {
        fxGrafari.setStefna(gradur);
    }

    /**
     * Hreinsa allt gull og allrar gildrur
     */
    public void clearGull() {
        for (Gull g : gullid) {
            getChildren().remove(g);
        }
        gullid.clear();

        for (Gildra g : gildran) {
            getChildren().remove(g);
        }
        gildran.clear();

    }
}
