package fr.eni.clinique.dal;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bo.Personnels;

public class PersonnelsDAOJdbcImpl implements DaoPersonnels{



    // fait par MAHMOUDI
    @Override
    public void insert(Personnels r1) throws DALException {
        Connection connect = ConnectionSingleton.getConnect();
        try {
            String sql = "INSERT INTO Personnels (" +
                    "Nom," +       // Nom
                    "MotPasse," +  //MotPasse 
                    "Role," +        //Role
                    "Archive" +    //Archive 
                    
                    ")" +

                    "VALUES (" +
                    "?,"+//"Nom,
                    "?,"+//"MotPasse,
                    "?,"+//"Role,\
                    "?"+//"Archive,
                    ")";
            PreparedStatement stmt = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                   
            stmt.setString(1,r1.getNom());//"Nom,
            stmt.setString(2,r1.getMotPasse());//"MotPasse,
            stmt.setString(3,r1.getRole());//"Role,
            stmt.setBoolean(4, r1.isArchive());//"Archive,\
            
            // on indique le numero d'id auto genéré dans l'objet article
            int nbRows = stmt.executeUpdate();
            if (nbRows == 1){
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()){
                	r1.setCodePers(rs.getInt(1));
                }
            }
            //on ferme les connections
            stmt.close();
            connect.close();
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    public Personnels selectById(int id) throws DALException {
    	Connection connect = ConnectionSingleton.getConnect();
    	try{
	        String sql = "SELECT * FROM Personnels WHERE CodePers = ?";
	        PreparedStatement stmt = connect.prepareStatement(sql);
	
	        stmt.setInt(1,id);//"reference,
	
	        ResultSet res = stmt.executeQuery();
	
	        Personnels data = null;

	        if (res != null){
	        	if (res.next()){
	                data = new Personnels(res.getInt("CodePers"),
	                		res.getString("Nom"),
	                		res.getString("MotPasse"),
	                		res.getString("Role"),
	                		res.getBoolean("Archive"));
		        //on ferme les connections
		        stmt.close();
		        connect.close();
	             }
	         	return data;
	        }else{
	        	//on ferme les connections
		        stmt.close();
		        connect.close();
	        	return null;
	        }
        } 
    	catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    public List<Personnels> selectAll() throws DALException {
    	Connection connect = ConnectionSingleton.getConnect();
    	try{
            String sql = "SELECT * FROM Personnels where Archive='false'";
            PreparedStatement stmt = connect.prepareStatement(sql);


            ResultSet res = stmt.executeQuery();
            //on boucle sur les résultats
            List<Personnels> data = new ArrayList<>();
            
            if (res != null){
            	int i = 0;
                while (res.next()){
                    //data.add(this.selectById(res.getInt("id")));
                        data.add(new Personnels(res.getInt("CodePers"),
                        		res.getString("Nom"),
                        		res.getString("MotPasse"),
                        		res.getString("Role"),
                        		res.getBoolean("Archive")));
                        i++;
                }

                //on ferme les connections
                stmt.close();
                connect.close();

                return data;
            }else{
            	//on ferme les connections
                stmt.close();
                connect.close();
            	return null;
            }
            

        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }

    }

    public void update(Personnels r1) throws DALException {
    	Connection connect = ConnectionSingleton.getConnect();
        try {
            String sql = "UPDATE Personnels  SET " +
                    "Nom =?," +
                    "MotPasse =?," +
                    "Role =?," +
                    "Archive =? " +
                    "WHERE CodePers =?"
                    ;
            PreparedStatement stmt = connect.prepareStatement(sql);

            stmt.setString(1,r1.getNom());//"Nom,
            stmt.setString(2,r1.getMotPasse());//"MotPasse,
            stmt.setString(3, r1.getRole());//"Role,\
            stmt.setBoolean(4,r1.isArchive());//"Archive,
            stmt.setInt(5,r1.getCodePers());//"CodePers,


            // on update
            stmt.executeUpdate();

            //on ferme les connections
            stmt.close();
            connect.close();


        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }

    }

    public void delete(int CodePers) throws DALException {
    	Connection connect = ConnectionSingleton.getConnect();
    	try {
        String sql = "DELETE FROM Personnels WHERE CodePers = ?";
        PreparedStatement stmt = connect.prepareStatement(sql);

        stmt.setInt(1,CodePers);//"reference,

        stmt.executeUpdate();
            //on ferme les connections
            stmt.close();
            connect.close();


        } catch (SQLException e) {
        throw new DALException(e.getMessage());
	    }
	}
    
    public Personnels selectByNom(String nom) throws DALException {
    	Connection connect = ConnectionSingleton.getConnect();
    	try{
	        String sql = "SELECT * FROM Personnels WHERE Nom = ?";
	        PreparedStatement stmt = connect.prepareStatement(sql);
	
	        stmt.setString(1,nom);//"reference,
	
	        ResultSet res = stmt.executeQuery();
	
	        Personnels data = null;
	        if(res != null){
	        	if (res.next()){
	                data = new Personnels(res.getInt("CodePers"),
	                		res.getString("Nom"),
	                		res.getString("MotPasse"),
	                		res.getString("Role"),
	                		res.getBoolean("Archive"));
		        //on ferme les connections
		        stmt.close();
		        connect.close();
	             }
	         	return data;
	        }else{
	        	//on ferme les connections
                stmt.close();
                connect.close();
	        	return null;
	        }
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }
             

}
