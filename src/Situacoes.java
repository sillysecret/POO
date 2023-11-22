
public enum Situacoes {
    Pendente, 
    Locada, 
    Cancelada, 
    Finalizada,
    Erro;
    ;

public Situacoes getSituacao(String s){
    if(s.equals("Pendente")){
        return this.Pendente;
    }
    if(s.equals("Locada")){
        return this.Locada;
    }
    if(s.equals("Cancelada")){
        return this.Cancelada;
    }
    if(s.equals("Finalizada")){
        return this.Finalizada;
    }else{
        return Erro;
    }


}

}
