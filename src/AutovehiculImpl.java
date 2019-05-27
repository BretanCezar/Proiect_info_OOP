public interface AutovehiculImpl {


    int getAnFabricatie();
    int getPutere();
    int getMasa();
    int getNumarRoti();
    int getNrCilindrii();
    float getValoare();
    float getCapacitate();
    String getConfig();
    String getId();
    String getNumeBrand();
    String getModel();
    String getCuloare();

    void setAnFabricatie(int an_fabricatie);
    void setPutere(int putere);
    void setMasa(int masa);
    void setValoare(float valoare);
    void setConfig(String config);
    void setNrCilindrii(int nr_cilindrii);
    void setCapacitate(float capacitate);
    void setNumeBrand(String denumire);
    void setModel(String model);
    void setCuloare(String culoare);
    void setId(String id);

}
