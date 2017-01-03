package br.com.caelum.jdbc.dao;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class ContatoDAO {
    private Connection connection;
    
    public ContatoDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
    
    public void adicona(Contato contato){
        String sql = "insert into contatos " + 
                "(nome,email,endereco,dataNascimento)" +
                " values (?,?,?,?)";
        
        try {
            //prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            //seta os valores
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getNome());
            stmt.setString(4, contato.getEndereco());
            stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
            
            //executa
            stmt.execute();
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
