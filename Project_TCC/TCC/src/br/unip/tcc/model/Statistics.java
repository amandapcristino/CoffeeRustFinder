package br.unip.tcc.model;

/** Class that contains the general statistics of the analysed images. */
public class Statistics {
    
    private int total = 0;
    private int infected = 0;
    private int uncertain = 0;
    private int healthy = 0;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getInfected() {
        return infected;
    }

    public void setInfected(int infected) {
        this.infected = infected;
    }

    public int getUncertain() {
        return uncertain;
    }

    public void setUncertain(int uncertain) {
        this.uncertain = uncertain;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }
}
