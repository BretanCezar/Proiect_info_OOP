/*
    Pt. executare via CMD:

    > cd *path*\Proiect_info_OOP\out\production\proiect_info_oop
    > java Main

*/
import java.io.*;
import java.util.*;

public class Main {

    /// Functie afisare autovehicul : [Numar ocupat in parcare + 1]. AnFabricatie Brand Model
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

    @SuppressWarnings("ResultOfMethodCallIgnored")
    private static void clearScreen() {

        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.print('\n');
        System.out.print("Bun venit in parcarea dumneavoastra. Pentru a incepe, apasati ENTER.");
        System.out.print('\n');

        try {
            System.in.read();
        } catch (IOException e) {   /// Pune consola in asteptare pana este introdus un ENTER.
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
        System.out.print("5) Autovehiculele ce se afla ca valoare intre doua preturi x si y in $.");
        System.out.print('\n');
        System.out.print("6) Cate autovehicule au x roti.");
        System.out.print('\n');
        System.out.print("7) Autovehiculele cu cel mult x ani vechime.");
        System.out.print('\n');
        System.out.print("8) Autovehiculele cu masa cel mult x.");
        System.out.print('\n');
        System.out.print("9) Autovehiculele au configuratia motorului x");
        System.out.print('\n');
        System.out.print("10) Autovehiculele care au capacitatea cilindrica cel mult x");
        System.out.print('\n');
        System.out.print("11) Numarul autovehiculelor de fiecare tip");
        System.out.print('\n');
        System.out.print("12) Valoarea totala a autovehiculelor din parcare");
        System.out.print('\n');
        System.out.print("13) Sedanurile cu tractiune de tip x");
        System.out.print('\n');
        System.out.print("14) TIRurile cu masa remorcii cel mult x");
        System.out.print('\n');
        System.out.print("15) ATVurile de teren de tip x");
        System.out.print('\n');
        System.out.print("16) Motocicletele de clasa x");
        System.out.print('\n');
    }

    /// FUNCTII APELABILE IN INTERFATA CONSOLEI

    /// 1. Afiseaza toate autovehiculele
    private static void toate_autovehiculele(int n, ArrayList<Autovehicul> p){

        for (int i = 0; i < n; i++) {

            afisare(i, p);
        }
    }

    /// 2. Afiseaza cea mai frecventa culoare din parcare si cate autovehicule o au
    private static void cea_mai_folosita_culoare(int n, ArrayList<Autovehicul> p) {

        FrecvCuloare fr = new FrecvCuloare(); // Structura ce retine de cate ori apare fiecare culoare
        for (int i = 0; i < n; i++) { // Se formeaza frecventa fiecarei culori

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

        // Se determina culoarea cea mai frecventa si frecventa ei
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
            max = "Galben";
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

    /// 3. Afiseaza autovehiculele cu puterea lor cel putin <cai> si puterea lor
    private static void autovehicule_putere_min(int cai, int n, ArrayList<Autovehicul> p){

        System.out.print('\n');
        for(int i = 0; i < n; i++){

            if(p.get(i).getPutere() >= cai) {

                System.out.print(p.get(i).getPutere());
                System.out.print(" CP - ");
                afisare(i, p);
            }
        }
    }

    /// 4. Afiseaza autovehiculele de brand <br>
    private static void autovehicule_brand(String br, int n, ArrayList<Autovehicul> p){

        System.out.print('\n');
        for(int i = 0; i < n; i++){

            if(p.get(i).getNumeBrand().equals(br)) afisare(i, p);
        }
    }

    /// 5. Afiseaza autovehiculele cu valoarea cel putin <st> si cel mult <dr>
    private static void autovehicule_in_price_range(float st, float dr, int n, ArrayList<Autovehicul> p){

        System.out.print('\n');
        for(int i = 0; i < n; i++) {

            if(p.get(i).getValoare() <= dr && p.get(i).getValoare() >= st) {

                System.out.print(p.get(i).getValoare());
                System.out.print(" $ - ");
                afisare(i, p);
            }
        }
    }

    /// 6. Afiseaza numarul autovehiculelor cu <r> roti
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

    /// 7. Afiseaza autovehiculele de vechime cel mult <v>
    private static void autovehicule_de_vechime_max(int v, int n, ArrayList<Autovehicul> p) {

        System.out.print('\n');
        for(int i = 0; i < n; i++) {

            if(2019 - p.get(i).getAnFabricatie() <= v) afisare(i, p);
        }
    }

    /// 8. Afiseaza autovehiculele cu masa cel mult <m>
    private static void autovehicule_de_masa_max(int m, int n, ArrayList<Autovehicul> p) {

        System.out.print('\n');
        for(int i = 0; i < n; i++){

            if(p.get(i).getMasa() <= m){

                System.out.print(p.get(i).getMasa());
                System.out.print(" kg - ");
                afisare(i, p);
            }
        }
    }

    /// 9. Afiseaza configuratia si nr de cilindrii ale autovehiculelor cu configuratia <c>
    private static void autovehicule_de_config_motor(String c, int n, ArrayList<Autovehicul> p){

        for(int i = 0; i < n; i++){

            if(p.get(i).getConfig().equals(c)){

                System.out.print(p.get(i).getConfig());
                System.out.print(p.get(i).getNrCilindrii());
                System.out.print(" - ");
                afisare(i, p);
            }
        }
    }

    /// 10. Afiseaza autovehiculele cu capacitatea cilindrica cel mult <c>
    private static void autovehicule_de_capacit_max(float c, int n, ArrayList<Autovehicul> p){

        for(int i = 0; i < n; i++){

            if(p.get(i).getCapacitate() <= c){

                System.out.print(p.get(i).getCapacitate());
                System.out.print(" L - ");
                afisare(i, p);
            }
        }
    }

    /// 11. Afiseaza numarul sedanurilor, TIRurilor, ATVurilor si Motocicletelor
    private static void nr_autovehicule_de_fiecare_tip(int n, ArrayList<Autovehicul> p){

        int nrs = 0, nrt = 0, nra = 0, nrm = 0;
        for(int i = 0; i < n; i++){

            switch (p.get(i).getClass().toString()){  // Switch ce verifica carei subclase apartine obiectul de pe pozitia <i>
                                                      // Metoda predefinita .getClass() obtine subclasa careia apartine unui obiect de pe pozitia <i>,
                                                      // iar .toString() transpune denumirea acesteia in data de tip String sub forma "class [denumire_subclasa]"

                case("class Sedan"): { nrs++; break; }
                case("class TIR"): { nrt++; break; }
                case("class ATV"): { nra++; break; }
                case("class Motocicleta"): { nrm++; break; }
            }
        }
        System.out.print("Sedanuri: ");
        System.out.print(nrs);
        System.out.print('\n');
        System.out.print("TIRuri: ");
        System.out.print(nrt);
        System.out.print('\n');
        System.out.print("ATVuri: ");
        System.out.print(nra);
        System.out.print('\n');
        System.out.print("Motociclete: ");
        System.out.print(nrm);
        System.out.print('\n');
    }

    /// 12. Afiseaza suma tuturor valorilor autovehiculelor
    private static void valoare_totala_parcare(int n, ArrayList<Autovehicul> p){

        long sum = 0;
        for(int i = 0; i < n; i++){

            sum += p.get(i).getValoare();
        }
        System.out.print("Valoarea totala a autovehiculelor din parcare: ");
        System.out.print(sum);
        System.out.print(" $");
        System.out.print('\n');
    }

    /// 13. Afiseaza sedanurile cu tractiune de tip <tr>
    private static void sedanuri_cu_tractiune(String tr, int n, ArrayList<Autovehicul> p){

        System.out.print('\n');
        for(int i = 0; i < n; i++){

            if(p.get(i).getClass() == Sedan.class){

                Sedan s = (Sedan) p.get(i);
                if(s.getTractiune().equals(tr)) afisare(i, p);
            }
        }
    }

    /// 14. Afiseaza TIRurile cu masa remorcii cel mult <m>
    private static void tiruri_cu_masa_remorcii_max(int m, int n, ArrayList<Autovehicul> p){

        System.out.print('\n');
        for(int i = 0; i < n; i++){

            if(p.get(i).getClass() == TIR.class){

                TIR t = (TIR) p.get(i);
                System.out.print(t.getMasaRemorca());
                System.out.print(" kg - ");
                if(t.getMasaRemorca() <= m) afisare(i, p);
            }
        }
    }

    /// 15. Afiseaza ATVurile de teren de tip <t>
    private static void atvuri_de_tip_teren(String t, int n, ArrayList<Autovehicul> p){

        System.out.print('\n');
        for(int i = 0; i < n; i++){

            if(p.get(i).getClass() == ATV.class){

                ATV a = (ATV) p.get(i);
                if(a.getTipTeren().equals(t)) afisare(i, p);
            }
        }
    }

    /// 16. Afiseaza motocicletele de clasa <c>
    private static void motociclete_de_clasa(String c, int n, ArrayList<Autovehicul> p){

        System.out.print('\n');
        for(int i = 0; i < n; i++){

            if(p.get(i).getClass() == Motocicleta.class){

                Motocicleta m = (Motocicleta) p.get(i);
                if(m.getClasa().equals(c)) afisare(i, p);
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        File input = new File("D:\\Proiecte info\\Proiect_info_OOP\\Proiect_info_OOP\\src\\parcare.txt"); // Se declara fisierul din care se citesc autovehiculele,
                                                                                                                          // specificandu-se PATH-ul
        // D:\\Documentz\\Cool info stuff\\Proiect_info_OOP\\Proiect_info_OOP\\src\\parcare.txt
        Scanner sc = new Scanner(input); // Se declara cititorul de fisier, numit Scanner


        /*
        MOD CITIRE:

        ['TIP'] AN "BRAND" "MODEL" "CULOARE" 'CONFIG' NR_CILINDRII CAPACITATE PUTERE CUTIE_VITEZE ["PARAMETRU_SPECIFIC"] MASA VALOARE

        ['TIP'] -> Se scrie S/T/A/M, in functie de subclasa autovehiculului ce urmeaza sa fie citit

        ["PARAMETRU_SPECIFIC"] -> Se scrie tractiune/masa_remorca/tip_teren/clasa

        */

        /// CITIRE DATE FISIER

        int nrVehicule = sc.nextInt(); // Se citeste numarul de vehicule
        ArrayList<Autovehicul> parcare = new ArrayList<>(nrVehicule); // Tablou care retine toate obiectele de tip Autovehicul, indiferent carei subclasa apartin
        for (int i = 0; i < nrVehicule; i++) {

            String tip_curent = sc.next(); // Se citeste litera dinaintea autovehiculelor
            switch (tip_curent) { // Switch ce verifica care litera preceda autovehiculul curent, S = Sedan ; T = TIR ; A = ATV ; M = Motocicleta

                case ("S"): { // In cazul S, se instantiaza un Sedan si se introduce in tabloul parcare

                    // Citire parametrii
                    int an_fab = sc.nextInt();
                    String brand = sc.next();
                    String model = sc.next();
                    String culoare = sc.next();
                    Motor motor = new Motor();
                    motor.config = sc.next();
                    motor.nr_cilindrii = sc.nextInt();
                    motor.capacitate = sc.nextFloat();
                    int putere = sc.nextInt();
                    String tractiune = sc.next(); // Parametru specific : tractiune
                    int masa = sc.nextInt();
                    float val = sc.nextFloat();

                    Sedan sedan_curent = new Sedan(an_fab, brand, model, culoare, motor, putere, tractiune, masa, val); // instantiere
                    parcare.add(sedan_curent); // introducere in vector
                    break;
                }

                case ("T"): {  // In cazul T, se instantiaza un TIR si se introduce in tabloul parcare

                    // Citire parametrii
                    int an_fab = sc.nextInt();
                    String brand = sc.next();
                    String model = sc.next();
                    String culoare = sc.next();
                    Motor motor = new Motor();
                    motor.config = sc.next();
                    motor.nr_cilindrii = sc.nextInt();
                    motor.capacitate = sc.nextFloat();
                    int putere = sc.nextInt();
                    int masa_rem = sc.nextInt(); // Parametru specific : masa remorcii
                    int masa = sc.nextInt();
                    float val = sc.nextFloat();

                    TIR tir_curent = new TIR(an_fab, brand, model, culoare, motor, putere, masa_rem, masa, val); // instantiere
                    parcare.add(tir_curent); // introducere in vector
                    break;
                }

                case ("A"): {  // In cazul A, se instantiaza un ATV si se introduce in tabloul parcare

                    // Citire parametrii
                    int an_fab = sc.nextInt();
                    String brand = sc.next();
                    String model = sc.next();
                    String culoare = sc.next();
                    Motor motor = new Motor();
                    motor.config = sc.next();
                    motor.nr_cilindrii = sc.nextInt();
                    motor.capacitate = sc.nextFloat();
                    int putere = sc.nextInt();
                    String tip_teren = sc.next(); // Parametru specific : tip teren
                    int masa = sc.nextInt();
                    float val = sc.nextFloat();

                    ATV atv_curent = new ATV(an_fab, brand, model, culoare, motor, putere, tip_teren, masa, val); // instantiere
                    parcare.add(atv_curent); // introducere in vector
                    break;
                }

                case ("M"): {  // In cazul M, se instantiaza o Motocicleta si se introduce in tabloul parcare

                    // Citire parametrii
                    int an_fab = sc.nextInt();
                    String brand = sc.next();
                    String model = sc.next();
                    String culoare = sc.next();
                    Motor motor = new Motor();
                    motor.config = sc.next();
                    motor.nr_cilindrii = sc.nextInt();
                    motor.capacitate = sc.nextFloat();
                    int putere = sc.nextInt();
                    String clasa = sc.next(); // Parametru specific : clasa
                    int masa = sc.nextInt();
                    float val = sc.nextFloat();

                    Motocicleta moto_curent = new Motocicleta(an_fab, brand, model, culoare, motor, putere, clasa, masa, val); // instantiere
                    parcare.add(moto_curent); // introducere in vector
                    break;
                }
            }
        }

        Scanner cin = new Scanner(System.in); // Declarare cititor consola

        clearScreen(); // Afisare interfata de functii in consola

        int optiune;

        do {

            System.out.print('\n');
            System.out.print("Inserati numar comanda: ");

            optiune = cin.nextInt(); // citire numar comanda via consola

            switch (optiune){ // Switch ce verifica numarul comenzii

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
                    autovehicule_de_config_motor(c, nrVehicule, parcare);
                    break;
                }
                case(10):{

                    System.out.print('\n');
                    System.out.print("Capacitatea cilindrica maxima in litri: ");
                    float c = cin.nextFloat();
                    System.out.print('\n');
                    autovehicule_de_capacit_max(c, nrVehicule, parcare);
                    break;
                }
                case(11):{

                    System.out.print('\n');
                    nr_autovehicule_de_fiecare_tip(nrVehicule, parcare);
                    break;
                }
                case(12):{

                    System.out.print('\n');
                    valoare_totala_parcare(nrVehicule, parcare);
                    break;
                }
                case(13):{

                    System.out.print('\n');
                    System.out.print("Tip tractiune [FWD/RWD/AWD]: ");
                    String tr = cin.next();
                    sedanuri_cu_tractiune(tr, nrVehicule, parcare);
                    break;
                }
                case(14):{

                    System.out.print('\n');
                    System.out.print("Masa remorcii maxima: ");
                    int m = cin.nextInt();
                    tiruri_cu_masa_remorcii_max(m, nrVehicule, parcare);
                    break;
                }
                case(15):{

                    System.out.print('\n');
                    System.out.print("Tip teren [Tarmac/Offroad]: ");
                    String t = cin.next();
                    atvuri_de_tip_teren(t, nrVehicule, parcare);
                    break;
                }
                case(16):{

                    System.out.print('\n');
                    System.out.print("Clasa motociclete [Touring/Sport]: ");
                    String c = cin.next();
                    motociclete_de_clasa(c, nrVehicule, parcare);
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
