package fr.eni.clinique.dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;

public class AnimauxDAOJdbcImpl implements DaoAnimaux{

   
    public void insert(Animaux a1) throws DALException {

        try (Connection connect = ConnectionSingleton.getConnect()) {
            String sql = "INSERT INTO Animaux(" +
		                    "NomAnimal," +
		                    "Sexe," +
		                    "Couleur," +
		                    "Race," +
		                    "Espece," +
		                    "CodeClient," +
		                    "Tatouage," +
		                    "Antecedents," +
		                    "Archive" + 
		                    ")" +
	                     "VALUES (" +
		                    "?,"+
		                    "?,"+
		                    "?,"+
		                    "?,"+
		                    "?,"+
		                    "?,"+
		                    "?,"+
		                    "?,"+
		                    "?"+
		                    ")";
	        PreparedStatement stmt = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);          
	        stmt.setString(1,a1.getNomAnimal());
	        stmt.setString(2,a1.getSexe());
	        stmt.setString(3,a1.getCouleur());
	        stmt.setString(4,a1.getRace());
	        stmt.setString(5,a1.getEspece());
	        stmt.setInt(6, a1.getCodeClient());
	        stmt.setString(7,a1.getTatouage());
	        stmt.setString(8,a1.getAntecedents());
	        stmt.setBoolean(9, a1.isArchive());
	
	        int nbRows = stmt.executeUpdate();
	        if (nbRows == 1){
	            ResultSet rs = stmt.getGeneratedKeys();
	            if (rs.next()){
	            	a1.setCodeAnimal(rs.getInt(1));
	            }
//	            stmt.close();
	        }
	      //on ferme les connections
            stmt.close();
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    public Animaux selectById(int id) throws DALException {

    	try (Connection connect = ConnectionSingleton.getConnect()){
	        String sql = "SELECT * FROM Animaux WHERE CodeAnimal = ?";
	        PreparedStatement stmt = connect.prepareStatement(sql);
	
	        stmt.setInt(1,id);//"reference,
	
	        ResultSet res = stmt.executeQuery();
	
	        Animaux data = null;

	        if (res != null){
	        	if (res.next()){
	                data = new Animaux(res.getInt("CodeAnimal"),
			                		   res.getString("NomAnimal"),
			                		   res.getString("Sexe"),
			                		   res.getString("Couleur"),
			                		   res.getString("Race"),
			                		   res.getString("Espece"),
			                		   res.getInt("CodeClient"),
			                		   res.getString("Tatouage"),
			                		   res.getString("Antecedents"),
			                		   res.getBoolean("Archive"));
		        stmt.close();
	            }
	        	//on ferme les connections
	         	return data;
	        }else{
	        	//on ferme les connections
                stmt.close();
	        	return null;
	        }
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    public List<Animaux> selectAll() throws DALException {
    	try (Connection connect = ConnectionSingleton.getConnect()){
            String sql = "SELECT * FROM Animaux";
            PreparedStatement stmt = connect.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
            List<Animaux> data = new ArrayList<>();
            if (res != null){
            	int i = 0;
                while (res.next()){
                        data.add(new Animaux(res.getInt("CodeAnimal"),
				                       		 res.getString("NomAnimal"),
					                		 res.getString("Sexe"),
					                		 res.getString("Couleur"),
					                		 res.getString("Race"),
					                		 res.getString("Espece"),
					                		 res.getInt("CodeClient"),
					                		 res.getString("Tatouage"),
					                		 res.getString("Antecedents"),
					                		 res.getBoolean("Archive")));
                        i++;
                }
                stmt.close();
              //on ferme les connections
                connect.close();
                return data;
            }else{
            	//on ferme les connections
                stmt.close();
            	return null;
            }
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

	public List<Animaux> selectAminauxByClient(Clients client)throws DALException{

		try(Connection connect = ConnectionSingleton.getConnect()){
			String sql = "SELECT * FROM Animaux WHERE client = ? and Archive = FALSE ";
			PreparedStatement stmt = connect.prepareStatement(sql);

			stmt.setInt(1,client.getCodeClient());//"reference,
			ResultSet res = stmt.executeQuery();
			//on boucle sur les résultats
			List<Animaux> data = new ArrayList<>();
			while (res.next()){
				data.add(new Animaux(res.getInt("CodeAnimal"),
						res.getString("NomAnimal"),
						res.getString("Sexe"),
						res.getString("Couleur"),
						res.getString("Race"),
						res.getString("Espece"),
						res.getInt("CodeClient"),
						res.getString("Tatouage"),
						res.getString("Antecedents"),
						res.getBoolean("Archive")));
			}
			//on ferme les connections
			stmt.close();
			return data;

		} catch (SQLException e) {
			throw new DALException(e.getMessage());
		}
	}


	public void update(Animaux a1) throws DALException {
    	try (Connection connect = ConnectionSingleton.getConnect()) {
            String sql = "UPDATE Animaux  SET " +
                    "NomAnimal =?," +
                    "Sexe =?," +
                    "Couleur =?," +
                    "Race =?," +
                    "Espece =?," +
                    "CodeClient =?," +
                    "Tatouage =?," +
                    "Antecedents =?," +
                    "Archive =? " +
                    "WHERE CodeAnimal =?";
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setString(1,a1.getNomAnimal());
			stmt.setString(2,a1.getSexe());
			stmt.setString(3,a1.getCouleur());
			stmt.setString(4,a1.getRace());
			stmt.setString(5,a1.getEspece());
			stmt.setInt(6,a1.getCodeClient());
			stmt.setString(7,a1.getTatouage());
			stmt.setString(8,a1.getAntecedents());
			stmt.setBoolean(9, a1.isArchive());
			stmt.setInt(10,a1.getCodeAnimal());

			stmt.executeUpdate();
         
			//on ferme les connections
            stmt.close();
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    public void delete(int CodeAnimal) throws DALException {

    	try (Connection connect = ConnectionSingleton.getConnect()){
	        String sql = "DELETE FROM Animaux WHERE CodeAnimal = ?";
	        PreparedStatement stmt = connect.prepareStatement(sql);
	        stmt.setInt(1,CodeAnimal);
	        stmt.executeUpdate();
	        
	        //on ferme les connections
            stmt.close();
        } catch (SQLException e) {
        	throw new DALException(e.getMessage());
	    }
	}
    
    public Animaux selectByNom(String NomAnimal) throws DALException {

    	try(Connection connect = ConnectionSingleton.getConnect()){
	        String sql = "SELECT * FROM Animaux WHERE NomAnimal = ?";
	        PreparedStatement stmt = connect.prepareStatement(sql);
	        stmt.setString(1,NomAnimal);
	        ResultSet res = stmt.executeQuery();
	        Animaux data = null;
	        if(res != null){
	        	if (res.next()){
	                data = new Animaux(res.getInt("CodeAnimal"),
                      		 res.getString("NomAnimal"),
	                		 res.getString("Sexe"),
	                		 res.getString("Couleur"),
	                		 res.getString("Race"),
	                		 res.getString("Espece"),
	                		 res.getInt("CodeClient"),
	                		 res.getString("Tatouage"),
	                		 res.getString("Antecedents"),
	                		 res.getBoolean("Archive"));
		        stmt.close();
	             }
	        	//on ferme les connections
	         	return data;
	        }else{
	        	//on ferme les connections
                stmt.close();
	        	return null;
	        }
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }
	
}
