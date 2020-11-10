package controller;

import model.Dados;
import model.MapaFicheiro;
import model.Pais;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MapaFicheiroTest {

    @Test
    void carregarDados() {
    }

    @Test
    void criarPais() {
        LinkedList<String> l1 = new LinkedList<>();
        LinkedList<String> l2 = new LinkedList<>();
        LinkedList<String> l3 = new LinkedList<>();
        l1.add("AAA");
        l1.add("nome1");
        l1.add("continente1");
        l2.add("BBB");
        l2.add("nome2");
        l2.add("continente2");
        l3.add("CCC");
        l3.add("nome3");
        l3.add("continente3");
        Pais p1 = new Pais("AAA", "nome1", "continente1");
        Pais p2 = new Pais("BBB", "nome2", "continente2");
        Pais p3 = new Pais("CCC", "nome3", "continente3");
        Pais p4 = MapaFicheiro.criarPais(l1);
        Pais p5 = MapaFicheiro.criarPais(l2);
        Pais p6 = MapaFicheiro.criarPais(l3);

        assertEquals(p1.getSigla(), p4.getSigla());
        assertEquals(p1.getNome(), p4.getNome());
        assertEquals(p1.getContinente(), p4.getContinente());
        assertEquals(p2.getSigla(), p5.getSigla());
        assertEquals(p2.getNome(), p5.getNome());
        assertEquals(p2.getContinente(), p5.getContinente());
        assertEquals(p3.getSigla(), p6.getSigla());
        assertEquals(p3.getNome(), p6.getNome());
        assertEquals(p3.getContinente(), p6.getContinente());

    }

    @Test
    void criarDados() {
        LinkedList<String> l = new LinkedList<>();
        l.add("sigla");
        l.add("nome");
        l.add("continente");
        l.add("2012-12-10");
        l.add("1.0");
        l.add("2.0");
        l.add("3.0");
        l.add("4.0");
        l.add("5.0");
        l.add("6.0");
        l.add("7.0");
        l.add("8.0");
        l.add("9.0");
        l.add("10.0");
        l.add("11.0");
        l.add("12.0");
        l.add("13.0");
        l.add("14.0");
        l.add("15.0");
        Dados d1 = new Dados("2012-12-10", 1.0,2.0,3.0,4.0,5.0,6.0,
                7.0,8.0,9.0,10.0,11.0,
                12.0,13.0, 14.0);
        Dados d2 = MapaFicheiro.criarDados(l);
        assertEquals(d1.getData(), d2.getData());
        assertEquals(d1.getCasosTotais(), d2.getCasosTotais());
        assertEquals(d1.getCasosNovos(), d2.getCasosNovos());
        assertEquals(d1.getMortesTotais(), d2.getMortesTotais());
        assertEquals(d1.getNovasMortes(), d2.getNovasMortes());
        assertEquals(d1.getNovosTestes(), d2.getNovosTestes());
        assertEquals(d1.getTotalTestes(), d2.getTotalTestes());
        assertEquals(d1.getPopulacao(), d2.getPopulacao());
        assertEquals(d1.getNumeroIdosos(), d2.getNumeroIdosos());
        assertEquals(d1.getMortesCardiovasculares(), d2.getMortesCardiovasculares());
        assertEquals(d1.getPrevalenciaDiabetes(), d2.getPrevalenciaDiabetes());
        assertEquals(d1.getFumadoresFemininos(), d2.getFumadoresFemininos());
        assertEquals(d1.getFumadoresMasculinos(), d2.getFumadoresMasculinos());
        assertEquals(d1.getCamasHospitalPorMil(), d2.getCamasHospitalPorMil());
        assertEquals(d1.getEsperancaMediaDeVida(), d2.getEsperancaMediaDeVida());



    }

    @Test
    void validarDados() {
        LinkedList<String> l = new LinkedList<>();
        l.add("2");
        l.add("3");
        l.add("4");
        l.add("NA");
        l.add("5");
        l.add("6");
        l.add("NA");
        l.add("NA");
        MapaFicheiro.validarDados(l);

        assertEquals(l.get(3), "0");
        assertEquals(l.get(6), "0");
        assertEquals(l.get(7), "0");
    }

    @Test
    void inserirPaisDados() {
        HashMap<Pais, List<Dados>> m = new HashMap<>();
        Pais p1 = new Pais("AAA");
        Pais p2 = new Pais("BBB");
        Pais p3 = new Pais("CCC");
        Pais p4 = new Pais("DDD");
        Pais p5 = new Pais("EEE");
        Dados d1 = new Dados("2010-11-10");
        Dados d2 = new Dados("2010-11-11");
        Dados d3 = new Dados("2010-11-12");
        Dados d4 = new Dados("2010-11-13");
        Dados d5 = new Dados("2010-11-14");
        Dados d6 = new Dados("2010-11-15");
        Dados d7 = new Dados("2010-11-16");
        Dados d8 = new Dados("2010-11-17");
        Dados d9 = new Dados("2010-11-18");
        Dados d10 = new Dados("2010-11-19");
        MapaFicheiro.inserirPaisDados(m, p1, d1);
        MapaFicheiro.inserirPaisDados(m, p2, d2);
        MapaFicheiro.inserirPaisDados(m, p3, d3);
        MapaFicheiro.inserirPaisDados(m, p3, d4);
        MapaFicheiro.inserirPaisDados(m, p4, d5);
        MapaFicheiro.inserirPaisDados(m, p4, d6);
        MapaFicheiro.inserirPaisDados(m, p4, d7);
        MapaFicheiro.inserirPaisDados(m, p5, d8);
        MapaFicheiro.inserirPaisDados(m, p5, d9);
        MapaFicheiro.inserirPaisDados(m, p5, d10);

        assertTrue(m.containsKey(p1));
        assertTrue(m.containsKey(p2));
        assertTrue(m.containsKey(p3));
        assertTrue(m.containsKey(p4));
        assertTrue(m.containsKey(p5));
        assertEquals(1, m.get(p1).size());
        assertEquals(1, m.get(p2).size());
        assertEquals(2, m.get(p3).size());
        assertEquals(3, m.get(p4).size());
        assertEquals(3, m.get(p5).size());
        assertEquals(m.get(p1).get(0), d1);
        assertEquals(m.get(p2).get(0), d2);
        assertEquals(m.get(p3).get(0), d3);
        assertEquals(m.get(p3).get(1), d4);
        assertEquals(m.get(p4).get(0), d5);
        assertEquals(m.get(p4).get(1), d6);
        assertEquals(m.get(p4).get(2), d7);
        assertEquals(m.get(p5).get(0), d8);
        assertEquals(m.get(p5).get(1), d9);
        assertEquals(m.get(p5).get(2), d10);
    }
}