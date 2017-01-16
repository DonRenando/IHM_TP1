import fr.dgac.ivy.IvyException;

import javax.swing.*;

/**
 * Created by renando on 16/01/17.
 */
public class Fenetre2 extends JFrame {
    public ivyTranslater monIvy;
    private MonPanel panel;

    public Fenetre2(MonPanel panel) {
        super("IHM fenetre 2");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.panel = panel;
        panel.stroke = new Stroke();
        this.add(panel);

        try {
            this.monIvy = new ivyTranslater();
        } catch (IvyException e) {
            e.printStackTrace();
        }
        try {
            monIvy.recevoire(panel);
        } catch (IvyException e) {
            e.printStackTrace();
        }

        setSize(600, 600);
        setVisible(true);

    }
}
