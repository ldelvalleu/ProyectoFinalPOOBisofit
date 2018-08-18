package proyectofinalui.ui;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        startApp();
    }

    public static void startApp() {
        try {
            UILogin ui = new UILogin();
            ui.setVisible(true);
        } catch (Exception e) {
            throw e;
        }
    }

}
