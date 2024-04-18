package is.vinnsla;

/********************************************************************
 *  Nafn    : Arnaldur Ólafsson, Þóra Dís Garðarsdóttir
 *  T-póstur: aro42@hi.is, tdg5@hi.is
 *
 * Lýsing  :  Vinnslu klassi til að geyma og sækja erfiðleikastig og gamemode
 ********************************************************************/

public class Geyma {

    static int leikmenn;
    static int erfidleikastig;

    /**
     *
     * Set og get aðferðir fyrir erfiðleikastig og gamemode
     */

    public static void setErfidleikastig(int eStig){
        erfidleikastig=eStig;
    }

    public static void setLeikmenn(int leikm){
        leikmenn=leikm;
    }

    public static int getLeikmenn(){
        return leikmenn;
    }

    public static int getErfidleikastig(){
        return erfidleikastig;
    }
}
