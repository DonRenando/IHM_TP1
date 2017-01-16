import fr.dgac.ivy.IvyException;

import javax.swing.*;

/**
 * Created by renando on 16/01/17.
 */
class Fenetre2 extends JFrame {
    private ivyTranslater monIvy;

    Fenetre2(MonPanel panel) {
        super("IHM fenetre 2");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        MonPanel panel1 = panel;
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
