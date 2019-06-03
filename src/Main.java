/*
    Pt. executare via CMD:

    > cd *path*\Proiect_info_OOP\out\production\proiect_info_oop
    > java Main

 */
import java.io.*;
import java.util.*;

public class Main {

    /// Functie afisare autovehicul : AnFabricatie Brand Model
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

    /// Functie resetare consola si rescriere a interfetei
    public static void clearScreen() {

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.print('\n');
        System.out.print("Bun venit in parcarea dumneavoastra. Pentru a incepe, apasati ENTER.");
        System.out.print('\n');

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.print("Ce ati dori sa aflati? Pentru a termina programul, scrieti 0. Pentru a curata consola, scrieti -1.");
        System.out.print('\n');
        System.out.print('\n');
        System.out.print("1) Toate autovehiculele din parcare.");
        System.out.print('\n');
        System.out.print("2) Cea mai frecventa culoare.");
        System.out.print('\n');
        System.out.print("3) Autovehiculele care au puterea motorului de cel putin x cai putere.");
        System.out.print('\n');
        System.out.print("4) Autovehiculele de brand-ul x.");
        System.out.print('\n');
        System.out.print("5) Autovehiculele ce se afla ca valoare intre doua preturi x si y in €.");
        System.out.print('\n');
        System.out.print("6) Cate autovehicule au x roti.");
        System.out.print('\n');
        System.out.print("7) Autovehiculele cu cel mult x ani vechime.");
        System.out.print('\n');
        System.out.print("8) Autovehiculele cu masa maxima x.");
        System.out.print('\n');
        System.out.print("9) Cate autovehicule au configuratia motorului x");
        System.out.print('\n');
    }

    /// FUNCTII APELABILE IN INTERFATA CONSOLEI

    /// 1.
    private static void toate_autovehiculele(int n, ArrayList<Autovehicul> p){

        for (int i = 0; i < n; i++) {

            afisare(i, p);
        }
    }

    /// 2.
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
        System.out.print(contmax);
        System.out.print(" autovehicule de culoare ");
        System.out.print(max);
        System.out.print('\n');
    }

    /// 3.
    private static void autovehicule_putere_min(int cai, int n, ArrayList<Autovehicul> p){

        System.out.print('\n');
        for(int i = 0; i < n; i++){

            if(p.get(i).getPutere() >= cai) afisare(i, p);
        }
    }

    /// 4.
    private static void autovehicule_brand(String br, int n, ArrayList<Autovehicul> p){

        System.out.print('\n');
        for(int i = 0; i < n; i++){

            if(p.get(i).getNumeBrand().equals(br)) afisare(i, p);
        }
    }

    /// 5.
    private static void autovehicule_in_price_range(float st, float dr, int n, ArrayList<Autovehicul> p){

        System.out.print('\n');
        for(int i = 0; i < n; i++) {

            if(p.get(i).getValoare()<=dr && p.get(i).getValoare()>=st) afisare(i, p);
        }
    }

    /// 6.
    private static void nr_autovehicule_cu_roti(int r, int n, ArrayList<Autovehicul> p){

        int contor = 0;
        System.out.print('\n');
        for(int i = 0; i < n; i++){
            if(p.get(i).getNumarRoti() == r) contor++;

        }
        System.out.print(contor);
        System.out.print(" autovehicule");
        System.out.print('\n');
    }

    /// 7.
    private static void autovehicule_de_vechime_max(int v, int n, ArrayList<Autovehicul> p) {

        System.out.print('\n');
        for(int i = 0; i < n; i++) {

            if(2019 - p.get(i).getAnFabricatie() <= v) afisare(i, p);
        }
    }

    /// 8.
    private static void autovehicule_de_masa_max(int m, int n, ArrayList<Autovehicul> p) {

        System.out.print('\n');
        for(int i = 0; i < n; i++){

            if(p.get(i).getMasa() <= m) afisare(i, p);
        }
    }

    /// 9.
    private static void nr_autovehicule_de_config_motor(String c, int n, ArrayList<Autovehicul> p){

        int contor = 0;
        for(int i = 0; i < n; i++){

            if(p.get(i).getConfig().equals(c)) contor++;
        }
        System.out.print(contor);
        System.out.print(" autovehicule");
        System.out.print('\n');
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

        clearScreen();

        int optiune;

        do {

            System.out.print('\n');
            System.out.print("Inserati numar comanda: ");

            optiune = cin.nextInt();

            switch (optiune){

                case(-1):{

                    clearScreen();
                    break;
                }
                case(1):{

                    System.out.print('\n');
                    toate_autovehiculele(nrVehicule, parcare);
                    break;
                }
                case(2):{

                    System.out.print('\n');
                    cea_mai_folosita_culoare(nrVehicule, parcare);
                    break;
                }
                case(3):{

                    System.out.print('\n');
                    System.out.print("Puterea minima: ");
                    int min = cin.nextInt();
                    autovehicule_putere_min(min, nrVehicule, parcare);
                    break;
                }
                case(4):{

                    System.out.print('\n');
                    System.out.print("Brand: ");
                    String brand = cin.next();
                    autovehicule_brand(brand, nrVehicule, parcare);
                    break;
                }
                case(5):{

                    System.out.print('\n');
                    System.out.print("Valoarea minima si maxima: ");
                    float min = cin.nextInt();
                    float max = cin.nextInt();
                    autovehicule_in_price_range(min, max, nrVehicule, parcare);
                    break;
                }
                case(6):{

                    System.out.print('\n');
                    System.out.print("Numar roti: ");
                    int roti = cin.nextInt();
                    nr_autovehicule_cu_roti(roti, nrVehicule, parcare);
                    break;
                }
                case(7):{

                    System.out.print('\n');
                    System.out.print("Maxim ani vechime: ");
                    int ani = cin.nextInt();
                    autovehicule_de_vechime_max(ani, nrVehicule, parcare);
                    break;
                }
                case(8):{

                    System.out.print('\n');
                    System.out.print("Masa maxima: ");
                    int masa = cin.nextInt();
                    autovehicule_de_masa_max(masa, nrVehicule, parcare);
                    break;
                }
                case(9):{

                    System.out.print('\n');
                    System.out.print("Configuratie motor [L/V/W/B]: ");
                    String c = cin.next();
                    System.out.print('\n');
                    nr_autovehicule_de_config_motor(c, nrVehicule, parcare);
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
