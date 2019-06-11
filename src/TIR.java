class TIR extends Autovehicul implements TIRImpl {

    private int masa_remorca;

    TIR(int an_fabricatie, String brand, String model, String culoare, Motor motor, int putere, int masa_remorca, int masa, float valoare) {

        super(an_fabricatie, brand, model, culoare, motor, putere, masa, valoare);
        this.numar_roti = 6;
        this.masa_remorca = masa_remorca;
    }

    public int getMasaRemorca(){ return this.masa_remorca; }

    public void setMasaRemorca(int masa_remorca){ this.masa_remorca = masa_remorca; }

}