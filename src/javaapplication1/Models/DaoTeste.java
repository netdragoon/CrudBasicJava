
package javaapplication1.Models;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoTeste 
{
    private final Connection connection;
    public DaoTeste(Connection connection) 
    {
        this.connection = connection;
    }    
    public Teste add(Teste value) throws SQLException
    {
        String sql = "INSERT INTO teste(nome, endereco, sexo, cpf) VALUES(?,?,?,?);";
        PreparedStatement stmt = this.connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, value.getNome());
        stmt.setString(2, value.getEndereco());
        stmt.setString(3, value.getSexo().name());
        stmt.setString(4, value.getCpf());
        stmt.executeUpdate();
        ResultSet key = stmt.getGeneratedKeys();
        if (key.next())
            value.setId(key.getInt(1));        
        return value;
    }    
    public boolean edit(Teste value) throws SQLException
    {
        String sql = "UPDATE teste SET nome=?, endereco=?, sexo=?, cpf=? where id=?";
        PreparedStatement stmt = this.connection.prepareStatement(sql);
        stmt.setString(1, value.getNome());
        stmt.setString(2, value.getEndereco());
        stmt.setString(3, value.getSexo().name());
        stmt.setString(4, value.getCpf());
        stmt.setInt(5, value.getId());
        return stmt.execute();
    }    
    public Teste find(int id) throws SQLException
    {
        Teste t = null;
        String sql = "SELECT * FROM teste where id=?";
        PreparedStatement stmt = this.connection.prepareStatement(sql);        
        stmt.setInt(1, id);
        ResultSet query = stmt.executeQuery();
        if (query.next())
        {
            t = new Teste();
            t.setId(query.getInt("id"));
            t.setNome(query.getString("nome"));
            t.setEndereco(query.getString("endereco"));
            t.setCpf(query.getString("cpf"));
            t.setSexo(Enum.valueOf(Sexo.class, query.getString("Sexo")));
        }
        return t;
    }    
    public List<Teste> all() throws SQLException
    {
        List<Teste> t = new ArrayList<>();        
        String sql = "SELECT * FROM teste ORDER BY id";
        PreparedStatement stmt = this.connection.prepareStatement(sql);                
        ResultSet query = stmt.executeQuery();
        Teste at = null;
        while (query.next())
        {
            at = new Teste();            
            at.setId(query.getInt("id"));
            at.setNome(query.getString("nome"));
            at.setEndereco(query.getString("endereco"));
            at.setCpf(query.getString("cpf"));
            at.setSexo(Enum.valueOf(Sexo.class, query.getString("Sexo")));
            t.add(at);
        }
        return t;
    }
}
