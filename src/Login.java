import connection.connection;

public class Login {
    public static void main(String[] args) throws Exception {
        connection con = new connection();
        if(con != null){
            System.out.println("connected to database");
        }
    }
}
