package controller;

import model.Dados;
import model.Pais;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class OrdenarNumeroMinimoControllerTest {

    private OrdenarNumeroMinimoController controller;

    @Test
    void mapaNumeroMinimo() {
        HashMap<Pais, List<Dados>> m = new HashMap<>();
        List<Dados> l1 = new LinkedList<>();
        List<Dados> l2 = new LinkedList<>();
        List<Dados> l3 = new LinkedList<>();
        List<Dados> l4 = new LinkedList<>();
        List<Dados> l5 = new LinkedList<>();
        List<Dados> l6 = new LinkedList<>();
        l1.add(new Dados("0001-12-10", 500001));
        l1.add(new Dados("0001-12-11", 1));
        l1.add(new Dados("0001-12-12", 2));
        m.put(new Pais("AAA"), l1);
        l2.add(new Dados("0001-12-10", 500001));
        l2.add(new Dados("0001-12-11", 5));
        l2.add(new Dados("0001-12-12", 4));
        m.put(new Pais("BBB"), l2);
        l3.add(new Dados("0001-12-10", 7));
        l3.add(new Dados("0001-12-11", 500001));
        l3.add(new Dados("0001-12-12", 8));
        m.put(new Pais("CCC"), l3);
        l4.add(new Dados("0001-12-10", 2));
        l4.add(new Dados("0001-12-11", 500001));
        l4.add(new Dados("0001-12-12", 2));
        m.put(new Pais("DDD"), l4);
        l5.add(new Dados("0001-12-10", 2));
        l5.add(new Dados("0001-12-11", 2));
        l5.add(new Dados("0001-12-12", 500001));
        m.put(new Pais("EEE"), l5);
        l6.add(new Dados("0001-12-10", 2));
        l6.add(new Dados("0001-12-11", 2));
        l6.add(new Dados("0001-12-12", 500001));
        m.put(new Pais("FFF"), l6);
        controller = new OrdenarNumeroMinimoController(m);
        Map<Integer, List<Pais>> m1 = controller.mapaNumeroMinimo();
        assertTrue(m1.containsKey(0));
        assertTrue(m1.containsKey(1));
        assertTrue(m1.containsKey(2));
        assertTrue(m1.get(0).contains(new Pais ("AAA")));
        assertTrue(m1.get(0).contains(new Pais ("BBB")));
        assertTrue(m1.get(1).contains(new Pais ("CCC")));
        assertTrue(m1.get(1).contains(new Pais ("DDD")));
        assertTrue(m1.get(2).contains(new Pais ("EEE")));
        assertTrue(m1.get(2).contains(new Pais ("FFF")));
        assertEquals(m1.get(0).size(), 2);
        assertEquals(m1.get(1).size(), 2);
        assertEquals(m1.get(2).size(), 2);
        int j = -1;
        for(Integer i : m1.keySet()){
            assertTrue(i>j);
            j = i;
        }

        //Testes com os dados do enuciado
        controller = new OrdenarNumeroMinimoController();
        m1 = controller.mapaNumeroMinimo();
        assertTrue(m1.get(43).contains(new Pais("CHN")));
        assertTrue(m1.get(81).contains(new Pais("ITA")));
        assertTrue(m1.get(84).contains(new Pais("ESP")));
        assertTrue(m1.get(84).contains(new Pais("USA")));
        assertTrue(m1.get(88).contains(new Pais("DEU")));
        assertTrue(m1.get(91).contains(new Pais("FRA")));
        assertTrue(m1.get(265).contains(new Pais("DZA")));
        assertTrue(m1.get(265).contains(new Pais("CHE")));

    }

    @Test
    void diferencaDias() {
        controller = new OrdenarNumeroMinimoController();
        List<Dados> l = new LinkedList<>();
        l.add(new Dados("2020-01-01"));
        l.add(new Dados("2020-01-02"));
        l.add(new Dados("2020-01-04"));
        l.add(new Dados("2020-01-25"));
        assertEquals(controller.diferencaDias(0, l), -1);
        assertEquals(controller.diferencaDias(1, l), 1);
        assertEquals(controller.diferencaDias(2, l), 3);
        assertEquals(controller.diferencaDias(3, l), 24);
    }

    @Test
    void primeiroIndexThreashold(){
        controller = new OrdenarNumeroMinimoController();
        List<Dados> l1 = new LinkedList<>();
        List<Dados> l2 = new LinkedList<>();
        List<Dados> l3 = new LinkedList<>();
        l1.add(new Dados("2020-01-01", 50001));
        l1.add(new Dados("2020-01-02", 1));
        l1.add(new Dados("2020-01-03", 1));
        l2.add(new Dados("2020-01-01", 1));
        l2.add(new Dados("2020-01-02", 50001));
        l2.add(new Dados("2020-01-03", 1));
        l3.add(new Dados("2020-01-01", 1));
        l3.add(new Dados("2020-01-02", 1));
        l3.add(new Dados("2020-01-03", 50001));
        assertEquals(controller.primeiroIndexThreashold(l1), 0);
        assertEquals(controller.primeiroIndexThreashold(l2), 1);
        assertEquals(controller.primeiroIndexThreashold(l3), 2);

    }

    @Test
    void adicionarEntryMapa() {
        controller = new OrdenarNumeroMinimoController();
        Pais p1 = new Pais("AAA");
        Pais p2 = new Pais("AAA");
        Pais p3 = new Pais("AAA");
        Pais p4 = new Pais("AAA");
        Pais p5 = new Pais("AAA");
        Pais p6 = new Pais("AAA");
        controller.adicionarEntryMapa(p1,1);
        controller.adicionarEntryMapa(p2,2);
        controller.adicionarEntryMapa(p3,2);
        controller.adicionarEntryMapa(p4,3);
        controller.adicionarEntryMapa(p5,3);
        controller.adicionarEntryMapa(p6,3);
        Map<Integer, List<Pais>> m = controller.getMapaNumeroMinimo();
        assertTrue(m.containsKey(1));
        assertTrue(m.containsKey(2));
        assertTrue(m.containsKey(3));
        assertEquals(1, m.get(1).size());
        assertEquals(2, m.get(2).size());
        assertEquals(3, m.get(3).size());
    }

}