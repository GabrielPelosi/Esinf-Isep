package controller;

import model.Dados;
import model.Pais;
import model.MapaFicheiro;

import java.time.temporal.ChronoUnit;
import java.util.*;

public class OrdenarNumeroMinimoController {

    private Map<Pais, List<Dados>> mapaPaises;
    private Map<Integer, List<Pais>> mapaNumeroMinimo;

    private final int THREASHOLD_CASOS = 50000;

    public OrdenarNumeroMinimoController() {
        this.mapaPaises = new MapaFicheiro().getMap();
        this.mapaNumeroMinimo = new TreeMap<>();
    }

    public OrdenarNumeroMinimoController(Map<Pais, List<Dados>> m){
        this.mapaPaises = new HashMap<>(m);
        this.mapaNumeroMinimo = new TreeMap<>();
    }

    /** retorna um mapa com os paises ordenados por numero de dias a atingir 50.000 casos
     * @return Mapa, Key é do tipo Integer, value é do tipo List Pais
     */
    public Map<Integer, List<Pais>> mapaNumeroMinimo(){
        int index;
        int dia;
        for(Map.Entry<Pais, List<Dados>> entry: mapaPaises.entrySet()){
            index = primeiroIndexThreashold(entry.getValue());
            dia = diferencaDias(index, entry.getValue());
            if(dia >= 0){
                adicionarEntryMapa(entry.getKey(), dia);
            }
        }
        return mapaNumeroMinimo;
    }

    /** retorna o primeiro index com totalCasos acima de 50.000
     * @param l, lista com os dados de um determinado pais
     * @return inteiro com o index
     */
    public int primeiroIndexThreashold(List<Dados> l) {
        for(Dados d : l) if (d.getCasosTotais() > THREASHOLD_CASOS){
            return l.indexOf(d);
        }
        return -1;

    }

    /** retorna a diferença de dias entre os Dados do index e os primeiros Dados da Lista
     * @param index, index do dia a fazer a diferenca
     * @param l, lista de dados de um determinado pais
     * @return inteiro com difernça de dias
     */
    public int diferencaDias(int index, List<Dados> l){
        if(index < 0) return -1;
        return (int) ChronoUnit.DAYS.between(l.get(0).getData(), l.get(index).getData());
    }

    /**Adiciona o pais e os dias ao mapa
     * @param p, value a acrescentar ao mapa
     * @param dia, key a acrescentar ao mapa
     */
    public void adicionarEntryMapa(Pais p, int dia){
        List<Pais> l;
        if(mapaNumeroMinimo.containsKey(dia)){
            l = mapaNumeroMinimo.get(dia);
            l.add(p);
        }else{
            l = new LinkedList<>();
            l.add(p);
            mapaNumeroMinimo.put(dia, l);
        }
    }

    public Map<Integer, List<Pais>> getMapaNumeroMinimo() {
        return mapaNumeroMinimo;
    }
}
