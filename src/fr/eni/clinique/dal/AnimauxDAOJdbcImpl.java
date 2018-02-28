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

public class AnimauxDAOJdbcImpl implements Dao{

    private Connection connect;

    public AnimauxDAOJdbcImpl() throws DALException, BLLException {
        this.connect = ConnectionSingleton.getConnection().getConnect();
    }

    public void insert(Object a2) throws DALException {
    	Animaux a1 = (Animaux) a2;
        try {
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
		                    "?,"+
		                    ")";
        PreparedStatement stmt = this.connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);          
        stmt.setString(1,a1.getNomAnimal());
        stmt.setString(2,a1.getSexe());
        stmt.setString(3,a1.getCouleur());
        stmt.setString(4,a1.getRace());
        stmt.setString(5,a1.getEspece());
        stmt.setLong(6,a1.getCodeClient());
        stmt.setString(7,a1.getTatouage());
        stmt.setString(8,a1.getAntecedents());
        stmt.setBoolean(9, a1.isArchive());

        int nbRows = stmt.executeUpdate();
        if (nbRows == 1){
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()){
            	a1.setCodeAnimal(rs.getInt(1));
            }
            stmt.close();
        }
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    public Animaux selectById(int id) throws DALException {
    	try{
	        String sql = "SELECT * FROM Personnels WHERE CodePers = ?";
	        PreparedStatement stmt = this.connect.prepareStatement(sql);
	
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
			                		   res.getLong("CodeClient"),
			                		   res.getString("Tatouage"),
			                		   res.getString("Antecedents"),
			                		   res.getBoolean("Archive"));
		        stmt.close();
	            }
	         	return data;
	        }else{
	        	return null;
	        }
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    public List<Animaux> selectAll() throws DALException {
        try{
            String sql = "SELECT * FROM Animaux";
            PreparedStatement stmt = this.connect.prepareStatement(sql);
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
					                		 res.getLong("CodeClient"),
					                		 res.getString("Tatouage"),
					                		 res.getString("Antecedents"),
					                		 res.getBoolean("Archive")));
                        i++;
                }
                stmt.close();
                return data;
            }else{
            	return null;
            }
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

	public List<Animaux> selectAminauxByClient(Clients client)throws DALException{
		try{
			String sql = "SELECT * FROM Animaux WHERE client = ?";
			PreparedStatement stmt = this.connect.prepareStatement(sql);

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
						res.getLong("CodeClient"),
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


	public void update(Object a2) throws DALException {
    	Animaux a1 = (Animaux) a2;
        try {
            String sql = "UPDATE Animaux  SET " +
                    "NomAnimal =?," +
                    "Sexe =?," +
                    "Couleur =?," +
                    "Race =?," +
                    "Espece =?," +
                    "CodeClient =?," +
                    "Tatouage =?," +
                    "Antecedents =?," +
                    "Archive =?" +
                    "WHERE CodeAnimal =?";
            PreparedStatement stmt = this.connect.prepareStatement(sql);
            stmt.setString(1,a1.getNomAnimal());
			stmt.setString(2,a1.getSexe());
			stmt.setString(3,a1.getCouleur());
			stmt.setString(4,a1.getRace());
			stmt.setString(5,a1.getEspece());
			stmt.setLong(6,a1.getCodeClient());
			stmt.setString(7,a1.getTatouage());
			stmt.setString(8,a1.getAntecedents());
			stmt.setBoolean(9, a1.isArchive());
			stmt.setInt(10,a1.getCodeAnimal());
			stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    public void delete(int CodeAnimal) throws DALException {
        try {
	        String sql = "DELETE FROM Animaux WHERE CodeAnimal = ?";
	        PreparedStatement stmt = this.connect.prepareStatement(sql);
	        stmt.setInt(1,CodeAnimal);
	        stmt.executeUpdate();
	        stmt.close();
        } catch (SQLException e) {
        	throw new DALException(e.getMessage());
	    }
	}
    
    public Animaux selectByNom(String NomAnimal) throws DALException {
    	try{
	        String sql = "SELECT * FROM Animaux WHERE NomAnimal = ?";
	        PreparedStatement stmt = this.connect.prepareStatement(sql);
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
	                		 res.getLong("CodeClient"),
	                		 res.getString("Tatouage"),
	                		 res.getString("Antecedents"),
	                		 res.getBoolean("Archive"));
		        stmt.close();
	             }
	         	return data;
	        }else{
	        	return null;
	        }
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }
	public void finalize() throws SQLException {
	    connect.close();
	}
}
