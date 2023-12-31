package org.app.DataStore;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.*;

@AllArgsConstructor
@Getter
public class OBJDataAdapter implements DataAdapter{
    private Loadable obj;

    @Override
    public void saveData(String fileLocation) throws Exception {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileLocation));
        outputStream.writeObject(obj.getData());
        outputStream.flush();
        outputStream.close();
    }

    @Override
    public void loadData(String fileLocation) throws Exception {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileLocation));
        obj.setData(obj.getClass().cast(inputStream.readObject()));
        inputStream.close();
    }
}
