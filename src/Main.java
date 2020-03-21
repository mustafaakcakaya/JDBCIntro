import java.sql.*;
import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;

        try {
            connection = helper.getConnection();
            String sql = "delete from city where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,4085);
            System.out.println(statement.executeUpdate() +" satır etkilendi.\nKayıt güncellendi.");

        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        finally {
            statement.close();
            connection.close();
            System.out.println("-------Bağlantı Kapandı.---------");
        }

    }


    public static void  updateDbObject() throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;

        try {
            connection = helper.getConnection();
            String sql = "Update city set Population = 100000, District = 'Turkey', Name = 'Düzce' where id = ?";
            statement = connection.prepareStatement(sql);
            statement.setInt(1,4085);
            System.out.println(statement.executeUpdate() +" satır etkilendi.\nKayıt güncellendi.");

        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        finally {
            statement.close();
            connection.close();
            System.out.println("-------Bağlantı Kapandı.---------");
        }
    }


    public  static void  insertDbObject() throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        PreparedStatement statement = null;

        try {
            connection = helper.getConnection();
            String sql = "Insert into city (Name, CountryCode,District,Population) values(?,?,?,?)";
            statement = connection.prepareStatement(sql);
            statement.setString(1,"Düzce 2");
            statement.setString(2,"TUR");
            statement.setString(3,"Turkey");
            statement.setInt(4,70000);
            System.out.println(statement.executeUpdate() +" satır etkilendi.");
            System.out.println("Kayıt Eklendi.");

        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        finally {
            statement.close();
            connection.close();
            System.out.println("-------Bağlantı Kapandı.---------");
        }
    }
    public static void writeDbObjects() throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;

        try {
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet  = statement.executeQuery("select Code, Name, Continent, Region from country");
            ArrayList<Country> countries = new ArrayList<Country>();

            while (resultSet.next()){
                countries.add(new Country(  resultSet.getString("Code"),
                        resultSet.getString("Name"),
                        resultSet.getString("Continent"),
                        resultSet.getString("Region")));
            }

        } catch (SQLException exception) {
            helper.showErrorMessage(exception);
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        finally {
            connection.close();
            System.out.println("-------Bağlantı Kapandı.---------");
        }
    }
}
