package controller;

import model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DevolverNovosCasosMesContinenteTest {

    private DevolverNovosCasosMesContinente devolverNovosCasosMesContinente = new DevolverNovosCasosMesContinente();


    @Test
    @DisplayName("Test")
    public void testegetNovosCasosMesContinente(){
        TreeMap<PaisDia, Dados> tree = devolverNovosCasosMesContinente.getNovosCasosMesContinente("Europe", 9);
        List<Dados> dadosList = new ArrayList<>();

        for (PaisDia contMes : tree.keySet()){
            dadosList.add(tree.get(contMes));
        }

        /*
        * Dia 1
         */
        //Spain
        Assertions.assertEquals(8115, dadosList.get(45).getCasosNovos());
        //Russia
        Assertions.assertEquals(4993, dadosList.get(40).getCasosNovos());
        //France
        Assertions.assertEquals(3082, dadosList.get(14).getCasosNovos());


        /*
        * Dia 2
         */
        //Spain
        Assertions.assertEquals(8581, dadosList.get(96).getCasosNovos());
        //Russia
        Assertions.assertEquals(4729, dadosList.get(91).getCasosNovos());
        //France
        Assertions.assertEquals(7017, dadosList.get(116).getCasosNovos());


        /*
         * Dia 29
         */
        //Russia
        Assertions.assertEquals(8135, dadosList.get(1465).getCasosNovos());
        //France
        Assertions.assertEquals(4070, dadosList.get(1439).getCasosNovos());
        //United Kingdom
        Assertions.assertEquals(4044, dadosList.get(1472).getCasosNovos());

    }


    @Test
    public void test(){
        Map<Pais, List<Dados>> mapa = new HashMap<>();
        List<Dados> dados = new ArrayList<>();
        dados.add(new Dados("2020-01-01",0.0,0.0));
        dados.add(new Dados("2020-01-02",0.0,0.0));
        dados.add(new Dados("2020-01-03",3.0,0.0));
        dados.add(new Dados("2020-01-04",6.0,0.0));
        dados.add(new Dados("2020-01-05",9.0,1.0));
        dados.add(new Dados("2020-01-06",10,3.0));
        dados.add(new Dados("2020-01-07",20,6.0));
        dados.add(new Dados("2020-01-08",46.0,10.0));
        dados.add(new Dados("2020-01-09",140,50));
        dados.add(new Dados("2020-01-10",509,60));
        dados.add(new Dados("2020-01-11",734,80));
        dados.add(new Dados("2020-01-12",1500,200));
        dados.add(new Dados("2020-01-13",55506,1000));
        dados.add(new Dados("2020-01-14",55677,3000));
        dados.add(new Dados("2020-01-15",67678,9090));
        dados.add(new Dados("2020-01-16",78978,18090));
        dados.add(new Dados("2020-01-17",89098,20000));
        dados.add(new Dados("2020-01-18",90890,25000));
        dados.add(new Dados("2020-01-19",100000,30000));
        dados.add(new Dados("2020-01-20",100001,35000));
        dados.add(new Dados("2020-01-21",100002,40000));
        dados.add(new Dados("2020-01-22",100003,45000));
        dados.add(new Dados("2020-01-23",100004,50000));
        dados.add(new Dados("2020-01-24",100005,55000));
        dados.add(new Dados("2020-01-25",100006,60000));
        dados.add(new Dados("2020-01-26",100007,65000));
        dados.add(new Dados("2020-01-27",100008,70000));
        dados.add(new Dados("2020-01-28",100009,75000));
        dados.add(new Dados("2020-01-29",10010,80000));
        dados.add(new Dados("2020-01-30",100011,88800));
        dados.add(new Dados("2020-01-31",100012,90000));

        mapa.put(new Pais("BRA","South America", "Brazil"),dados);

        MapaFicheiro mapaFicheiro = new MapaFicheiro(mapa);
        DevolverNovosCasosMesContinente devolverNovosCasosMesContinente1 = new DevolverNovosCasosMesContinente(mapaFicheiro);
        TreeMap<PaisDia, Dados> tree = devolverNovosCasosMesContinente1.getNovosCasosMesContinente("South America", 1);
        List<Dados> dadosList = new ArrayList<>();


        for (PaisDia contMes : tree.keySet()){
            dadosList.add(tree.get(contMes));
        }


        Assertions.assertEquals(0, dadosList.get(0).getCasosNovos());

        Assertions.assertEquals(0, dadosList.get(1).getCasosNovos());

        Assertions.assertEquals(3, dadosList.get(2).getCasosNovos());

        Assertions.assertEquals(6, dadosList.get(3).getCasosNovos());

        Assertions.assertEquals(9, dadosList.get(4).getCasosNovos());

        Assertions.assertEquals(10, dadosList.get(5).getCasosNovos());

        Assertions.assertEquals(20, dadosList.get(6).getCasosNovos());

        Assertions.assertEquals(46, dadosList.get(7).getCasosNovos());

        Assertions.assertEquals(140, dadosList.get(8).getCasosNovos());

        Assertions.assertEquals(509, dadosList.get(9).getCasosNovos());

        Assertions.assertEquals(734, dadosList.get(10).getCasosNovos());

        Assertions.assertEquals(1500, dadosList.get(11).getCasosNovos());

        Assertions.assertEquals(55506, dadosList.get(12).getCasosNovos());

        Assertions.assertEquals(55677, dadosList.get(13).getCasosNovos());

        Assertions.assertEquals(67678, dadosList.get(14).getCasosNovos());

        Assertions.assertEquals(78978, dadosList.get(15).getCasosNovos());

        Assertions.assertEquals(89098, dadosList.get(16).getCasosNovos());

        Assertions.assertEquals(90890, dadosList.get(17).getCasosNovos());

        Assertions.assertEquals(100000, dadosList.get(18).getCasosNovos());

        Assertions.assertEquals(100001, dadosList.get(19).getCasosNovos());

        Assertions.assertEquals(100002, dadosList.get(20).getCasosNovos());

        Assertions.assertEquals(100003, dadosList.get(21).getCasosNovos());

        Assertions.assertEquals(100004, dadosList.get(22).getCasosNovos());

        Assertions.assertEquals(100005, dadosList.get(23).getCasosNovos());

        Assertions.assertEquals(100006, dadosList.get(24).getCasosNovos());

        Assertions.assertEquals(100007, dadosList.get(25).getCasosNovos());

        Assertions.assertEquals(100008, dadosList.get(26).getCasosNovos());

        Assertions.assertEquals(100009, dadosList.get(27).getCasosNovos());

        Assertions.assertEquals(10010, dadosList.get(28).getCasosNovos());

        Assertions.assertEquals(100011, dadosList.get(29).getCasosNovos());


    }

}