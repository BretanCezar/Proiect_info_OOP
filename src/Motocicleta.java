class Motocicleta extends Autovehicul implements MotocicletaImpl {

    private String clasa;

    Motocicleta(int an_fabricatie, String brand, String model, String culoare, Motor motor, int putere, String clasa, int masa, float valoare) {

        super(an_fabricatie, brand, model, culoare, motor, putere, masa, valoare);
        this.numar_roti = 2;
        this.clasa = clasa;

    }

    public String getClasa(){ return this.clasa; }

    public void setClasa(String clasa){ this.clasa = clasa; }

}
