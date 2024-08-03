import java.io.*;

public class GameSaveManager {

    public void saveGameState(GameState state) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("game_state.ser"))) {
            oos.writeObject(state);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public GameState loadGameState() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("game_state.ser"))) {
            return (GameState) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new GameState(); 
        }
    }
}

