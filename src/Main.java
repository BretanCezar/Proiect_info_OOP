import java.io.*;
import java.util.*;

public class Main {

    private static void afisare(int i, ArrayList<Autovehicul> p) {

        System.out.print(p.get(i).getAnFabricatie());
        System.out.print(" ");
        System.out.print(p.get(i).getNumeBrand());
        System.out.print(" ");
        System.out.print(p.get(i).getModel());
        System.out.print('\n');
    }

    private static void autovehicule_de_vechime_max(int v, int n, ArrayList<Autovehicul> p) {

        int contor = 0;
        for(int i=0; i<n; i++) {

            if (2019 - p.get(i).getAnFabricatie() <= v) {

                contor++;
                afisare(i, p);
            }
        }
        System.out.print(contor);
        System.out.print('\n');
    }

    private static void autovehicule_de_putere_min(int x, int n, ArrayList<Autovehicul> p){

        int contor = 0;
        for(int i=0; i<n; i++){

            if(p.get(i).getPutere() >= x) {
                contor++;
                afisare(i, p);
            }
        }
        System.out.print(contor);
        System.out.print('\n');
    }


    private static void cea_mai_folosita_culoare(int n, ArrayList<Autovehicul> p) {

        FrecvCuloare fr = new FrecvCuloare();
        for (int i = 0; i < n; i++) {

            switch (p.get(i).getCuloare()) {

                case ("Albastru"): {
                    fr.albastru++;
                    break;
                }
                case ("Argintiu"): {
                    fr.argintiu++;
                    break;
                }
                case ("Mov"): {
                    fr.mov++;
                    break;
                }
                case ("Galben"): {
                    fr.galben++;
                    break;
                }
                case ("Verde"): {
                    fr.verde++;
                    break;
                }
                case ("Negru"): {
                    fr.negru++;
                    break;
                }
                case ("Alb"): {
                    fr.alb++;
                    break;
                }
                case ("Portocaliu"): {
                    fr.portocaliu++;
                    break;
                }
                case ("Maro"): {
                    fr.maro++;
                    break;
                }
                case ("Rosu"): {
                    fr.rosu++;
                    break;
                }

            }
        }

        int contmax = 0;
        String max = "";

        if(fr.portocaliu > contmax){
            contmax = fr.portocaliu;
            max = "Portocaliu";
        }
        if(fr.alb > contmax){
            contmax = fr.alb;
            max = "Alb";
        }
        if(fr.maro > contmax){
            contmax = fr.maro;
            max = "Maro";
        }
        if(fr.galben > contmax){
            contmax = fr.galben;
            max = "Gaben";
        }
        if(fr.argintiu > contmax){
            contmax = fr.argintiu;
            max = "Argintiu";
        }
        if(fr.albastru > contmax){
            contmax = fr.albastru;
            max = "Albastru";
        }
        if(fr.mov > contmax){
            contmax = fr.mov;
            max = "Mov";
        }
        if(fr.negru > contmax){
            contmax = fr.negru;
            max = "Negru";
        }
        if(fr.rosu > contmax){
            contmax = fr.rosu;
            max = "Rosu";
        }
        if(fr.verde > contmax){
            contmax = fr.verde;
            max = "Verde";
        }
        System.out.print(max);
        System.out.print('\n');
    }

    static void nr_autovehicule_cu_roti(int r, int n, ArrayList<Autovehicul> p){

        int contor = 0;
        for(int i=0; i<n; i++){
            if(p.get(i).getNumarRoti() == r){
                contor++;
            }
        }
        System.out.print(contor);
        System.out.print('\n');
    }

    static void price_range(float st, float dr, int n, ArrayList<Autovehicul> p){

        for(int i=0; i<n; i++) {
            if(p.get(i).getValoare()<=dr && p.get(i).getValoare()>=st) afisare(i, p);

        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        File input = new File("D:\\Proiecte info\\Proiect_info_OOP\\Proiect_info_OOP\\src\\parcare.txt"); //Insert current input file path
        // D:\\Documentz\\Cool info stuff\\Proiect_info_OOP\\Proiect_info_OOP\\src\\parcare.txt
        Scanner sc = new Scanner(input);


        /*
        MOD CITIRE:

        ['TIP'] AN "BRAND" "MODEL" "CULOARE" 'CONFIG' NR_CILINDRII CAPACITATE PUTERE CUTIE_VITEZE ["PARAMETRU_SPECIFIC"] MASA VALOARE

        ['TIP'] -> Se scrie S/T/A/M, in functie de subclasa autovehiculului ce urmeaza sa fie citit

        ["PARAMETRU_SPECIFIC"] -> Se scrie tractiune/masa_remorca/tip_teren/clasa

        */

        int nrVehicule = sc.nextInt();
        ArrayList<Autovehicul> parcare = new ArrayList<>(nrVehicule);
        for(int i=0;i<nrVehicule;i++) {

            String tip_curent = sc.next();
            switch (tip_curent){
                case ("S"):{

                    String id = "S";
                    int an_fab = sc.nextInt();
                    String brand = sc.next();
                    String model = sc.next();
                    String culoare = sc.next();
                    Motor motor = new Motor();
                    motor.config = sc.next();
                    motor.nr_cilindrii = sc.nextInt();
                    motor.capacitate = sc.nextFloat();
                    int putere = sc.nextInt();
                    String tractiune = sc.next();
                    int masa = sc.nextInt();
                    float val = sc.nextFloat();

                    Sedan sedan_curent = new Sedan(id, an_fab, brand, model, culoare, motor, putere, tractiune, masa, val);
                    parcare.add(sedan_curent);
                    break;
                }
                case ("T"):{

                    String id = "T";
                    int an_fab = sc.nextInt();
                    String brand = sc.next();
                    String model = sc.next();
                    String culoare = sc.next();
                    Motor motor = new Motor();
                    motor.config = sc.next();
                    motor.nr_cilindrii = sc.nextInt();
                    motor.capacitate = sc.nextFloat();
                    int putere = sc.nextInt();
                    int masa_rem = sc.nextInt();
                    int masa = sc.nextInt();
                    float val = sc.nextFloat();

                    TIR tir_curent = new TIR(id, an_fab, brand, model, culoare, motor, putere, masa_rem, masa, val);
                    parcare.add(tir_curent);
                    break;
                }
                case ("A"):{

                    String id = "A";
                    int an_fab = sc.nextInt();
                    String brand = sc.next();
                    String model = sc.next();
                    String culoare = sc.next();
                    Motor motor = new Motor();
                    motor.config = sc.next();
                    motor.nr_cilindrii = sc.nextInt();
                    motor.capacitate = sc.nextFloat();
                    int putere = sc.nextInt();
                    String tip_teren = sc.next();
                    int masa = sc.nextInt();
                    float val = sc.nextFloat();

                    ATV atv_curent = new ATV(id, an_fab, brand, model, culoare, motor, putere, tip_teren, masa, val);
                    parcare.add(atv_curent);
                    break;
                }
                case ("M"):{

                    String id = "M";
                    int an_fab = sc.nextInt();
                    String brand = sc.next();
                    String model = sc.next();
                    String culoare = sc.next();
                    Motor motor = new Motor();
                    motor.config = sc.next();
                    motor.nr_cilindrii = sc.nextInt();
                    motor.capacitate = sc.nextFloat();
                    int putere = sc.nextInt();
                    String clasa = sc.next();
                    int masa = sc.nextInt();
                    float val = sc.nextFloat();

                    Motocicleta moto_curent = new Motocicleta(id, an_fab, brand, model, culoare, motor, putere, clasa, masa, val);
                    parcare.add(moto_curent);
                    break;
                }
            }

        }




    }
}
