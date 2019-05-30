public class Autovehicul implements AutovehiculImpl {

    //PARAMETRII

    private int an_fabricatie;
    private int putere;
    private int masa;
    protected int numar_roti;
    private float valoare;
    private Motor motor;
    protected String id;
    private String brand;
    private String model;
    private String culoare;

    //CONSTRUCTOR

    Autovehicul(String id, int an_fabricatie, String brand, String model, String culoare, Motor motor, int putere, int masa, float valoare){
        this.id = id;
        this.an_fabricatie = an_fabricatie;
        this.brand = brand;
        this.putere = putere;
        this.masa = masa;
        this.valoare = valoare;
        this.model = model;
        this.culoare = culoare;
        this.motor = motor;
    }

    //GETTERS

    public String getId(){ return this.id; }
    public int getAnFabricatie(){ return this.an_fabricatie; }
    public int getPutere(){ return this.putere; }
    public int getMasa(){ return this.masa; }
    public float getValoare(){ return this.valoare; }
    public String getConfig(){ return this.motor.config; }
    public int getNrCilindrii(){ return this.motor.nr_cilindrii; }
    public float getCapacitate(){ return this.motor.capacitate; }
    public String getNumeBrand(){ return this.brand; }
    public String getModel(){ return this.model; }
    public String getCuloare(){ return this.culoare; }
    public int getNumarRoti(){ return this.numar_roti; }

    //SETTERS

    public void setId(String id){ this.id = id; }
    public void setAnFabricatie(int an_fabricatie){ this.an_fabricatie = an_fabricatie; }
    public void setPutere(int putere){ this.putere = putere; }
    public void setMasa(int masa){ this.masa = masa; }
    public void setValoare(float valoare){ this.valoare = valoare; }
    public void setConfig(String config){ this.motor.config = config; }
    public void setNrCilindrii(int nr_cilindrii){ this.motor.nr_cilindrii = nr_cilindrii; }
    public void setCapacitate(float capacitate){ this.motor.capacitate = capacitate; }
    public void setNumeBrand(String denumire){ this.brand = denumire; }
    public void setModel(String model){ this.model = model; }
    public void setCuloare(String culoare){ this.culoare = culoare; }

    public float valoareRelativa (Autovehicul a){

        return this.valoare - a.valoare;
    }

}

class Motor {

    String config;
    int nr_cilindrii;
    float capacitate;
}

class FrecvCuloare {

    int rosu;
    int portocaliu;
    int galben;
    int verde;
    int albastru;
    int mov;
    int argintiu;
    int maro;
    int negru;
    int alb;

}

