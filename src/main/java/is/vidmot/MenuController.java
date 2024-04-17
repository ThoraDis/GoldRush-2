package is.vidmot;
/******************************************************************************
 *  Nafn    : Ebba Þóra Hvannberg
 *  T-póstur: ebba@hi.is
 *
 *  Viðmótsforritun 2024
 *  Stýring fyrir valmynd
 *
 *  Getur hafið nýjan leik, sett erfiðleikastig og spurt um forritið
 *
 *****************************************************************************/

import is.vinnsla.Geyma;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import javafx.scene.control.RadioButton;


public class MenuController {
    // fastar

    public static final String UMFORRIT = "Örvatakkar til að hreyfa sig. Leikurinn snýst um að safna eins miklu gulli og hægt er áður en tíminn lýkur. Ekki stíga í gildrurnar því þá missir þú stig.";

    private GoldController goldController = new GoldController();  // tenging í aðalcontroller

    private GoldControllerTveir goldControllerTveir = new GoldControllerTveir();

    private final Leikbord leikbord = new Leikbord();

    public int leikmenn = 1;

    public int erfidleikastig = 1;


    /**
     * Setur erfiðleikastig - létt, miðlungs erfitt
     *
     * @param actionEvent
     */
    public void onErfidleikastig(ActionEvent actionEvent) {
        goldController.setErfidleikastig
                (Integer.parseInt(((RadioMenuItem) actionEvent.getSource()).getId()));
        goldControllerTveir.setErfidleikastig
                (Integer.parseInt(((RadioMenuItem) actionEvent.getSource()).getId()));
    }

    /**
     * Hefur nýjan leik
     *
     * @param actionEvent
     */
    public void onNyrLeikur(ActionEvent actionEvent) {

        if (Geyma.getLeikmenn() == 2) {
            goldControllerTveir.hefjaLeik();
            goldControllerTveir.raesaKlukku();
        } else {
            goldController.hefjaLeik();
            goldController.raesaKlukku();
        }
    }

    /**
     * Hættir í forriti
     *
     * @param actionEvent
     */
    public void onHaetta(ActionEvent actionEvent) {

        System.exit(0);

    }

    public void onTilBaka(ActionEvent actionEvent) {

        ViewSwitcher.switchTo(View.MAINMENU, true);
        goldController.setOn(false);
        goldController.stoppaLagid();
        goldController.stoppaTimalinu();
    }


    /**
     * Veitir upplýsingar um forritið
     *
     * @param actionEvent
     */
    public void onUmForritid(ActionEvent actionEvent) {
        ButtonType buttonType = new ButtonType("Ég skil", ButtonBar.ButtonData.OK_DONE);

        Alert alert = new Alert(Alert.AlertType.INFORMATION, UMFORRIT, buttonType);
        alert.showAndWait();
    }

    // set aðferðir

    public void setController(GoldController goldController) {
        this.goldController = goldController;
    }


    public void setController(GoldControllerTveir goldController) {
        this.goldControllerTveir = goldController;
    }


    /**
     * Stillir gamemode
     *
     * @param actionEvent
     */


    public void onLeikmenn(ActionEvent actionEvent) {
        leikmenn = Integer.parseInt(((RadioButton) actionEvent.getSource()).getId());
        Geyma.setLeikmenn(leikmenn);
    }

    /**
     * Stillir erfiðleikastig fyrir leik
     *
     * @param actionEvent
     */


    public void mainMenuErfidleikastig(ActionEvent actionEvent) {
        erfidleikastig = Integer.parseInt(((RadioButton) actionEvent.getSource()).getId());

        Geyma.setErfidleikastig(erfidleikastig);
    }


    /**
     * Birtir tilsvarandi leikborð eftir völdnu gamemode
     *
     * @param actionEvent
     */

    public void birtaLeikbord(ActionEvent actionEvent) {

        if (leikmenn == 1) {
            ViewSwitcher.switchTo(View.LEIKUREINN, false);
        }
        if (leikmenn == 2) {
            ViewSwitcher.switchTo(View.LEIKURTVEIR, false);
        }


    }
}
