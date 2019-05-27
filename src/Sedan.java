class Sedan extends Autovehicul implements SedanImpl {

    private String tractiune;

    Sedan(String id, int an_fabricatie, String brand, String model, String culoare, Motor motor, int putere, String tractiune, int masa, float valoare) {

        super(id, an_fabricatie, brand, model, culoare, motor, putere, masa, valoare);
        this.numar_roti = 4;
        this.tractiune= tractiune;
    }

    public String getTractiune(){ return this.tractiune; }

    public void setTractiune(String tractiune){ this.tractiune = tractiune; }

}
