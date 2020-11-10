package model;

import java.time.LocalDate;
import java.util.*;

public class Dados {

    private LocalDate data;
    private double casosTotais;
    private double casosNovos;
    private double mortesTotais;
    private double novasMortes;
    private double novosTestes;
    private double totalTestes;
    private double populacao;
    private double numeroIdosos;
    private double mortesCardiovasculares;
    private double prevalenciaDiabetes;
    private double fumadoresFemininos;
    private double fumadoresMasculinos;
    private double camasHospitalPorMil;
    private double esperancaMediaDeVida;

    public Dados(String data, double casosTotais, double casosNovos, double mortesTotais, double novasMortes, double novosTestes, double totalTestes, double populacao, double numeroIdosos, double mortesCardiovasculares, double prevalenciaDiabetes, double fumadoresFemininos, double fumadoresMasculinos, double camasHospitalPorMil, double esperancaMediaDeVida) {
        this.data = LocalDate.parse(data);
        this.casosTotais = casosTotais;
        this.casosNovos = casosNovos;
        this.mortesTotais = mortesTotais;
        this.novasMortes = novasMortes;
        this.novosTestes = novosTestes;
        this.totalTestes = totalTestes;
        this.populacao = populacao;
        this.numeroIdosos = numeroIdosos;
        this.mortesCardiovasculares = mortesCardiovasculares;
        this.prevalenciaDiabetes = prevalenciaDiabetes;
        this.fumadoresFemininos = fumadoresFemininos;
        this.fumadoresMasculinos = fumadoresMasculinos;
        this.camasHospitalPorMil = camasHospitalPorMil;
        this.esperancaMediaDeVida = esperancaMediaDeVida;
    }

    public Dados(String data, double casosNovos, double novasMortes){
        this.data=LocalDate.parse(data);
        this.casosNovos=casosNovos;
        this.novasMortes=novasMortes;
    }

    public Dados(String data, double casosTotais){
        this.data = LocalDate.parse(data);
        this.casosTotais = casosTotais;
    }

    public Dados(String data) {
        this.data = LocalDate.parse(data);
    }

    public Dados(){}


    public boolean threasholdFumadores(){
        final double threashold = 70;
        return fumadoresFemininos + fumadoresMasculinos > threashold;
    }

    public Dados(double casosNovos, double novasMortes){
        this.casosNovos = casosNovos;
        this.novasMortes = novasMortes;
    }

    public Dados(double casosNovos){
        this.casosNovos=casosNovos;
    }

    public LocalDate getData() {
        return data;
    }

    public double getCasosTotais() {
        return casosTotais;
    }

    public double getCasosNovos() {
        return casosNovos;
    }

    public double getMortesTotais() {
        return mortesTotais;
    }

    public double getNovasMortes() {
        return novasMortes;
    }

    public double getNovosTestes() {
        return novosTestes;
    }

    public double getTotalTestes() {
        return totalTestes;
    }

    public double getPopulacao() {
        return populacao;
    }

    public double getNumeroIdosos() {
        return numeroIdosos;
    }

    public double getMortesCardiovasculares() {
        return mortesCardiovasculares;
    }

    public double getPrevalenciaDiabetes() {
        return prevalenciaDiabetes;
    }

    public double getFumadoresFemininos() {
        return fumadoresFemininos;
    }

    public double getFumadoresMasculinos() {
        return fumadoresMasculinos;
    }

    public double getCamasHospitalPorMil() {
        return camasHospitalPorMil;
    }

    public double getEsperancaMediaDeVida() {
        return esperancaMediaDeVida;
    }

    public void setCasosNovos(double casosNovos) {
        this.casosNovos = casosNovos;
    }

    public void setNovasMortes(double novasMortes) {
        this.novasMortes = novasMortes;
    }

    public void setFumadoresFemininos(double fumadoresFemininos) {
        this.fumadoresFemininos = fumadoresFemininos;
    }

    public void setFumadoresMasculinos(double fumadoresMasculinos) {
        this.fumadoresMasculinos = fumadoresMasculinos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dados dados = (Dados) o;
        return data.equals(dados.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, populacao);
    }

    @Override
    public String toString() {
        return "Dados{" +
                "data=" + data +
                ", casosTotais=" + casosTotais +
                ", casosNovos=" + casosNovos +
                ", mortesTotais=" + mortesTotais +
                ", novasMortes=" + novasMortes +
                ", novosTestes=" + novosTestes +
                ", totalTestes=" + totalTestes +
                ", populacao=" + populacao +
                ", numeroIdosos=" + numeroIdosos +
                ", mortesCardiovasculares=" + mortesCardiovasculares +
                ", prevalenciaDiabetes=" + prevalenciaDiabetes +
                ", fumadoresFemininos=" + fumadoresFemininos +
                ", fumadoresMasculinos=" + fumadoresMasculinos +
                ", camasHospitalPorMil=" + camasHospitalPorMil +
                ", esperancaMediaDeVida=" + esperancaMediaDeVida +
                '}';
    }
}
