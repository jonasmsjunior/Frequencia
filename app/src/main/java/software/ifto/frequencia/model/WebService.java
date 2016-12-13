package software.ifto.frequencia.model;


import com.google.gson.Gson;

import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class WebService {
    public List<Processo> processos;

    public  WebService(){
        Processo processo = new Processo();
        processo.setNumeroProcesso(203);
        processo.setComarca("paraiso");
        processo.setJuiz("José Marcos");
        processo.setTipoProcesso("indenização");

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        String dateInString = "7-Jun-2013";
        Date date = new Date();
        try {
            date = formatter.parse(dateInString);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        processo.setDataCriacao(date);

        List<Parte> Partes = new ArrayList<Parte>();

        Parte parte1 = new Parte();
        Parte parte2 = new Parte();
        Parte parte3 = new Parte();

        parte1.setDocumento("000.000.000-00");
        parte1.setNome("fulano");
        parte1.setTipoDocumento("cpf");
        parte1.setTipo("reu");

        parte2.setDocumento("111.000.000-00");
        parte2.setNome("fulanoc2");
        parte2.setTipoDocumento("cpf");
        parte2.setTipo("advogado");

        parte3.setDocumento("222.000.000-00");
        parte3.setNome("fulano 3");
        parte3.setTipoDocumento("cpf");
        parte3.setTipo("autor");

        Partes.add(parte1);
        Partes.add(parte2);
        Partes.add(parte3);


        processo.setPartes(Partes);

        Eventos evento1 = new Eventos();
        Eventos evento2 = new Eventos();
        Eventos evento3 = new Eventos();

        evento1.setAssunto("decisão");
        evento1.setConteudo("bla bla bla");
        evento1.setData(date);
        evento1.setDescricao("etc etc etc");

        evento2.setAssunto("decisão");
        evento2.setConteudo("bla bla bla");
        evento2.setData(date);
        evento2.setDescricao("etc etc etc");

        evento3.setAssunto("decisão");
        evento3.setConteudo("bla bla bla");
        evento3.setData(date);
        evento3.setDescricao("etc etc etc");

        List<Eventos> eventos = new ArrayList<Eventos>();
        eventos.add(evento1);
        eventos.add(evento2);
        eventos.add(evento3);


        processos.add(processo);

    }

    public boolean verificaUsuario(String usuario, String senha){
        return true;
    }

    public List<Processo> ConsultaCPF(String cpf){
        List<Parte> partesTemp = new ArrayList<Parte>();
        List<Processo> processosResult = new ArrayList<Processo>();
        for(Processo processo : processos){
            partesTemp = processo.getPartes();
            for(Parte parte : partesTemp){
                if(cpf.equals(parte.getDocumento()) && "cpf".equals(parte.getTipoDocumento())){
                    processosResult.add(processo);
                    break;
                }
            }
        }

        return processosResult;
    }

    public Processo retornaProcesso(Integer numeroProcesso){
        Processo processoRetorno = new Processo();
        for(Processo processo : processos){
            if(numeroProcesso == processo.getNumeroProcesso()){
                processoRetorno = processo;
                break;
            }
        }
        return processoRetorno;
    }


    public String retornaProcessoJson(Integer numeroProcesso){
        String processoRetorno = null;
        Gson gson = new Gson();
        for(Processo processo : processos){
            if(numeroProcesso == processo.getNumeroProcesso()){

                processoRetorno = gson.toJson(processo);
                break;
            }
        }

        return processoRetorno;
    }

    public Processo  retornaProcessoObj(String json){

        Gson gson = new Gson();
        Processo processo = gson.fromJson(json, Processo.class);
        return processo;
    }

}
