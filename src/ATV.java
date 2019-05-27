class ATV extends Autovehicul implements ATVImpl {

    private String tip_teren;

    ATV (String id, int an_fabricatie, String brand, String model, String culoare, Motor motor, int putere, String tip_teren, int masa, float valoare) {

        super(id, an_fabricatie, brand, model, culoare, motor, putere, masa, valoare);
        this.numar_roti = 4;
        this.tip_teren = tip_teren;

    }

    public String getTipTeren(){ return this.tip_teren; }

    public void setTipTeren(String tip_teren){ this.tip_teren = tip_teren; }

}
