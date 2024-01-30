package lk.angoda.aliens.soket_test.service;

import com.google.gson.Gson;
import javafx.concurrent.Task;
import lk.angoda.aliens.soket_test.dto.ReceivedData;
import lk.angoda.aliens.soket_test.dto.TransferData;

import java.io.*;
import java.net.Socket;

public class ClientSide extends Task<ReceivedData> {
    Socket socket;

    public ClientSide() throws IOException {
        socket = new Socket("127.0.0.1", 6509);
    }
    @Override
    protected ReceivedData call() throws Exception {
        while (true){
            InputStream inputStream = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String msg = "";
            while ((msg=reader.readLine())!=null){
                updateValue(new ReceivedData(msg));
                System.out.println(msg);
            }
        }
    }

    public void sendToClient(TransferData msg) throws IOException {
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        String sendAbleData = new Gson().toJson(msg);
        System.out.println(sendAbleData);
        out.println(sendAbleData);
    }
}
