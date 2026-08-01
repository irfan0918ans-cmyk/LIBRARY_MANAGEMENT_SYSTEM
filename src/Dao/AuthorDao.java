package Dao;

import model.Author;
import utils.DbConnection;
import Exception.AuthorNotFoundException;

import java.sql.*;

public class AuthorDao {
    public void addAuthor(String author_name){
        String sqlQuery = "insert into author_tb (name) values (?)";
        
        try ( Connection connection = DbConnection.getConnection();
              PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)
        ){
            preparedStatement.setString(1,author_name);
            int row = preparedStatement.executeUpdate();
            
            System.out.println("Row updated"+ row);

        }catch(Exception e){
            System.out.println("Exception occurred in AddAuthor Block");
            e.printStackTrace();

        }
    }

    public static Author getAuthorByName(String authorName){
        String sql = "select * from author_tb where ( name ) = ?";
        Author retriveAuthor = null;
        String nameRetrived = null;
        int idRetrived = 0;

        try(Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ){
            preparedStatement.setString(1,authorName);
            ResultSet resultSet=preparedStatement.executeQuery();

            if(resultSet.next()){
                idRetrived = resultSet.getInt("id");
                nameRetrived=resultSet.getString("name");
                retriveAuthor = new Author(nameRetrived);
                retriveAuthor.setId(idRetrived);
            }else{
                throw new AuthorNotFoundException();
            }
        }catch(AuthorNotFoundException e){
            System.out.println("Author not found");
        }catch (Exception e){
            e.printStackTrace();
        }
        return retriveAuthor;
    }

    public void delAuthor(String authorName){
        String query = "delete from author_tb where ( name ) = ?";

        try( Connection con = DbConnection.getConnection();
        PreparedStatement preparedStatement = con.prepareStatement(query)){
            preparedStatement.setString(1,authorName);

            int rowUpdate = preparedStatement.executeUpdate();
            System.out.println("Row updated"+ rowUpdate);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void getAllAuthor(){
        try(Connection con = DbConnection.getConnection();
        Statement st = con.createStatement();)
        {
            String query = "Select * from author_tb";
            ResultSet rs = st.executeQuery(query);

            System.out.println();
            System.out.println("|-------------------------|");
            System.out.println("|     Author Records      |");
            System.out.println("|-------------------------|");


            System.out.printf("%-5s %-25s %n","ID", "AUTHOR NAME");
            System.out.println("---------------------------");


            while(rs.next()){
                System.out.printf("%-5s %-25s %n",
                        rs.getInt("id"),
                        rs.getString("name"));
            }
            System.out.println("---------------------------");

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateAuthor(String prevName, String updatedName){

        String updateQuery  = "update author_tb set name = ? where name =? ";

        try(Connection connection = DbConnection.getConnection();
        PreparedStatement ps = connection.prepareStatement(updateQuery);)
        {
            ps.setString(2,prevName);
            ps.setString(1,updatedName);

            int rowUpdate = ps.executeUpdate();
            System.out.println("Row updated"+ rowUpdate);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
}
