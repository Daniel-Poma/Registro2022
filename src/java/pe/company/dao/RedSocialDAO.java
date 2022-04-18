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
import pe.company.vo.RedSocial;

/**
 *
 * @author dilve
 */
public class RedSocialDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public List<RedSocial> listarRedesSociales(int limite ){
    List<RedSocial> lista = new ArrayList<RedSocial>();
    try {
            String query = "select * from red_social " + "limit " + limite;
            conn = ConexionDb.MySQL();            
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()) {
                RedSocial item = new RedSocial();
                item.setId(rs.getInt("id_red_social"));
                item.setNombre(rs.getString("nombre"));
                lista.add(item);
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
    return lista;
    }
}
