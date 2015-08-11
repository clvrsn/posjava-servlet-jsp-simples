package br.edu.up.posjava.app1.dao;

import br.edu.up.posjava.app1.entities.User;

public class UserDAO {
	
	private static UserDAO userDao = null;
	
	public static UserDAO getInstance(){
		
		if(userDao == null){
			userDao = new UserDAO();
		}
		
		return userDao;
	}
	
	
	public boolean validatePassword(User user){
		
		// Validar senha do usuário no banco de dados
		return true;
		
	}

}
