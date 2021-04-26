package algoritma;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class algoritmaDDA extends JPanel {
    Scanner input = new Scanner(System.in);
    int x1,y1,x2,y2;

    public algoritmaDDA(){
        System.out.print("input x1 (x awal) = ");
        x1 = input.nextInt();
        System.out.print("input y1 (y awal) = ");
        y1 = input.nextInt();
        System.out.print("input x2 (x akhir) = ");
        x2 = input.nextInt();
        System.out.print("input y2 (y akhir) = ");
        y2 = input.nextInt();
        System.out.println("PROSES PERHITUNGAN");
        System.out.println("1. (X,Y) = "+"("+x1+","+y1+")");
        perhitunganGaris(x1, y1);

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
            System.out.println(i+". (X,Y) = "+"("+x_hasil+","+y_hasil+")");
            i++;
        }
    }

    @Override
    public void paintComponent(Graphics grs) {
        int jmlLangkah,i;
        float x_inc,y_inc;

        int dx = x2-x1;  //mencari jarak x2 dengan x1

        int dy = y2-y1; //mencari jarak y2 dengan y1

        //dibuat atau di casting menjadi float karena variabel akan menampung nilai desimal
        float x=x1;
        float y=y1;

        super.paintComponent(grs);  //menurunkan fungsi parent
        this.setBackground(Color.WHITE);  //warna background
        grs.setColor(Color.RED);  //warna garis

        //menentukan jumlah langkah untuk perulangan
        //apabila variabel adalah bilangan negatif maka diubah menjadi bilangan positif
        if(Math.abs(dx)>Math.abs(dy)){
            jmlLangkah = Math.abs(dx);
        }
        else{
            jmlLangkah = Math.abs(dy);
        }

        //menentukan pertambahan nilai tiap langkah
        x_inc = dx/(float)jmlLangkah;

        y_inc = dy/(float)jmlLangkah;

        //perulangan utk menggambar titik
        for(i=1;i<=jmlLangkah;i++) {
            //setiap langkah, x dan y akan mengalami pertambahan sesuai increment
            x += x_inc;
            y += y_inc;

            //menggambar atau mewarnai titik sesuai x dan y
            grs.drawRect(Math.round(x), Math.round(y), 1, 1);
        }
    }
}
