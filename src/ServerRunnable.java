import lab1.AbstractVisitLogFactory;
import lab1.tables.VisitLog;
import service.FileExtensions;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class ServerRunnable implements Runnable {
    private final Socket clientDialog;

    public ServerRunnable(Socket client) {
        clientDialog = client;
    }

    @Override
    public void run() {

        try (ObjectOutputStream out = new ObjectOutputStream(clientDialog.getOutputStream());
             ObjectInputStream in = new ObjectInputStream(clientDialog.getInputStream())) {
            File file = (File) in.readObject();
            String filePath = file.getPath();
            String ext;

            if (filePath.lastIndexOf(".") != -1 && filePath.lastIndexOf(".") != 0)
                ext = filePath.substring(filePath.lastIndexOf(".") + 1);
            else ext = "";
            System.out.println(ext);
            FileExtensions fileExtension = FileExtensions.valueOf(ext.toUpperCase());
            AbstractVisitLogFactory factory = fileExtension.getFactory(filePath);
            List<VisitLog> logs = factory.input();
            out.writeObject(logs);
            clientDialog.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
