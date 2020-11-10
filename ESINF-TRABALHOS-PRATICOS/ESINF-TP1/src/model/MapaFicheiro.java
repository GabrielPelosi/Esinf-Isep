package model;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class MapaFicheiro {

    private Map<Pais, List<Dados>> map;

    public MapaFicheiro(Map<Pais, List<Dados>> map) {
        this.map = new HashMap<>(map);
    }

    public MapaFicheiro(){
        this.map = carregarDados();
    }

    public Map<Pais, List<Dados>> getMap() {
        return map;
    }

    private static final File file = new File("owid-covid-data.csv");

    /** retorna um mapa, a chave é um pais, o value é uma lista com todos os dados organizados por dia
     * @return Mapa, key é do tipo Pais, value é do tipo List Dados
     */
    public static Map<Pais, List<Dados>> carregarDados() {

        final String LINE_SPLITER = ",";

        Map<Pais, List<Dados>> mapa = new HashMap<>();
        Scanner in = null;

        try {
            in = new Scanner(file);
        }catch (FileNotFoundException e){
            System.out.println("Ficheiro não existente");

        }
        LinkedList<String> linha;
        Pais p;
        Dados d;
        int i = 0;
        try {
            in.nextLine();
        }catch (NullPointerException e){
            System.out.println("Ficheiro vazio");
        }

        while(in.hasNextLine()){
            linha = new LinkedList<>(Arrays.asList(in.nextLine().split(LINE_SPLITER)));
            p = criarPais(linha);
            d = criarDados(linha);
            inserirPaisDados(mapa, p, d);
        }

        in.close();



        return mapa;
    }

    /**Cria o pais com os primeiros 3 valores de linha
     * @param linha lista de strings com a linha do ficheiro
     * @return retorna o objeto pais
     */
    public static Pais criarPais(List<String> linha) {

        return new Pais (linha.get(0).replaceAll("\"", ""), linha.get(1).replaceAll("\"", ""), linha.get(2).replaceAll("\"", ""));

    }

    /** Cria os dados com os últimos 15 valores da linha
     * @param linha lista de strings com a linha do ficheiro
     * @return retorna os dados
     */
    public static Dados criarDados(List<String> linha) {
        validarDados(linha);
        return new Dados(linha.get(3), Double.parseDouble(linha.get(4)), Double.parseDouble(linha.get(5)), Double.parseDouble(linha.get(6)),
                Double.parseDouble(linha.get(7)), Double.parseDouble(linha.get(8)), Double.parseDouble(linha.get(9)),
                Double.parseDouble(linha.get(10)), Double.parseDouble(linha.get(11)), Double.parseDouble(linha.get(12)),
                Double.parseDouble(linha.get(13)), Double.parseDouble(linha.get(14)), Double.parseDouble(linha.get(15)),
                Double.parseDouble(linha.get(16)), Double.parseDouble(linha.get(17)));
    }

    /** Verifica que qualquer campo com "NA" seja substituido com "0"
     * @param linha lista de strings com a linha do ficheiro
     */
    public static void validarDados(List<String> linha) {
        ListIterator<String> it  = linha.listIterator();
        String s;
        while(it.hasNext()){
            s = (String) it.next();
            if(s.equalsIgnoreCase("NA")){
                it.set("0");
            }
        }
    }

    /** Insere novos calores criados no mapa
     * @param mapa mapa onde se vão inserir os dados
     * @param p Um pais, chave do mapa
     * @param d, Lista de dados, value do mapa
     */
    public static void inserirPaisDados(Map<Pais, List<Dados>> mapa, Pais p, Dados d) {
        List<Dados> dados;
        if(!mapa.containsKey(p)) {
            dados = new LinkedList<>();
            dados.add(d);
            mapa.put(p, dados);
        }else{
            dados = mapa.get(p);
            dados.add(d);
        }

    }
}
