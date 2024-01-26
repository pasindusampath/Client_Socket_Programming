package lk.angoda.aliens.soket_test.service;

import javafx.concurrent.Task;

import java.io.*;
import java.net.Socket;

public class ClientSide extends Task<String> {
    Socket socket;

    public ClientSide() throws IOException {
        socket = new Socket("127.0.0.1", 6509);
    }
    @Override
    protected String call() throws Exception {
        while (true){
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String msg = "";
            while ((msg=reader.readLine())!=null){
                updateValue(msg);
                System.out.println(msg);
            }
        }
    }

    public void sendToClient(String msg) throws IOException {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println(msg);
    }
}
