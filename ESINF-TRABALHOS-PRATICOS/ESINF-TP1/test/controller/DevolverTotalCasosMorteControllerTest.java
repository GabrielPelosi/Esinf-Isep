package controller;

import model.ContinenteMes;
import model.Dados;
import model.MapaFicheiro;
import model.Pais;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

class DevolverTotalCasosMorteControllerTest {


    @Test
    @DisplayName("Teste testgetTotalNovosCasosNovasMortes")
    public void testgetTotalNovosCasosNovasMortes(){
        DevolverTotalCasosMorteController devolverTotalCasosMorteController = new DevolverTotalCasosMorteController();
        devolverTotalCasosMorteController.getTotalNovosCasosNovasMortes();

        TreeMap<ContinenteMes, Dados> hashMap = devolverTotalCasosMorteController.getTotalNovosCasosNovasMortes();
        List<Dados> dadosList = new ArrayList<>();

        for (ContinenteMes contMes : hashMap.keySet()){
            dadosList.add(hashMap.get(contMes));
        }

        /*
        * Testes mês 1 a 6 continente Africa
         */
        // mês 1
        Assertions.assertEquals(0, dadosList.get(0).getCasosNovos());
        Assertions.assertEquals(0, dadosList.get(0).getNovasMortes());

        //mês 2
        Assertions.assertEquals(3, dadosList.get(1).getCasosNovos());
        Assertions.assertEquals(0, dadosList.get(1).getNovasMortes());

        //mês 3
        Assertions.assertEquals(5134, dadosList.get(2).getCasosNovos());
        Assertions.assertEquals(166, dadosList.get(2).getNovasMortes());

        //mês 4
        Assertions.assertEquals(31598, dadosList.get(3).getCasosNovos());
        Assertions.assertEquals(1425, dadosList.get(3).getNovasMortes());

        //mês 5
        Assertions.assertEquals(105535, dadosList.get(4).getCasosNovos());
        Assertions.assertEquals(2480, dadosList.get(4).getNovasMortes());

        //mês 6
        Assertions.assertEquals(251824, dadosList.get(5).getCasosNovos());
        Assertions.assertEquals(5807, dadosList.get(5).getNovasMortes());


        /*
        * Testes mês 6 a 9 continetne América do Sul
         */
        //mês 6
        Assertions.assertEquals(1336057, dadosList.get(50).getCasosNovos());
        Assertions.assertEquals(44261, dadosList.get(50).getNovasMortes());

        //mês 7
        Assertions.assertEquals(1841061, dadosList.get(51).getCasosNovos());
        Assertions.assertEquals(58034, dadosList.get(51).getNovasMortes());

        //mês 8
        Assertions.assertEquals(2206025, dadosList.get(52).getCasosNovos());
        Assertions.assertEquals(59364, dadosList.get(52).getNovasMortes());

        //mês 9
        Assertions.assertEquals(1735437, dadosList.get(53).getCasosNovos());
        Assertions.assertEquals(48690, dadosList.get(53).getNovasMortes());

    }

    @Test
    @DisplayName("Teste getTotalNovosCasosNovasMortesValoresReduzidos")
    public void testgetTotalNovosCasosNovasMortesValoresReduzidos(){
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

        mapa.put(new Pais("0","South America", "Brazil"),dados);

        MapaFicheiro mapaFicheiro = new MapaFicheiro(mapa);
        DevolverTotalCasosMorteController devolverTotalCasosMorteController = new DevolverTotalCasosMorteController(mapaFicheiro);
        devolverTotalCasosMorteController.getTotalNovosCasosNovasMortes();


        TreeMap<ContinenteMes, Dados> hashMap = devolverTotalCasosMorteController.getTotalNovosCasosNovasMortes();
        List<Dados> dadosList = new ArrayList<>();

        for (ContinenteMes contMes : hashMap.keySet()){
            dadosList.add(hashMap.get(contMes));
        }

        Assertions.assertEquals(1650882, dadosList.get(0).getCasosNovos());
        Assertions.assertEquals(860390, dadosList.get(0).getNovasMortes());

    }


    @Test
    @DisplayName("Teste getTotalNovosCasosNovasMortesValoresReduzidos")
    public void testgetTotalNovosCasosNovasMortesValoresReduzidosV2(){
        Map<Pais, List<Dados>> mapa = new HashMap<>();

        List<Dados> dados = new ArrayList<>();
        List<Dados> dados1 = new ArrayList<>();
        List<Dados> dados2 = new ArrayList<>();
        List<Dados> dados3 = new ArrayList<>();
        List<Dados> dados4 = new ArrayList<>();
        List<Dados> dados5 = new ArrayList<>();
        List<Dados> dados6 = new ArrayList<>();
        List<Dados> dados7 = new ArrayList<>();

        dados.add(new Dados("2020-01-01",1,0));
        dados.add(new Dados("2020-01-02",2,0));
        dados.add(new Dados("2020-02-03",3,0));
        dados.add(new Dados("2020-02-04",4,0.0));

        mapa.put(new Pais("UGA","Africa", "Uganda"),dados);


        dados1.add(new Dados("2020-01-05",5,0.0));
        dados1.add(new Dados("2020-02-06",6,0.0));
        dados1.add(new Dados("2020-03-07",7,0.0));
        dados1.add(new Dados("2020-04-08",8,0.0));

        mapa.put(new Pais("ZMB","Africa", "Zambia"),dados1);

        dados2.add(new Dados("2020-03-09",9,0));
        dados2.add(new Dados("2020-03-10",10,0));
        dados2.add(new Dados("2020-03-11",11,0));
        dados2.add(new Dados("2020-03-12",12,0));

        mapa.put(new Pais("PRT","Europe", "Portugal"),dados2);


        dados3.add(new Dados("2020-04-13",13,0));
        dados3.add(new Dados("2020-05-14",14,0));
        dados3.add(new Dados("2020-06-15",15,1));
        dados3.add(new Dados("2020-07-16",16,1));

        mapa.put(new Pais("ESP","Europe", "Spain"),dados3);



        dados5.add(new Dados("2020-03-21",21,2));
        dados5.add(new Dados("2020-02-22",22,2));
        dados5.add(new Dados("2020-01-23",23,2));
        dados5.add(new Dados("2020-04-24",24,2));

        mapa.put(new Pais("ARG","South America", "Argentina"),dados5);


        dados6.add(new Dados("2020-02-25",25,3));
        dados6.add(new Dados("2020-02-26",26,3));
        dados6.add(new Dados("2020-03-27",27,3));
        dados6.add(new Dados("2020-03-28",28,20));

        mapa.put(new Pais("BRA","South America", "Brazil"),dados6);


        dados7.add(new Dados("2020-03-29",29,25));
        dados7.add(new Dados("2020-07-30",30,30));
        dados7.add(new Dados("2020-05-31",31,31));

        mapa.put(new Pais("CHN","Asia", "China"),dados7);


        MapaFicheiro mapaFicheiro = new MapaFicheiro(mapa);
        DevolverTotalCasosMorteController devolverTotalCasosMorteController = new DevolverTotalCasosMorteController(mapaFicheiro);
        devolverTotalCasosMorteController.getTotalNovosCasosNovasMortes();


        TreeMap<ContinenteMes, Dados> hashMap = devolverTotalCasosMorteController.getTotalNovosCasosNovasMortes();
        List<Dados> dadosList = new ArrayList<>();

        for (ContinenteMes contMes : hashMap.keySet()){
            dadosList.add(hashMap.get(contMes));

        }

        /*
            Africa
         */
        // mês 1
        Assertions.assertEquals(8, dadosList.get(0).getCasosNovos());
        Assertions.assertEquals(0, dadosList.get(0).getNovasMortes());

        //mês 2
        Assertions.assertEquals(13, dadosList.get(1).getCasosNovos());
        Assertions.assertEquals(0, dadosList.get(1).getNovasMortes());

        //mês 3
        Assertions.assertEquals(7, dadosList.get(2).getCasosNovos());
        Assertions.assertEquals(0, dadosList.get(2).getNovasMortes());

        //mês 4
        Assertions.assertEquals(8, dadosList.get(3).getCasosNovos());
        Assertions.assertEquals(0, dadosList.get(3).getNovasMortes());

        /*
         * Asia
         */
        //mes 3
        Assertions.assertEquals(29, dadosList.get(4).getCasosNovos());
        Assertions.assertEquals(25, dadosList.get(4).getNovasMortes());

        //mês 5
        Assertions.assertEquals(31, dadosList.get(5).getCasosNovos());
        Assertions.assertEquals(31, dadosList.get(5).getNovasMortes());

        // mês 7
        Assertions.assertEquals(30, dadosList.get(6).getCasosNovos());
        Assertions.assertEquals(30, dadosList.get(6).getNovasMortes());




        /*
         * Europe
         */
        //mês 3
        Assertions.assertEquals(42, dadosList.get(7).getCasosNovos());
        Assertions.assertEquals(0, dadosList.get(7).getNovasMortes());

        //mes 4
        Assertions.assertEquals(13, dadosList.get(8).getCasosNovos());
        Assertions.assertEquals(0, dadosList.get(8).getNovasMortes());

        //mês 5
        Assertions.assertEquals(14, dadosList.get(9).getCasosNovos());
        Assertions.assertEquals(0, dadosList.get(9).getNovasMortes());

        //mês 6
        Assertions.assertEquals(15, dadosList.get(10).getCasosNovos());
        Assertions.assertEquals(1, dadosList.get(10).getNovasMortes());

        //mês 7
        Assertions.assertEquals(16, dadosList.get(11).getCasosNovos());
        Assertions.assertEquals(1, dadosList.get(11).getNovasMortes());

        /*
         *SA
         */
        //mês 3
        Assertions.assertEquals(23, dadosList.get(12).getCasosNovos());
        Assertions.assertEquals(2, dadosList.get(12).getNovasMortes());

        //mes 4
        Assertions.assertEquals(73, dadosList.get(13).getCasosNovos());
        Assertions.assertEquals(8, dadosList.get(13).getNovasMortes());

        //mês 5
        Assertions.assertEquals(76, dadosList.get(14).getCasosNovos());
        Assertions.assertEquals(25, dadosList.get(14).getNovasMortes());

        //mês 6
        Assertions.assertEquals(24, dadosList.get(15).getCasosNovos());
        Assertions.assertEquals(2, dadosList.get(15).getNovasMortes());


    }

}