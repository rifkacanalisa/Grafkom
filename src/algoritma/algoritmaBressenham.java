package algoritma;

import java.util.Scanner;

public class algoritmaBressenham {
    Scanner input = new Scanner(System.in);

    public void perhitunganGaris(){
        int x1,y1,x2,y2, dx, dy, p, x_new, y_new, i = 2;
        String rumus;

        System.out.print("\ninput x1 (x awal) = ");
        x1 = input.nextInt();
        System.out.print("input y1 (y awal) = ");
        y1 = input.nextInt();
        System.out.print("input x2 (x akhir) = ");
        x2 = input.nextInt();
        System.out.print("input y2 (y akhir) = ");
        y2 = input.nextInt();
        System.out.println("\nPROSES PERHITUNGAN");
        System.out.print("1.\t(X,Y) =\t"+"("+x1+","+y1+")");

        dx = Math.abs(x2 - x1);
        dy = Math.abs(y2 - y1);
        x_new = x1;
        y_new = y1;
        if(y2 > y1){ //naik
            p = 2*dy - dx;
            System.out.println("\t\tp0\t= 2*dy - dx\t\t\t\tp0\t= "+p);
            do {
                x_new++;
                if(p<0){
                    p = p+2*dy;
                    rumus = "p"+(i-1)+"\t= p"+(i-2)+" + 2*dy\t\t";
                } else {
                    y_new++;
                    p = p+2*dy-2*dx;
                    rumus = "p"+(i-1)+"\t= p"+(i-2)+" + 2*dy - 2*dx";
                }
                System.out.println(i+".\t(X,Y) =\t"+"("+x_new+","+y_new+")\t\t"+rumus+"\t\tp"+(i-1)+"\t= "+p);
                i++;
            } while (x_new < x2 && y_new < y2);
        } else { // turun ke kanan
            p = 2*dx - dy;
            System.out.println("\t\tp0\t= 2*dx - dy\t\t\t\tp0\t= "+p);
            do {
                y_new--;
                if(p<0){
                    p = p+2*dx;
                    rumus = "p"+(i-1)+"\t= p"+(i-2)+" + 2*dx\t\t";
                } else {
                    x_new++;
                    p = p+2*dx-2*dy;
                    rumus = "p"+(i-1)+"\t= p"+(i-2)+" + 2*dx - 2*dy";
                }
                System.out.println(i+".\t(X,Y) =\t"+"("+x_new+","+y_new+")\t\t"+rumus+"\t\tp"+(i-1)+"\t= "+p);
                i++;
            } while (x_new < x2 && y_new < y2);
        }
    }

    public void perhitunganLingkaran(){
        int x,y,r,p, i=2;
        String rumus;
        System.out.print("input r (jari-jari) = ");
        r = input.nextInt();
        x = 0;
        y = r;
        System.out.println("\nPROSES PERHITUNGAN (OKTAN 2)");
        System.out.print("1.\t(X,Y) =\t"+"("+x+","+y+")");

        p = Math.round((float) (5 / 4) - r);
        System.out.println("\t\tp0\t= 5/4 - r\t\t\t\t\tp0\t= "+p);
        do{
            x++;
            if(p<0){
                p = p+2*x+1;
                rumus = "p"+(i-1)+"\t= p"+(i-2)+" + 2*x + 1\t\t";
            } else {
                y--;
                p = p+2*x+1-2*y;
                rumus = "p"+(i-1)+"\t= p"+(i-2)+" + 2*x + 1 - 2*y";
            }
            System.out.println(i+".\t(X,Y) =\t"+"("+x+","+y+")\t\t"+rumus+"\t\tp"+(i-1)+"\t= "+p);
            i++;
        } while (x < y);
    }

    public void perhitunganElips(){
        int rx2,ry2,rx,ry, i=2, x, y, pembandingX, pembandingY;
        float p;
        String rumus;
        // Rumus panjang '2Ry^2 * Xk+1' = pembandingX

        System.out.print("input rx (jari-jari x) = ");
        rx = input.nextInt();
        System.out.print("input ry (jari-jari y) = ");
        ry = input.nextInt();
        rx2 = (int) Math.pow(rx, 2);
        ry2 = (int) Math.pow(ry, 2);
        x = 0;
        y = ry;
        System.out.println("\tPROSES PERHITUNGAN (QUADRAN 1)");
        System.out.println("PROSES Bagian 1");
        System.out.print("1.\t(X,Y) =\t"+"("+x+","+y+")");

        p = (float) (ry2 - rx2 * ry + 0.25 * rx2);
        System.out.println("\t\tp0\t= ry^2 - rx^2*ry + 1/4*rx^2\t\t\t\tp0\t= "+p);
        do {
            x++;
            if(p<0){
                pembandingX = 2 * ry2 * x;
                pembandingY = 2 * rx2 * y;
                p = p + pembandingX + ry2;
                rumus = "p"+(i-1)+"\t= p"+(i-2)+" + 2*ry^2*x + ry^2\t\t\t";
            } else {
                y--;
                pembandingX = 2 * ry2 * x;
                pembandingY = 2 * rx2 * y;
                p = p + pembandingX - pembandingY + ry2;
                rumus = "p"+(i-1)+"\t= p"+(i-2)+" + 2*ry^2*x - 2*rx^2*y + ry^2";
            }
            System.out.println(i+".\t(X,Y) =\t"+"("+x+","+y+")\t\t"+rumus+"\t\tp"+(i-1)+"\t= "+p);
            i++;
        } while (pembandingX < pembandingY);

        i = 2;
        System.out.println("PROSES Bagian 2");
        System.out.print("1.\t(X,Y) =\t"+"("+x+","+y+")");
        float x0, y0, p1, xN;
        xN = (float) (x + 0.5);
        x0 = (float) Math.pow(xN, 2);
        y0 = (float) Math.pow((y-1), 2);
        p1 = ry2 * x0 + rx2 * y0 - rx2 * ry2;
        System.out.println("\t\tp0\t= ry^2*x0 + rx^2*y0 - rx^2*ry^2\t\t\tp0\t= "+p1);
        do {
            y--;
            if(p1>0){
                pembandingY = 2 * rx2 * y;
                p1 = p1 - pembandingY + rx2;
                rumus = "p"+(i-1)+"\t= p"+(i-2)+" + 2*rx^2*y + rx^2\t\t\t";
            } else {
                x++;
                pembandingX = 2 * ry2 * x;
                pembandingY = 2 * rx2 * y;
                p1 = p1 + pembandingX - pembandingY + rx2;
                rumus = "p"+(i-1)+"\t= p"+(i-2)+" + 2*ry^2*x - 2*rx^2*y + rx^2";
            }
            System.out.println(i+".\t(X,Y) =\t"+"("+x+","+y+")\t\t"+rumus+"\t\tp"+(i-1)+"\t= "+p1);
            i++;
        } while (y > 0);
    }
}
