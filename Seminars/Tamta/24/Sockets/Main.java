import shared.ArrayListStudentDao;

public class Main {
    public static void main(String[] args) {
        int port = 12345;

        Client client = new Client(port);
        Server server = new Server(port);

        client.start();
        server.start();
    }
}
