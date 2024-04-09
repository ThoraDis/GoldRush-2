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
import is.vinnsla.Leikur;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.RadioButton;

import java.util.Optional;

public class MenuController {
    // fastar
    public static final String VILTU_HAETTA = "Viltu hætta? ";
    public static final String UMFORRIT = "Gullgrafari grefur gull og fær stig ";

    private GoldController goldController = new GoldController();  // tenging í aðalcontroller

    private  GoldControllerTveir goldControllerTveir = new GoldControllerTveir();

    public int leikmenn=1;


    /**
     * Setur erfiðleikastig - létt, miðlungs erfitt
     * @param actionEvent
     */
    public void onErfidleikastig(ActionEvent actionEvent) {
        goldController.setErfidleikastig
                (Integer.parseInt(((RadioMenuItem) actionEvent.getSource()).getId()));
    }

    /**
     * Hefur nýjan leik
     * @param actionEvent
     */
    public void onNyrLeikur(ActionEvent actionEvent) {

        if (leikmenn==1){
            goldController.hefjaLeik();
            goldController.raesaKlukku();
        } if (leikmenn==2){
            goldControllerTveir.hefjaLeik();
            goldControllerTveir.raesaKlukku();}
    }

    /**
     * Hættir í forriti
     * @param actionEvent
     */
    public void onHaetta(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.WARNING, VILTU_HAETTA);
        Optional<ButtonType> optional = alert.showAndWait();
        if (optional.isPresent() && optional.get().equals(ButtonType.OK)) {
            System.exit(0);
        }
    }


    /**
     * Veitir upplýsingar um forritið
     * @param actionEvent
     */
    public void onUmForritid(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION, UMFORRIT);
        alert.showAndWait();
    }

    // set aðferðir

    public void setController(GoldController goldController) {
        this.goldController = goldController;
    }

    public void setController(GoldControllerTveir goldController) {
        this.goldControllerTveir = goldController;
    }
    public void onLeikmenn(ActionEvent actionEvent) {
        RadioButton radioButton = (RadioButton) actionEvent.getSource();
        String radioButtonId = radioButton.getId();
        leikmenn= Integer.parseInt(radioButtonId);
    }

    public void mainMenuErfidleikastig(ActionEvent actionEvent){
        goldController.setErfidleikastig
                (Integer.parseInt(((RadioButton) actionEvent.getSource()).getId()));
    }

    public void birtaLeikbord(ActionEvent actionEvent){

        if (leikmenn==1){
            ViewSwitcher.switchTo(View.LEIKUREINN, true);
        }
        if (leikmenn==2){
            ViewSwitcher.switchTo(View.LEIKURTVEIR, true);
        }


    }
}
