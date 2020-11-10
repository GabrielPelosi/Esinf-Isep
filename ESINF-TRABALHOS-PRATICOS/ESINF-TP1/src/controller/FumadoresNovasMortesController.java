package controller;

import model.Dados;
import model.MapaFicheiro;
import model.Pais;

import java.util.*;

public class FumadoresNovasMortesController {

    private MapaFicheiro mapa;

    public FumadoresNovasMortesController(Map<Pais, List<Dados>> m) {
        this.mapa = new MapaFicheiro(m);
    }

    public FumadoresNovasMortesController() {
        this.mapa = new MapaFicheiro();
    }

    /** Retorna a lista com nomes de Paises, percentagens de fumadores e soma de todos os novos casos
     * @return lista do tipo String, cada String é um pais e os seus dados
     */
    public List<String> listar(){
        Map<Pais, List<Dados>> m = mapa.getMap();
        List<String> l = new LinkedList<>();
        double novasMortes;
        double percentagemFumadores;
        for(Map.Entry<Pais, List<Dados>> e : m.entrySet()){
            if(e.getValue().get(0).threasholdFumadores()){
                percentagemFumadores = e.getValue().get(0).getFumadoresFemininos() + e.getValue().get(0).getFumadoresMasculinos();
                novasMortes = somarCasos(e.getValue());
                adiconarLista(l, e.getKey(), percentagemFumadores, novasMortes);
            }
        }
        return l;
    }

    /** Soma os novosCasos todos de um pais
     * @param l, lista com os dados de um pais
     * @return double com a soma
     */
    public double somarCasos(List<Dados> l) {
        double soma = 0;
        for(Dados d : l) soma += d.getNovasMortes();
        return soma;
    }

    /**Adiciona uma nova String à lista, index de inserção depende do número de novosCasos
     * @param l, lista com os paises ordenados
     * @param p, Pais a inserir na lista
     * @param percentagemFumadores, percentagem a inserir na lista
     * @param novasMortes, novos casos a inserir na lista
     */
    public void adiconarLista(List<String> l, Pais p, double percentagemFumadores, double novasMortes) {
        ListIterator<String> i = l.listIterator();
        String[] linha = new String[3];
        boolean colocado = false;
        double d;
        while (i.hasNext() && !colocado){
            linha = i.next().split(",");
            d = Double.parseDouble(linha[2]);
            if(novasMortes > d){
                i.previous();
                i.add(p.getNome() + "," + percentagemFumadores + "," + novasMortes);
                colocado = true;
            }
        }
        if(!colocado) i.add(p.getNome() + "," + percentagemFumadores + "," + novasMortes);

    }
}

