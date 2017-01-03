package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;
import java.util.Calendar;

public class TesteInsere {
    public static void main(String[] args) {
        //pronto para gravar 
        Contato contato = new Contato();
        contato.setNome("Caelum");
        contato.setEmail("contato@caelum.com.br");
        contato.setEndereco("R. Vergueiro 3185 cj57");
        contato.setDataNascimento(Calendar.getInstance());
        
        //grave nessa conexão!!!
        ContatoDAO dao = new ContatoDAO();
        
        //método elegante
        dao.adicona(contato);
        System.out.println("Gravado!");
        
    }
    
}
