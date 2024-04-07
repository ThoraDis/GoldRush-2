package is.vidmot;

/**
 * @author Almas Baimagambetov (almaslvl@gmail.com)
 */
public enum View {
    MAINMENU("mainmenu-view.fxml"),
    LEIKUR("goldrush-view.fxml");


    private final String fileName;

    View(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}