package view;

import javax.swing.*;

public class viewDrawing extends JFrame {

    graphicDraw graphicDraw = new graphicDraw();

    public viewDrawing(){
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(graphicDraw);
        this.setVisible(true);
    }
}
