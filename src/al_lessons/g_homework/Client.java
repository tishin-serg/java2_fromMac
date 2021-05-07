package al_lessons.g_homework;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private static Socket socket;
    private static Scanner scanner;
    private static DataInputStream din;
    private static DataOutputStream dout;
    private static Thread connectionThread;

    public static void main(String[] args) {

        try {
            openConnection();
            sendMessage();
        } catch (IOException e) {
            e.printStackTrace();
        }

        scanner.close();

    }

    public static void openConnection() throws IOException {

        socket = new Socket("127.0.0.1", 8189);
        din = new DataInputStream(socket.getInputStream());
        dout = new DataOutputStream(socket.getOutputStream());

        scanner = new Scanner(System.in);

        connectionThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        String strFromServer = din.readUTF();
                        if (strFromServer.equalsIgnoreCase("/end")) {
                            break;
                        }
                        System.out.println("Server: " + strFromServer);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        connectionThread.start();
    }

    public static void sendMessage() {
        while (scanner.hasNext()) {
            String message = scanner.nextLine();
            try {
                dout.writeUTF(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
