package model;

import java.util.Comparator;
import java.util.Objects;

public class ContinenteMes implements Comparable<ContinenteMes> {
   private String continente;
   private int mes;

    public ContinenteMes(String continente, int mes) {
        this.continente = continente;
        this.mes = mes;
    }

    public String getContinente() {
        return continente;
    }

    public int getMes() {
        return mes;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContinenteMes that = (ContinenteMes) o;
        return mes == that.mes &&
                continente.equals(that.continente);
    }


    @Override
    public int hashCode() {
        return Objects.hash(continente, mes);
    }

    @Override
    public int compareTo(ContinenteMes continenteMes) {
        if (this.continente.compareToIgnoreCase(continenteMes.continente) == 0)
            return Integer.compare(this.mes,continenteMes.mes);
        else
            return (this.continente.compareToIgnoreCase(continenteMes.continente));
    }

    @Override
    public String toString() {
        return "ContinenteMes{" +
                "continente='" + continente + '\'' +
                ", mes=" + mes +
                '}';
    }
}
