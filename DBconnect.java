package Project;
import javax.swing.*;
import java.sql.*;

public class DBconnect {
    private Connection con;
    private Statement st;

    private ResultSet rs;

    private int flag=0;
    public DBconnect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp", "root", "");
            st = con.createStatement();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void RegisterInsert(String queryInsert) throws SQLException {
        st.executeUpdate(queryInsert);
        JOptionPane.showMessageDialog(null,"Registered");
        new SignIn();
    }

    public int Login(String queryLogin,String email,String pass) throws SQLException {
        rs= st.executeQuery(queryLogin);

        while(rs.next())
        {
             String TableEmail = rs.getString(4);
             String TablePass = rs.getString(6);

             if(email.equals(TableEmail) && pass.equals(TablePass))
             {
                 flag=1;
                 break;
             }
        }
        return flag;
    }

    public int DuplicateEmailCheck(String DuplicateCheck,String Email) throws SQLException {
        int f=0;

        rs = st.executeQuery(DuplicateCheck);

        while(rs.next())
        {
            String TableEmail = rs.getString(4);
            if(Email.equals(TableEmail))
            {
                f=1;
                break;
            }
        }


        return f;
    }
    public int DuplicateMobileCheck(String DuplicateCheck,String Mobile) throws SQLException {
        int f=0;

        rs = st.executeQuery(DuplicateCheck);

        while(rs.next())
        {
            String TableMobile = rs.getString(3);
            if(Mobile.equals(TableMobile))
            {
                f=1;
                break;
            }
        }


        return f;
    }

    public int FP(String ForgetPass,String Mobile) throws SQLException {
        int f=0;

        rs = st.executeQuery(ForgetPass);

        while(rs.next())
        {
            String TableMobile = rs.getString(3);
            if(Mobile.equals(TableMobile))
            {
                f=1;
                break;
            }
        }


        return f;
    }

    public void passUpdate(String sql) throws SQLException {
        st.executeUpdate(sql);
    }

    public void setProfile(String sql,String email) throws SQLException {
        rs=st.executeQuery(sql);

        rs.next();
        String username = rs.getString("Username");
        String mobile = rs.getString("Mobile");

//        new Profile(username,email,mobile);
        Profile.setVal(username,email,mobile);

    }

    public void DeleteAcc(String sql) throws SQLException {
        st.executeUpdate(sql);
        JOptionPane.showMessageDialog(null, "Your Account is Deleted Successfully.");
        new SignIn();
    }
}

