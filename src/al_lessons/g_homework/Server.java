package al_lessons.g_homework;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private static Socket socket;

    public static void main(String[] args) {

        openConnection();
        sendMessage();

    }

    public static void openConnection() {

        try (ServerSocket serverSocket = new ServerSocket(8189)) {
            System.out.println("Сервер запущен, ожидаем подключения...");

            socket = serverSocket.accept();
            System.out.println("Клиент подключился");

            DataInputStream din = new DataInputStream(socket.getInputStream());

            Thread connectionThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (true) {
                            String strFromClient = din.readUTF();
                            if (strFromClient.equalsIgnoreCase("/end")) {
                                break;
                            }
                            System.out.println("Client: " + strFromClient);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
            connectionThread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendMessage() {
        try {
            DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
            Scanner scanner = new Scanner(System.in);

            while (scanner.hasNext()) {
                String message = scanner.nextLine();
                if (message.equalsIgnoreCase("/end")) {
                }
                try {
                    dout.writeUTF(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

