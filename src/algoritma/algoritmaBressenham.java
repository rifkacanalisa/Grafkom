package algoritma;

import java.util.Scanner;

public class algoritmaBressenham {
    Scanner input = new Scanner(System.in);

    public void perhitunganGaris(){
        int x1,y1,x2,y2, dx, dy, p, x_new, y_new, i = 2;

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

        dx = x2 - x1;
        dy = y2 - y1;
        p = 2*dy - dx;
        x_new = x1;
        y_new = y1;
        do {
            x_new++;
            if(p<0){
                p = p+2*dy;
            } else {
                y_new++;
                p = p+2*dy-2*dx;
            }
            System.out.println(i+". (X,Y) = "+"("+x_new+","+y_new+")");
            i++;
        } while (x_new < x2 || y_new < y2);
    }

    public void perhitunganLingkaran(){
        int x,y,r,p, i=2;
        System.out.print("input r (jari-jari) = ");
        r = input.nextInt();
        x = 0;
        y = r;
        System.out.println("PROSES PERHITUNGAN (OKTAN 2)");
        System.out.println("1. (X,Y) = "+"("+x+","+y+")");

        p = Math.round(5 / 4 - r);
        do{
            x++;
            if(p<0){
                p = p+2*x+1;
            } else {
                y--;
                p = p+2*x+1-2*y;
            }
            System.out.println(i+". (X,Y) = "+"("+x+","+y+")");
            i++;
        } while (x < y);
    }

    public void perhitunganElips(){
        int rx2,ry2,rx,ry,p, i=2, x, y, pembandingX, pembandingY;
        // Rumus panjang '2Ry^2 * Xk+1' = pembandingX

        System.out.print("input rx (jari-jari x) = ");
        rx = input.nextInt();
        System.out.print("input ry (jari-jari y) = ");
        ry = input.nextInt();
        rx2 = (int) Math.pow(rx, 2);
        ry2 = (int) Math.pow(ry, 2);
        x = 0;
        y = ry;
        System.out.println("PROSES PERHITUNGAN (QUADRAN 1)");
        System.out.println("PROSES Bagian 1");
        System.out.println("1. (X,Y) = "+"("+x+","+y+")");

        p = ry2 - rx2 * ry + 1 / 4 * rx2;
        do {
            x++;
            if(p<0){
                pembandingX = 2 * ry2 * x;
                pembandingY = 2 * rx2 * y;
                p = p + pembandingX + ry2;
            } else {
                y--;
                pembandingX = 2 * ry2 * x;
                pembandingY = 2 * rx2 * y;
                p = p + pembandingX - pembandingY + ry2;
            }
            System.out.println(i+". (X,Y) = "+"("+x+","+y+")");
            i++;
        } while (pembandingX < pembandingY);

        i = 2;
        System.out.println("PROSES Bagian 2");
        System.out.println("1. (X,Y) = "+"("+x+","+y+")");
        float x0, y0, p1, xN;
        xN = (float) (x + 0.5);
        x0 = (float) Math.pow(xN, 2);
        y0 = (float) Math.pow((y-1), 2);
        p1 = ry2 * x0 + rx2 * y0 - rx2 * ry2;
        do {
            y--;
            if(p1>0){
                pembandingY = 2 * rx2 * y;
                p1 = p1 - pembandingY + rx2;
            } else {
                x++;
                pembandingX = 2 * ry2 * x;
                pembandingY = 2 * rx2 * y;
                p1 = p1 + pembandingX - pembandingY + rx2;
            }
            System.out.println(i+". (X,Y) = "+"("+x+","+y+")");
            i++;
        } while (y > 0);
    }
}
