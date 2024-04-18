package is.vidmot;

/******************************************************************************
 *  Nafn    : Arnaldur Ólafsson, Þóra Dís Garðarsdóttir
 *  T-póstur: aro42@hi.is, tdg5@hi.is
 *
 *  Lýsing  :  enum fyrir Stefnu grafara
 *****************************************************************************/
public enum Stefna {
    VINSTRI(180),
    HAEGRI(0),
    NIDUR (270),
    UP(90);

    private final int gradur;
    Stefna(int s) {
         gradur = s;
    }
    public int getGradur() {
        return gradur;
    }
}
