package model;

public class PaisDia implements Comparable<PaisDia>{

    private String pais;

    private int dia;


    public PaisDia(String pais, int dia) {
        this.pais = pais;
        this.dia = dia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }


    @Override
    public int compareTo(PaisDia paisDia) {
        if (Integer.compare(this.dia,paisDia.dia) == 0)
            return this.pais.compareToIgnoreCase(paisDia.pais);
        else
            return Integer.compare(this.dia,paisDia.dia);
    }
}
