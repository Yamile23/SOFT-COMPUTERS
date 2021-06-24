/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dal.Conexion;
import dto.Usuarioprueba;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class UsuarioMysqlDao extends UsuariopruebaDao{

    @Override
    public int insert(Usuarioprueba obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Usuarioprueba obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Usuarioprueba> getList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuarioprueba get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuarioprueba get(String username) {
               try {
            Conexion objConexion = Conexion.getOrCreate();
            String query = "SELECT * FROM tblusuario where username = '" + username + "'";
            ResultSet objResultSet = objConexion.ejecutar(query);
            if (objResultSet.next()) {
                Usuarioprueba obj = new Usuarioprueba();

                String user = objResultSet.getString("username");
                obj.setUsername(user);

                String password = objResultSet.getString("password");
                obj.setPassword(password);

                String correo = objResultSet.getString("correo");
                obj.setCorreo(correo);

                return obj;
            }
        } catch (Exception ex) {
            ;
        }
        return null;
    }
    
}
