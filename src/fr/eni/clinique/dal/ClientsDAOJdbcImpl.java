package fr.eni.clinique.dal;

import fr.eni.clinique.bll.BLLException;
import fr.eni.clinique.bo.Animaux;
import fr.eni.clinique.bo.Clients;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientsDAOJdbcImpl implements DaoClients {

    private Connection connect;


    public void insert(Clients c1) throws DALException {
        Connection connect = ConnectionSingleton.getConnect();

        try {
            String sql = "INSERT INTO Clients(" +
                    "NomClient," +
                    "PrenomClient," +
                    "Adresse1," +
                    "Adresse2," +
                    "CodePostal," +
                    "Ville," +
                    "NumTel," +
                    "Assurance," +
                    "Email," +
                    "Remarque," +
                    "Archive" +
                    ")" +
                    "VALUES (" +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?," +
                    "?" +
                    ")";
            PreparedStatement stmt = this.connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, c1.getClient());
            stmt.setString(2, c1.getPrenomClient());
            stmt.setString(3, c1.getAdresse1());
            stmt.setString(4, c1.getAdresse2());
            stmt.setString(5, c1.getCodePostal());
            stmt.setString(6, c1.getVille());
            stmt.setString(7, c1.getNumTel());
            stmt.setString(8, c1.getAssurance());
            stmt.setString(9, c1.getEmail());
            stmt.setString(10, c1.getRemarque());
            stmt.setBoolean(11, c1.isArchive());

            int nbRows = stmt.executeUpdate();
            if (nbRows == 1) {
                ResultSet rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    c1.setCodeClient(rs.getInt(1));
                }
                stmt.close();
                connect.close();
            }
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    public Clients selectById(int id) throws DALException {
        try {
            Connection connect = ConnectionSingleton.getConnect();

            String sql = "SELECT * FROM Clients WHERE CodeClient = ?";
            PreparedStatement stmt = this.connect.prepareStatement(sql);

            stmt.setInt(1, id);//"reference,

            ResultSet res = stmt.executeQuery();

            Clients data = null;

            if (res != null) {
                if (res.next()) {

                    data = new Clients(
                            res.getInt("CodeClient"),
                            res.getString("NomClient"),
                            res.getString("PrenomClient"),
                            res.getString("Adresse1"),
                            res.getString("Adresse2"),
                            res.getString("CodePostal"),
                            res.getString("Ville"),
                            res.getString("NumTel"),
                            res.getString("Assurance"),
                            res.getString("Email"),
                            res.getString("Remarque"),
                            res.getBoolean("Archive")
                    );
                    stmt.close();
                    connect.close();
                }
                return data;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    public List<Clients> selectAll() throws DALException {
        try {
            Connection connect = ConnectionSingleton.getConnect();

            String sql = "SELECT * FROM Clients";
            PreparedStatement stmt = this.connect.prepareStatement(sql);
            ResultSet res = stmt.executeQuery();
            List<Clients> data = new ArrayList<>();
            if (res != null) {
                int i = 0;
                while (res.next()) {
                    data.add(
                            new Clients(
                                    res.getInt("CodeClient"),
                                    res.getString("NomClient"),
                                    res.getString("PrenomClient"),
                                    res.getString("Adresse1"),
                                    res.getString("Adresse2"),
                                    res.getString("CodePostal"),
                                    res.getString("Ville"),
                                    res.getString("NumTel"),
                                    res.getString("Assurance"),
                                    res.getString("Email"),
                                    res.getString("Remarque"),
                                    res.getBoolean("Archive")
                            )
                    );
                    i++;
                }
                stmt.close();
                connect.close();
                return data;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    public void update(Clients a1) throws DALException {
        Connection connect = ConnectionSingleton.getConnect();

        try {

            String sql = "UPDATE Clients  SET " +
                    "NomClient =?," +
                    "PrenomClient =?," +
                    "Adresse1 =?," +
                    "Adresse2 =?," +
                    "CodePostal =?," +
                    "Ville =?," +
                    "NumTel =?," +
                    "Assurance =?," +
                    "Email =?," +
                    "Remarque =?," +
                    "Archive =?" +
                    "WHERE CodeClient =?";
            PreparedStatement stmt = this.connect.prepareStatement(sql);
            stmt.setString(1, a1.getClient());
            stmt.setString(2, a1.getPrenomClient());
            stmt.setString(3, a1.getAdresse1());
            stmt.setString(4, a1.getAdresse2());
            stmt.setString(5, a1.getCodePostal());
            stmt.setString(6, a1.getVille());
            stmt.setString(7, a1.getNumTel());
            stmt.setString(8, a1.getAssurance());
            stmt.setString(9, a1.getEmail());
            stmt.setString(10, a1.getRemarque());
            stmt.setBoolean(11, a1.isArchive());
            stmt.setLong(12, a1.getCodeClient());

            stmt.executeUpdate();
            stmt.close();
            connect.close();
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }

    public void delete(int CodeClient) throws DALException {
        try {
            Connection connect = ConnectionSingleton.getConnect();

            String sql = "DELETE FROM Clients WHERE CodeClient = ?";
            PreparedStatement stmt = this.connect.prepareStatement(sql);
            stmt.setInt(1, CodeClient);
            stmt.executeUpdate();
            stmt.close();
            connect.close();
        } catch (SQLException e) {
            throw new DALException(e.getMessage());
        }
    }


    public void finalize() throws SQLException {
        connect.close();
    }
}
