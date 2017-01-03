package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.jdbc.modelo.Contato;
import java.util.List;

public class TestaLista {
    public static void main(String[] args) {
        ContatoDAO dao = new ContatoDAO();
        List<Contato> contatos = dao.getLista();
        
        for (Contato contato : contatos) {
            System.out.println("Nome : " + contato.getNome());
            System.out.println("Email : " + contato.getEmail());
            System.out.println("Endereço : " + contato.getEndereco());
            System.out.println("Data de Nascimento : " + contato.getDataNascimento().getTime() + "\n");
            
        }
    }
    
}
