/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dto.Usuarioprueba;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public abstract class UsuariopruebaDao {
    
    	public abstract int insert(Usuarioprueba obj) throws Exception;

	public abstract void update(Usuarioprueba obj) throws Exception;

	public abstract void delete(int id);

	public abstract ArrayList<Usuarioprueba> getList();


	public abstract Usuarioprueba get(int id);
        
	public abstract Usuarioprueba get(String username);
    
}
