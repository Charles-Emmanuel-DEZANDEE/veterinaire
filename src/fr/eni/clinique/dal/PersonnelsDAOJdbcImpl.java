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

public class PersonnelsDAOJdbcImpl implements Dao{

    private Connection connect;

    public PersonnelsDAOJdbcImpl() throws DALException, BLLException {
        //connections à la base de donnée

        this.connect = ConnectionSingleton.getConnection().getConnect();


    }


    // fait par MAHMOUDI
    public void insert(Object r2) throws DALException {
        Personnels r1 = (Personnels) r2;

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
            PreparedStatement stmt = this.connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                   
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
                //on ferme les connections
                stmt.close();
                //connect.close();

            }

        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    public Personnels selectById(int id) throws DALException {
    	try{
	        String sql = "SELECT * FROM Personnels WHERE CodePers = ?";
	        PreparedStatement stmt = this.connect.prepareStatement(sql);
	
	        stmt.setInt(1,id);//"reference,
	
	        ResultSet res = stmt.executeQuery();
	
	        Personnels data = null;

         	if (res.next()){
                data = new Personnels(res.getInt("CodePers"),
                		res.getString("Nom"),
                		res.getString("MotPasse"),
                		res.getString("Role"),
                		res.getBoolean("Archive"));
	        //on ferme les connections
	        stmt.close();
	        //connect.close();
             }

         	return data;

        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    public List<Personnels> selectAll() throws DALException {
        try{
            String sql = "SELECT * FROM Personnels";
            PreparedStatement stmt = this.connect.prepareStatement(sql);


            ResultSet res = stmt.executeQuery();
            //on boucle sur les résultats
            List<Personnels> data = new ArrayList<>();
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
            //connect.close();

            return data;

        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }

    }

    public void update(Object r2) throws DALException {
    	Personnels r1 = (Personnels) r2;
        try {
            String sql = "UPDATE Personnels  SET " +
                    "Nom =?," +
                    "MotPasse =?," +
                    "Role =?," +
                    "Archive =? " +
                    "WHERE CodePers =?"
                    ;
            PreparedStatement stmt = this.connect.prepareStatement(sql);

            stmt.setInt(1,r1.getCodePers());//"CodePers,
            stmt.setString(2,r1.getNom());//"Nom,
            stmt.setString(3,r1.getMotPasse());//"MotPasse,
            stmt.setString(4, r1.getRole());//"Role,\
            stmt.setBoolean(5,r1.isArchive());//"Archive,


            // on update
            stmt.executeUpdate();

            //on ferme les connections
            stmt.close();
            //connect.close();


        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }

    }

    public void delete(int CodePers) throws DALException {
        try {
        String sql = "DELETE FROM Personnels WHERE CodePers = ?";
        PreparedStatement stmt = this.connect.prepareStatement(sql);

        stmt.setInt(1,CodePers);//"reference,

        stmt.executeUpdate();
            //on ferme les connections
            stmt.close();
            //connect.close();


        } catch (SQLException e) {
        throw new DALException(e.getMessage());
	    }
	}
    
             
	public void finalize() throws SQLException {
	    connect.close();
	}
	

}
