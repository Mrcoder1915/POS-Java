import connection.connection;


public class Login {
    public static void main(String[] args) throws Exception {
        addStaff add = new addStaff();
        // add.setVisible(true);
        connection con = new connection();
        if(con != null){
            System.out.println("connected to database");
        }
    }
}
