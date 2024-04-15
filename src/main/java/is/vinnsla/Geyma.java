package is.vinnsla;

/**
 * Vinnslu klassi til að geyma og sækja erfiðleikastig og gamemode
 */

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
