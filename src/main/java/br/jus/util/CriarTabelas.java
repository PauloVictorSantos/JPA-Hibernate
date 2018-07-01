package br.jus.util;

import javax.persistence.Persistence;

/**
 * @author t_paulo.victor
 *
 */
public class CriarTabelas {

	public static void main(String[] args) {
		try{
			Persistence.createEntityManagerFactory("AlgaWorksPU");
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

}
