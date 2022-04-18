/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.company.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.company.db.ConexionDb;
import pe.company.vo.Persona;

/**
 *
 * @author dilve
 */
public class PersonaDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public List<Persona> listarPersonas(int limite){
    List<Persona> lista = new ArrayList<Persona>();
    try {
            String query = "select * from persona " + "limit " + limite;
            conn = ConexionDb.MySQL();            
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                Persona item = new Persona();
                item.setId(rs.getInt("id_persona"));
                item.setNombres(rs.getString("nombres"));
                item.setApellidos(rs.getString("apellidos"));
                lista.add(item);
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
    return lista;
    }
    
    public List<Persona> buscarPersonaPorRedSocial(String nombreRedSocial, int limite){
    List<Persona> lista = new ArrayList<Persona>();
    try {
            String query = 
                    "select p.*, prs.cuenta, rs.nombre from persona p " +
                    "inner join persona_red_social prs on p.id_persona = prs.id_persona " +
                    "inner join red_social rs on rs.id_red_social = prs.id_red_social " +
                    "where rs.nombre = '" + nombreRedSocial + "' " +
                    "limit " + limite
                    ;
            conn = ConexionDb.MySQL();            
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                Persona item = new Persona();
                item.setId(rs.getInt("p.id_persona"));
                item.setNombres(rs.getString("p.nombres"));
                item.setApellidos(rs.getString("p.apellidos"));
                item.setCuentaRedSocial(rs.getString("prs.cuenta"));
                lista.add(item);
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
    return lista;
    }
}
