import algoritma.algoritmaBressenham;
import algoritma.algoritmaDDA;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        String ;
        int x,y, pilihObjek, pilihAlgoritma;

        Scanner input = new Scanner(System.in);
        System.out.println("Pilih Bentuk Objek : \n1. Garis\n2. Lingkaran\n3. Ellips\n");
        System.out.print("Pilihan : ");
        pilihObjek = input.nextInt();

        algoritmaBressenham bressenham = new algoritmaBressenham();
        if(pilihObjek == 1){
            System.out.println("Pilih Algoritma : \n1. DDA\n2. Bressenham");
            System.out.print("Pilihan : ");
            pilihAlgoritma = input.nextInt();

            if(pilihAlgoritma == 1){
                algoritmaDDA algoritmaDDA = new algoritmaDDA();
            } else {
                bressenham.perhitunganGaris();
            }
        }
        else if(pilihObjek == 2){
            bressenham.perhitunganLingkaran();
        } else if(pilihObjek == 3){
            bressenham.perhitunganElips();
        }
//        viewDrawing viewDrawing = new viewDrawing();

    }
}
