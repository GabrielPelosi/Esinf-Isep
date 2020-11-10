package controller;


import model.*;

import java.util.*;

public class DevolverTotalCasosMorteController {

    private MapaFicheiro mapaFicheiro;

    private TreeMap<ContinenteMes, Dados> treeMap;

    public DevolverTotalCasosMorteController() {
        this.treeMap=new TreeMap<>();
        this.mapaFicheiro=new MapaFicheiro();
    }

    public DevolverTotalCasosMorteController(MapaFicheiro mapaFicheiro) {
        this.mapaFicheiro = mapaFicheiro;
        this.treeMap = new TreeMap<>();
    }


    /** Busca o total de novos_casos/novas_mortes por continente/mês, ordenado por continente/mês.
     * @return TreeMap com os novos casos e novas mortes somadas por Continente/Mês e ordenados por Continente/Mês.
     */
    public TreeMap<ContinenteMes, Dados> getTotalNovosCasosNovasMortes(){

        Map<Pais, List<Dados>> map = mapaFicheiro.getMap();
        treeMap = new TreeMap<>();
        String continente;
        int month;
        double novosCasos;
        double novasMortes;
        ContinenteMes continenteMes;

        for(Map.Entry<Pais, List<Dados>> e : map.entrySet()){
            continente = e.getKey().getContinente();
            for(Dados d : e.getValue()){
                month = d.getData().getMonthValue();
                novosCasos = d.getCasosNovos();
                novasMortes = d.getNovasMortes();
                continenteMes = new ContinenteMes(continente, month);
                tratarDados(continenteMes, d, novosCasos, novasMortes);

            }
        }

        return treeMap;

    }


    /**Atualiza os dados recebidos por parametro no mapa caso eles ja existam no mesmo, caso não existam, são criados no mapa.
     * @param continenteMes Chave a ser analisada.
     * @param d dados respectivos a chave.
     * @param novosCasos número de novos casos.
     * @param novasMortes número de novas mortes.
     */
    private void tratarDados(ContinenteMes continenteMes,
                             Dados d,
                             double novosCasos,
                             double novasMortes) {

        if(verificarChaveExistente(continenteMes))
            atualizarDadosChaveExistente(continenteMes,
                    novosCasos,
                    novasMortes);
        else
            criarChaveContinenteMes(continenteMes,
                    new Dados(d.getCasosNovos(),
                            d.getNovasMortes()));
    }


    /**Atualiza os dados de uma chave existente.
     * @param continenteMes chave que terá seus dados atualizados(objeto com o continente e o mês)
     * @param novosCasos número de novos casos a serem atualizados
     * @param novasMortes núemro de novas mortes a serem atualizadas
     */
    private void atualizarDadosChaveExistente(ContinenteMes continenteMes,
                                              double novosCasos,
                                              double novasMortes) {

        Dados dados = treeMap.get(continenteMes);
        dados.setCasosNovos(dados.getCasosNovos() + novosCasos);
        dados.setNovasMortes(dados.getNovasMortes() + novasMortes);
    }


    /**Verifica se a chave existe no mapa.
     * @param continenteMes Chave a ser verificada.
     * @return true se a chave recebida existir no mapa, falso se a chave não existir.
     */
    private boolean verificarChaveExistente(ContinenteMes continenteMes){
        return treeMap.containsKey(continenteMes);
    }

    /**Cria uma chave e seus respectivos dados no mapa.
     * @param continenteMes chave a ser criada no mapa.
     * @param dados dados relativos a chave a serem criados no mapa
     */
    private void criarChaveContinenteMes(ContinenteMes continenteMes, Dados dados){
        treeMap.put(continenteMes,dados);
    }

}
