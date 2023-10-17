import java.sql.*;

public class Main {
    public static final String CREATETABLEQUERY="DROP TABLE Employee IF EXISTS; create table Employee(empId INTEGER , empName varchar2(50), empSalary NUMBER )";
    public static final String INSERTQUERY1="INSERT INTO EMPLOYEE VALUES (1,'Swastik',10000)";
    public static final String INSERTQUERY2="INSERT INTO EMPLOYEE VALUES (2,'Sufian',30000)";
    public static final String INSERTQUERY3="INSERT INTO EMPLOYEE VALUES (3,'Niteesh',20000)";

    public static final String SELECTQUERY="SELECT * FROM EMPLOYEE;";

    public static final String UPDATEQUERY="update EMPLOYEE SET EMPNAME='Akhilesh' WHERE EMPID=1";

    public static final String DELETEQUERY="delete from EMPLOYEE WHERE EMPID=3";

    public static void main(String[] args)  {

        try
        {
            int i=1;

            Connection connection= DriverManager.getConnection("jdbc:h2:./db","root","password");

            Statement statement= connection.createStatement();

            statement.execute(CREATETABLEQUERY);
            statement.executeUpdate(INSERTQUERY1);
            statement.executeUpdate(INSERTQUERY2);
            statement.executeUpdate(INSERTQUERY3);

            ResultSet resultSet=statement.executeQuery(SELECTQUERY);

            while (resultSet.next())
            {
                System.out.println("My Emp "+i++ +" ID:-"+resultSet.getInt("empId")+"\t"+"NAME:-"
                        +resultSet.getString(2)
                        +" salary:-"+ resultSet.getFloat(3));
            }

            int count=statement.executeUpdate(UPDATEQUERY);
            System.out.println(count+" rows affected");

            int j=1;
            ResultSet resultSet1=statement.executeQuery(SELECTQUERY);

            while (resultSet1.next())
            {
                System.out.println("My Emp "+j++ +" ID:-"+resultSet1.getInt("empId")+"\t"+"NAME:-"
                        +resultSet1.getString(2)
                        +" salary:-"+ resultSet1.getFloat(3));
            }

            int count1=statement.executeUpdate(DELETEQUERY);
            System.out.println(count1+" rows affected");

            int k=1;
            ResultSet resultSet2=statement.executeQuery(SELECTQUERY);

            while (resultSet2.next())
            {
                System.out.println("My Emp "+k++ +" ID:-"+resultSet2.getInt("empId")+"\t"+"NAME:-"
                        +resultSet2.getString(2)
                        +" salary:-"+ resultSet2.getFloat(3));
            }

        }
        catch (SQLException sqlException)
        {
            System.out.println("SQLException handler"+sqlException.getMessage());
        }

    }

}