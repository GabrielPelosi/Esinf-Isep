package controller;

import model.Dados;
import model.MapaFicheiro;
import model.Pais;
import model.PaisDia;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class DevolverNovosCasosMesContinente {


    /*

     */
    private TreeMap<PaisDia, Dados> treeMap;

    /*

     */
    private MapaFicheiro mapaFicheiro = new MapaFicheiro();

    /*

     */
    public DevolverNovosCasosMesContinente() {
        this.treeMap = new TreeMap<>();
    }

    public DevolverNovosCasosMesContinente(MapaFicheiro mapaFicheiro) {
        this.mapaFicheiro = mapaFicheiro;
        this.treeMap = new TreeMap<>();
    }

    /**Busca para cada dia de um determinado mês e para um dado continente, os países ordenados por
     * ordem decrescente do número de novos casos positivos.
     * @param continente continente que será usado na manipulação dos dados.
     * @param mes mês que será usado na manipulação dos dados
     * @return TreeMap com os novos casos somados ordenado por Dia e Pais.
     */
    public TreeMap<PaisDia, Dados> getNovosCasosMesContinente(String continente, int mes){
        Map<Pais, List<Dados>> paisDadosMap = mapaFicheiro.getMap();

        for (Map.Entry<Pais, List<Dados>> entry: paisDadosMap.entrySet()){
            if (entry.getKey().getContinente().equalsIgnoreCase(continente)){
                tratarDados(entry.getValue(), mes, entry.getKey().getNome());
            }
        }
        return treeMap;

    }

    /**Trata os dados recebidos por parametro, ou seja,
     * verifica a existencia das chaves para atualizar seus dados, ou para criar-los caso a chave não exista
     * @param value Lista de dados(Esses dados são sempre do mesmo continente, que foi especificado no paramêtro do método - getNovosCasosMesContinente)
     * @param mes mês que foi especificado no método getNovosCasosMesContinente.
     * @param nomePais nome do pais ligado a lista dos dados.
     */
    private void tratarDados(List<Dados> value, int mes,String nomePais) {
        for (Dados d : value){
            if (d.getData().getMonthValue() == mes){
                if (verificarChaveExistente(nomePais,d.getData().getDayOfMonth()))
                    atualizarDadosPaisDia(nomePais,d.getData().getDayOfMonth(), d.getCasosNovos());
                else
                    criarChavePaisDados(nomePais,d.getData().getDayOfMonth(), d.getCasosNovos());
            }
        }
    }

    /**Cria uma chave e seus respectivos dados no mapa.
     * @param nomePais Nome do pais que formará a chave.
     * @param day dia do mês que formará a chave.
     * @param casosNovos número de novos casos que estará ligado a chave a ser criada.
     */
    private void criarChavePaisDados(String nomePais, int day, double casosNovos) {
        treeMap.put(new PaisDia(nomePais, day),new Dados(casosNovos));
    }

    /**Atualiza os dadaos de uma respectiva chave do mapa.
     * @param nomePais Nome do pais respectivo a chave.
     * @param day dia do mês respectivo a chave.
     * @param casosNovos número de novos casos a ser atualizado que está ligado a chave.
     */
    private void atualizarDadosPaisDia(String nomePais, int day, double casosNovos) {
        PaisDia paisDiaChave = new PaisDia(nomePais,day);
        treeMap.get(paisDiaChave).setCasosNovos(treeMap.get(paisDiaChave).getCasosNovos() + casosNovos);
    }

    /**Verifica se a chave existe no mapa.
     * @param nomePais Nome do pais da chave a ser verificada.
     * @param day dia do mês da chave a ser verificada.
     * @return true se a chave existir no treemao, false caso ela não exista.
     */
    private boolean verificarChaveExistente(String nomePais, int day) {
        return treeMap.containsKey(new PaisDia(nomePais,day));
    }


}





