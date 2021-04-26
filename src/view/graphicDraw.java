package view;

import javax.swing.*;
import java.awt.*;

public class graphicDraw extends JPanel {

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        this.setBackground(Color.white);

        Graphics2D graphics2D = (Graphics2D) g;
    }
}
