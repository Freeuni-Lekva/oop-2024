import shared.ArrayListStudentDao;
import shared.Command;
import shared.Student;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    private String address;
    private int port;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public Client(int port){
        this.port = port;
        address = "localhost";
    }

    public void start(){
        new Thread(() -> {
            try {
                Socket socket = new Socket(address, port);
                out = new ObjectOutputStream(socket.getOutputStream());
                in = new ObjectInputStream(socket.getInputStream());
                System.out.println("client side socket's destination port: " + socket.getPort());
                System.out.println("client side socket's local port: " + socket.getLocalPort());

                out.writeObject(Command.ECHO);
                out.writeObject("my test string");
                System.out.println(in.readObject());

                out.writeObject(Command.CREATE);
                Student student = new Student(100,"nika", "urchadze", 2022);
                out.writeObject(student);
//                System.out.println((Student) in.readObject());



            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}
