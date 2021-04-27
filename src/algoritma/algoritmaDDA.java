package algoritma;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class algoritmaDDA extends JPanel {
    Scanner input = new Scanner(System.in);
    int x1,y1,x2,y2;

    public algoritmaDDA(){
        System.out.print("\ninput x1 (x awal) = ");
        x1 = input.nextInt();
        System.out.print("input y1 (y awal) = ");
        y1 = input.nextInt();
        System.out.print("input x2 (x akhir) = ");
        x2 = input.nextInt();
        System.out.print("input y2 (y akhir) = ");
        y2 = input.nextInt();
        System.out.println("PROSES PERHITUNGAN");
        System.out.println("1.\t(X,Y) =\t"+"("+x1+","+y1+")");
        perhitunganGaris(x1,y1);
    }

    public void perhitunganGaris(float x_new, float y_new){
        int step, i = 2, x_hasil, y_hasil;
        float dx, dy, x_inc, y_inc;

        dx = x2 - x1;
        dy = y2 - y1;
        if(Math.abs(dx) > Math.abs(dy)){
            step = (int) Math.abs(dx);
        } else {
            step = (int) Math.abs(dy);
        }
        x_inc = dx / step;
        y_inc = dy / step;

        for (int j = 0; j<step; j++){
            x_new = x_new + x_inc;
            y_new = y_new + y_inc;
            x_hasil = Math.round(x_new);
            y_hasil = Math.round(y_new);
            System.out.println(i+".\t(X,Y) =\t"+"("+x_hasil+","+y_hasil+")");
            i++;
        }
    }
}
