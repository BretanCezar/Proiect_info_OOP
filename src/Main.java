import java.io.*;
import java.util.*;

public class Main {

    private static void afisare(int i, ArrayList<Autovehicul> p) {

        System.out.print(i+1);
        System.out.print(". ");
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

    private static void vehicule_de_putere_min(int cai, int n, ArrayList<Autovehicul> p){

        for(int i=0; i<n; i++){

            if(p.get(i).getPutere() >= cai) {
                afisare(i, p);
            }
        }
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
        String max = "muie";

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

    static void afisare_vehicule_brand(String br, int n, ArrayList<Autovehicul> p){

        for(int i=0;i<n;i++){

            if(p.get(i).getNumeBrand().equals(br)) afisare(i, p);
        }
    }



    public static void main(String[] args) throws FileNotFoundException {

        File input = new File("D:\\Documentz\\Cool info stuff\\Proiect_info_OOP\\Proiect_info_OOP\\src\\parcare.txt"); //Insert current input file path
        // D:\\Documentz\\Cool info stuff\\Proiect_info_OOP\\Proiect_info_OOP\\src\\parcare.txt
        Scanner sc = new Scanner(input);


        /*
        MOD CITIRE:

        ['TIP'] AN "BRAND" "MODEL" "CULOARE" 'CONFIG' NR_CILINDRII CAPACITATE PUTERE CUTIE_VITEZE ["PARAMETRU_SPECIFIC"] MASA VALOARE

        ['TIP'] -> Se scrie S/T/A/M, in functie de subclasa autovehiculului ce urmeaza sa fie citit

        ["PARAMETRU_SPECIFIC"] -> Se scrie tractiune/masa_remorca/tip_teren/clasa

        */

        /// CITIRE DATE FISIER

        int nrVehicule = sc.nextInt();
        ArrayList<Autovehicul> parcare = new ArrayList<>(nrVehicule);
        for (int i = 0; i < nrVehicule; i++) {

            String tip_curent = sc.next();
            switch (tip_curent) {
                case ("S"): {

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
                case ("T"): {

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
                case ("A"): {

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
                case ("M"): {

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

        Scanner cin = new Scanner(System.in);

        System.out.print("Bun venit in parcarea dumneavoastra. Pentru a incepe, apasati ENTER.");

        try {
            System.in.read();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print('\n');

        for (int i = 0; i < nrVehicule; i++) {

            System.out.print(i+1);
            System.out.print(". ");
            afisare(i, parcare);
        }
        System.out.print('\n');
        System.out.print("Ce ati dori sa aflati? Pentru a termina programul, apasati 0.");
        System.out.print('\n');
        System.out.print('\n');
        System.out.print("1) Cea mai folosita culoare.");
        System.out.print('\n');
        System.out.print("2) Ce masini au puterea motorului de cel putin x cai putere.");
        System.out.print('\n');
        System.out.print("3) Masinile de brand x.");
        System.out.print('\n');
        System.out.print("4) Masinile ce se afla ca valoare intre doua preturi alese de dumneavoastra in €.");
        System.out.print('\n');
        System.out.print("5) Cate autovehicule au x roti.");
        System.out.print('\n');
        System.out.print("6) Masinile cu cel mult x ani vechime.");
        System.out.print('\n');

        System.out.print('\n');

        int optiune;

        do {

            optiune = cin.nextInt();
            switch (optiune){

                case(1):{

                    cea_mai_folosita_culoare(nrVehicule, parcare);
                    break;
                }
                case(2):{

                    System.out.print("Puterea minima: ");
                    int min = cin.nextInt();
                    vehicule_de_putere_min(min, nrVehicule, parcare);
                    break;
                }
                case(3):{

                    System.out.print("Brand: ");
                    String brand = cin.next();
                    afisare_vehicule_brand(brand, nrVehicule, parcare);
                    break;
                }
                case(4):{

                    System.out.print("Valoarea minima si maxima: ");
                    float min = cin.nextInt();
                    float max = cin.nextInt();
                    price_range(min, max, nrVehicule, parcare);
                    break;
                }
                case(5):{

                    System.out.print("Numar roti: ");
                    int roti = cin.nextInt();
                    nr_autovehicule_cu_roti(roti, nrVehicule, parcare);
                    break;
                }
                case(6):{

                    System.out.print("Maxim ani vechime");
                    int ani = cin.nextInt();
                    autovehicule_de_vechime_max(ani, nrVehicule, parcare);
                    break;
                }

                default:{
                    cin.close();
                }
            }
        }
        while(optiune!=0);



    }


}
