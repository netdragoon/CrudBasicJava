/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.sql.SQLException;
import javaapplication1.Models.Connect;
import javaapplication1.Models.DaoTeste;
import javaapplication1.Models.Sexo;
import javaapplication1.Models.Teste;
import jdk.nashorn.internal.objects.NativeArray;

/**
 *
 * @author Developer
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     * @throws java.lang.ClassNotFoundException
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        Teste t = new Teste();   
        t.setId(2);
        t.setCpf("11111111111");
        t.setEndereco("Endereco");
        t.setNome("Nome");
        t.setSexo(Sexo.FEMININO);
        
        DaoTeste daoTeste = new DaoTeste(Connect.getInstance());
        Teste taa = daoTeste.find(1);
                
        for(Teste tr :daoTeste.all())
        {
            System.out.println(tr.getNome() + " " + tr.getSexo());
        }
        
        
        
    }
    
}
