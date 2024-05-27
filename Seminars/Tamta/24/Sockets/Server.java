import shared.ArrayListStudentDao;
import shared.Command;
import shared.Student;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private int port;
    private ArrayListStudentDao dao;
    public Server(int port){
        dao = new ArrayListStudentDao();
        this.port = port;
    }

    public void start(){
        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(port);
                while(true) {
                    Socket socket = serverSocket.accept();
                    System.out.println("server side socket's destination port: " + socket.getPort());
                    System.out.println("server side socket's local port: " + socket.getLocalPort());
                    handleSocket(socket);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }

    public void handleSocket(Socket socket){
        new Thread(() -> {
            try {
                ObjectInputStream in  = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream out  = new ObjectOutputStream(socket.getOutputStream());

                while (true) {
                    Command command = (Command) in.readObject();
                    switch (command) {
                        case ECHO -> {
                            out.writeObject(in.readObject());
                        }
                        case CREATE -> {
                            Student student = (Student) in.readObject();
                            dao.add(student);
                            out.writeObject(dao.get(100));
                        }
                    }
                }

            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }).start();

    }

}
