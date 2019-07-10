package com.dts.aplikasikalkulatorbmi.models;

public class ItemResult {
    String label="", hasil="";

    public ItemResult(String label, String hasil) {
        this.label = label;
        this.hasil = hasil;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getHasil() {
        return hasil;
    }

    public void setHasil(String hasil) {
        this.hasil = hasil;
    }
}
