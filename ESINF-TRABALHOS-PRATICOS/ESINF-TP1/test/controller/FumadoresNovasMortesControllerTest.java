package controller;

import model.Dados;
import model.Pais;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FumadoresNovasMortesControllerTest {

    FumadoresNovasMortesController controller;

    @Test
    void lista() {
        Map<Pais, List<Dados>> m = new HashMap<>();
        List<Dados> l1 = new LinkedList<>();
        List<Dados> l2 = new LinkedList<>();
        List<Dados> l3 = new LinkedList<>();
        Dados d1 = new Dados("2020-01-01");
        d1.setNovasMortes(2);
        d1.setFumadoresMasculinos(36);
        d1.setFumadoresFemininos(35);
        Dados d2 = new Dados("2020-01-02");
        d2.setNovasMortes(3);
        d2.setFumadoresMasculinos(36);
        d2.setFumadoresFemininos(35);
        Dados d3 = new Dados("2020-01-03");
        d3.setNovasMortes(1);
        d3.setFumadoresMasculinos(36);
        d3.setFumadoresFemininos(35);
        l1.add(d1);
        l2.add(d2);
        l3.add(d3);
        m.put(new Pais("AAA", "A"), l1);
        m.put(new Pais("BBB", "B"), l2);
        m.put(new Pais("CCC", "C"), l3);
        controller = new FumadoresNovasMortesController(m);
        List<String> r = controller.listar();
        String[] l;
        l = r.get(0).split(",");
        assertEquals(r.size(), 3);
        assertEquals(l[0], "B");
        assertEquals(l[1], "71.0");
        assertEquals(l[2], "3.0");
        l = r.get(1).split(",");
        assertEquals(l[0], "A");
        assertEquals(l[1], "71.0");
        assertEquals(l[2], "2.0");
        l = r.get(2).split(",");
        assertEquals(l[0], "C");
        assertEquals(l[1], "71.0");
        assertEquals(l[2], "1.0");
        //Testes com valores do enunciado
        controller = new FumadoresNovasMortesController();
        r = controller.listar();
        l = r.get(0).split(",");
        assertEquals(l.length, 3);
        assertEquals(l[0], "Russia");
        assertEquals(l[2], "20385.0");
        l = r.get(1).split(",");
        assertEquals(l.length, 3);
        assertEquals(l[0], "Chile");
        assertEquals(l[2], "12698.0");
    }

    @Test
    void somarCasos() {
        controller = new FumadoresNovasMortesController();
        List<Dados> l = new LinkedList<>();
        Dados d1 = new Dados("2020-01-01");
        d1.setNovasMortes(1);
        Dados d2 = new Dados("2020-01-02");
        d2.setNovasMortes(1);
        Dados d3 = new Dados("2020-01-03");
        d3.setNovasMortes(2);
        Dados d4 = new Dados("2020-01-04");
        d4.setNovasMortes(3);
        Dados d5 = new Dados("2020-01-05");
        d5.setNovasMortes(5);
        l.add(d1);
        l.add(d2);
        l.add(d3);
        l.add(d4);
        l.add(d5);
        double r = controller.somarCasos(l);
        assertEquals(r, 12);

    }


    @Test
    void adiconarLista() {
        controller = new FumadoresNovasMortesController();
        List<String> l = new LinkedList<>();
        Pais p = new Pais("AAA", "A");
        double f = 70;
        double n = 1;
        String[] linha;
        controller.adiconarLista(l, p, f, n);
        linha = l.get(0).split(",");
        assertEquals(linha[0], "A");
        assertEquals(l.size(), 1);
        assertEquals(linha[1], "70.0");
        assertEquals(linha[2], "1.0");
        p = new Pais("BBB", "B");
        n = 2;
        controller.adiconarLista(l, p, f, n);
        linha = l.get(0). split(",");
        assertEquals(l.size(), 2);
        assertEquals(linha[0], "B");
        assertEquals(linha[2], "2.0");
        p = new Pais("CCC", "C");
        n = 3;
        controller.adiconarLista(l, p, f, n);
        linha = l.get(0). split(",");
        assertEquals(l.size(), 3);
        assertEquals(linha[0], "C");
        assertEquals(linha[2], "3.0");
        p = new Pais("DDD", "D");
        n = 0;
        controller.adiconarLista(l, p, f, n);
        linha = l.get(3). split(",");
        assertEquals(l.size(), 4);
        assertEquals(linha[0], "D");
        assertEquals(linha[2], "0.0");
    }

}