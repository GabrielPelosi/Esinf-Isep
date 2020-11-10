package model;

import java.util.Objects;

public class Pais {

    private String sigla;
    private String nome;
    private String continente;
    private final String NOME_POR_OMISSAO = "NOME_NAO_ESPECIFICADO";
    private final String CONTIENTE_POR_OMISSAO = "CONTINENTE_NAO_ESPECIFICADO";

    public Pais(String sigla, String continente, String nome){
        this.sigla = sigla;
        this.continente = continente;
        this.nome = nome;
    }

    public Pais(String sigla, String nome){
        this.sigla = sigla;
        this.nome = nome;
    }

    public Pais(String sigla){
        this.sigla = sigla;
        this.nome = NOME_POR_OMISSAO;
        this.continente = CONTIENTE_POR_OMISSAO;
    }

    public String getSigla() {
        return sigla;
    }

    public String getNome() {
        return nome;
    }

    public String getContinente() {
        return continente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pais pais = (Pais) o;
        return sigla.equals(pais.sigla);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sigla);
    }

    @Override
    public String toString() {
        return sigla + " " + continente + " " + nome + "\n";
    }
}
