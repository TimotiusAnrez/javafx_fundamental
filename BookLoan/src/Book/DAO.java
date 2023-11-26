package Book;

public interface DAO {
    //abstract method to setup, connect and close database;
    public void setup() throws Exception;
    public void connect() throws Exception;
    public void close() throws Exception;
}
