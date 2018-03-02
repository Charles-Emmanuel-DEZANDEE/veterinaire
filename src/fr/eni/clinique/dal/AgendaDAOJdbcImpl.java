package fr.eni.clinique.dal;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bo.Races;
import fr.eni.clinique.dto.RDV;
import fr.eni.clinique.bo.Agendas;
import fr.eni.clinique.bo.Clients;
import fr.eni.clinique.bo.Personnels;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class AgendaDAOJdbcImpl implements DaoAgenda {


    public void insert(Agendas a1) throws DALException {

        try (        Connection connect = ConnectionSingleton.getConnect()        ){
            String sql = "INSERT INTO Agendas(" +
                    "CodeVeto," +
                    "DateRdv," +
            		"CodeAnimal" +
            		")" +
                    "VALUES (" +
                    "?," +
                    "?," +
                    "?" +
                    ")";
            PreparedStatement stmt = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, a1.getCodeVeto());
            stmt.setDate(2, a1.getDateRdv());
            stmt.setLong(3, a1.getCodeAnimal());

            int nbRows = stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    
    public List<RDV> getRDVByVetEtDate(int codeVet, Date dateRDV) throws DALException {
        try (            Connection connect = ConnectionSingleton.getConnect()        ){

            String sql = "select" + 
		    "agd.CodeVeto," + 
		    "agd.CodeAnimal," +
		    "agd.DateRdv," +
		    "cli.NomClient," +
		    "anx.NomAnimal," +
		    " anx.Race" +
		    "from Agendas agd" +
		    "join Animaux anx on (agd.CodeAnimal = anx.CodeAnimal)" +
		    "join Clients cli on (cli.CodeClient = anx.CodeClient)" +
		    "where agd.CodeVeto = ?" + // 1 codeVeto 
		    "and " +
		    "DAY(agd.DateRdv) = DAY('?')" + // 2 date
		    "and " +
		    "MONTH(agd.DateRdv) = MONTH('?')" + // 3 date
		    "and " +
		    "YEAR(agd.DateRdv) = YEAR('?')"; // 4 date
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setInt(1, codeVet);//"codeVeto,
            stmt.setDate(1, dateRDV);//date
            stmt.setDate(1, dateRDV);//date,
            stmt.setDate(1, dateRDV);//date

            ResultSet res = stmt.executeQuery();
            
            //on boucle sur les résultats
            List<RDV> data = new ArrayList<>();
            
            if (res != null){
            	int i = 0;
                while (res.next()){
                        data.add
                        (
                        	new RDV(
                        			res.getLong("CodeVeto"), 
                        			res.getDate("DateRdv"), 
                        			res.getLong("CodeAnimal"), 
                        			res.getString("nomClient"), 
                        			res.getString("nomAnimal"), 
                        			res.getString("race")
                        			)
                        );
                        i++;
                }

                //on ferme les connections
                stmt.close();
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

    
    public List<Agendas> selectAll() throws DALException {
        try (            Connection connect = ConnectionSingleton.getConnect()        ) {

            String sql = "SELECT * FROM Agendas";
            PreparedStatement stmt = connect.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
            List<Agendas> data = new ArrayList<>();
            if (res != null) {
                int i = 0;
                while (res.next()) {
                    data.add(new Agendas(
                                    res.getLong("CodeVeto"),
                                    res.getDate("DateRdv"),
                                    res.getLong("CodeAnimal")
                            )
                    );
                    i++;
                }
                stmt.close();
                return data;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }
    
    
    
    
    


    public void update(Agendas a2) throws DALException {
    }

    public void delete(Agendas agenda) throws DALException {
        try (            Connection connect = ConnectionSingleton.getConnect()       ){

            String sql = "DELETE FROM Races WHERE CodeVeto = ? and DateRdv = ? and CodeAnimal = ?";
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setLong(1, agenda.getCodeVeto());
            stmt.setDate(2, agenda.getDateRdv());
            stmt.setLong(3, agenda.getCodeAnimal());
            stmt.executeUpdate();
            stmt.close();
            connect.close();
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

	@Override
	public Agendas selectById(int id) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}


}
