import java.io.*;
import java.util.*;

public class Main {

    static void afisare(int i, ArrayList<Autovehicul> p) {

        System.out.print(p.get(i).getAnFabricatie());
        System.out.print(" ");
        System.out.print(p.get(i).getNumeBrand());
        System.out.print(" ");
        System.out.print(p.get(i).getModel());
        System.out.print('\n');
    }

    static void nr_autovehicule_de_vechime_max(int v, int n, ArrayList<Autovehicul> p) {

        for(int i=0; i<n; i++) {

            if(2019-p.get(i).getAnFabricatie()<=v) afisare(i, p);
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

                    Sedan sedan_curent = new Sedan(an_fab, brand, model, culoare, motor, putere, tractiune, masa, val);
                    parcare.add(sedan_curent);
                    break;
                }
                case ("T"):{

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

                    TIR tir_curent = new TIR(an_fab, brand, model, culoare, motor, putere, masa_rem, masa, val);
                    parcare.add(tir_curent);
                    break;
                }
                case ("A"):{

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

                    ATV atv_curent = new ATV(an_fab, brand, model, culoare, motor, putere, tip_teren, masa, val);
                    parcare.add(atv_curent);
                    break;
                }
                case ("M"):{

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

                    Motocicleta moto_curent = new Motocicleta(an_fab, brand, model, culoare, motor, putere, clasa, masa, val);
                    parcare.add(moto_curent);
                    break;
                }
            }

        }

        nr_autovehicule_de_vechime_max(20, nrVehicule, parcare);


    }
}
