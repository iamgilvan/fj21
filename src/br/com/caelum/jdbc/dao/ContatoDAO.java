package br.com.caelum.jdbc.dao;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
    
    public List<Contato> getLista(){
        try {
            List<Contato> contatos = new ArrayList<Contato>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from contatos");
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                //criando objeto contato
                Contato contato = new Contato();
                contato.setId(rs.getLong("id"));
                contato.setNome(rs.getString("nome"));
                contato.setEmail(rs.getString("email"));
                contato.setEndereco(rs.getString("endereco"));
                
                //montadno a data através do calendar
                Calendar data = Calendar.getInstance();
                data.setTime(rs.getDate("dataNascimento"));
                contato.setDataNascimento(data);
                
                //adicionando objetos a lista
                contatos.add(contato);
            }
            rs.close();
            stmt.close();
            return contatos;
        } catch (Exception e) {
            throw new RuntimeException(e);
                    
        }
    }
}
