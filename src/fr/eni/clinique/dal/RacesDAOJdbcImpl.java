package fr.eni.clinique.dal;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bo.Races;
import fr.eni.clinique.bo.Clients;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class RacesDAOJdbcImpl implements DaoRaces {


    public void insert(Races a1) throws DALException {

        try (        Connection connect = ConnectionSingleton.getConnect()        ){
            String sql = "INSERT INTO Races(" +
                    "Race," +
                    "Espece" +
                    ")" +
                    "VALUES (" +
                    "?," +
                    "?" +
                    ")";
            PreparedStatement stmt = connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, a1.getRace());
            stmt.setString(2, a1.getEspece());

            int nbRows = stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    public Races selectByPK(String race, String espece) throws DALException {
        try (            Connection connect = ConnectionSingleton.getConnect()
        ){

            String sql = "SELECT * FROM Races WHERE Race = ? and Espece = ?";
            PreparedStatement stmt = connect.prepareStatement(sql);

            stmt.setString(1, race);//"race,
            stmt.setString(2, espece);//"espece,

            ResultSet res = stmt.executeQuery();

            Races data = null;

            if (res != null) {
                if (res.next()) {
                    data = new Races(res.getString("Race"),
                            res.getString("Espece")
                    );
                    stmt.close();
                }
                return data;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    public List<String> getListRaceByEspece(String espece) throws DALException {
        try (            Connection connect = ConnectionSingleton.getConnect()        ){

            String sql = "SELECT Race FROM Races WHERE Espece = ?";
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setString(1, espece);//"race,

            ResultSet res = stmt.executeQuery();
            List<String> data = new ArrayList<>();
            if (res != null) {
                int i = 0;
                while (res.next()) {
                    data.add(res.getString("Race")
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

    public List<String> getListEspece() throws DALException {
        try (            Connection connect = ConnectionSingleton.getConnect()       ){

            String sql = "SELECT DISTINCT Espece FROM Races";
            PreparedStatement stmt = connect.prepareStatement(sql);
//            stmt.setString(1, espece);//"race,

            ResultSet res = stmt.executeQuery();
            List<String> data = new ArrayList<>();
            if (res != null) {
                int i = 0;
                while (res.next()) {
                    data.add(res.getString("Espece")
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


    @Override
    public Races selectById(Long id) throws DALException {
        return null;
    }

    public List<Races> selectAll() throws DALException {
        try (            Connection connect = ConnectionSingleton.getConnect()        ) {

            String sql = "SELECT * FROM Races";
            PreparedStatement stmt = connect.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
            List<Races> data = new ArrayList<>();
            if (res != null) {
                int i = 0;
                while (res.next()) {
                    data.add(new Races(
                                    res.getString("Race"),
                                    res.getString("Espece")
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


    public void update(Races a2) throws DALException {
    }

    public void delete(String race, String espece) throws DALException {
        try (            Connection connect = ConnectionSingleton.getConnect()       ){

            String sql = "DELETE FROM Races WHERE Race = ? and Espece = ?";
            PreparedStatement stmt = connect.prepareStatement(sql);
            stmt.setString(1, race);
            stmt.setString(2, espece);
            stmt.executeUpdate();
            stmt.close();
            connect.close();
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

}
