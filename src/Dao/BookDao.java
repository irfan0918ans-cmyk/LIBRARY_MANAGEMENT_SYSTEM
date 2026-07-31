package Dao;

import model.Author;
import model.Book;
import utils.DbConnection;

import java.sql.*;

public class BookDao {
    public void addBook(Book bookObject) {
        try{
            Connection con = DbConnection.getConnection();
            String insertQuery = "insert into book_tb (name, edition,price,author_id) values (?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(insertQuery);
            ps.setString(1,bookObject.getName());
            ps.setString(2,bookObject.getEdition());
            ps.setDouble(3,bookObject.getPrice());
            ps.setInt(4,bookObject.getAuthor().getId());

            int rowUpdate = ps.executeUpdate();
            System.out.println("Row updated ! "+ rowUpdate);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Book getBookByName(String bookName){
        String sql = "Select * from book_tb where ( name ) =?";
        Book retrivedBook = null;
        String nameRetrived = null;
        double priceRetrived = 0.0;
        String editionRetrived =  null;
        Author authorRetrived = null;
        int authorId =0;

        try(Connection connection = DbConnection.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setString(1, bookName);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                nameRetrived = resultSet.getString("name");
                priceRetrived = resultSet.getDouble("price");
                editionRetrived = resultSet.getString("edition");

                authorId= resultSet.getInt("author_id");
                authorRetrived = new Author("Unknown");
                authorRetrived.setId(authorId);

                retrivedBook = new Book(nameRetrived,priceRetrived,editionRetrived,authorRetrived);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return retrivedBook;
    }

    public void deleteBookByName(String bookName){
        String delquery = "delete from book_tb where ( name ) = ?";

        try(Connection connection = DbConnection.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(delquery);){
            preparedStatement.setString(1, bookName);
            int rowUpdate = preparedStatement.executeUpdate();

            System.out.println("No of rows Updated : " + rowUpdate);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void getAllBook(){
        String query = "Select * from book_tb";
        try(Connection connection = DbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ){
            ResultSet rs = ps.executeQuery();

            System.out.println();
            System.out.println("|----------------------------------------------------------|");
            System.out.println("|                       Book Records                       |");
            System.out.println("|----------------------------------------------------------|");

            System.out.printf("%-5s %-20s %-10s %-15s %-10s%n","ID", "BOOK", "PRICE", "EDITION", "AUTHOR");
            System.out.println("------------------------------------------------------------");

            while(rs.next()){
                System.out.printf("%-5s %-20s %-10s %-15s %-10s%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getString("edition"),
                        rs.getInt("author_id"));

            }
            System.out.println("------------------------------------------------------------");
            System.out.println();


        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void updateBookByEditionAndPrice(String bookName, String bookEdition, double price){
        String query ="update book_tb set edition = ?, price = ? where name = ?";

        try( Connection conn = DbConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(query);
             ){
            ps.setString(1, bookEdition);
            ps.setDouble(2, price);
            ps.setString(3, bookName);

            int rowUpdate = ps.executeUpdate();
            System.out.println("Row updated ! "+ rowUpdate);

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
}
