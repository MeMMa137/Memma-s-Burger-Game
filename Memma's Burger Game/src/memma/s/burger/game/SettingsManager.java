import java.io.*;
import java.util.Properties;

public class SettingsManager {

    private static final String SETTINGS_FILE = "game_settings.properties";
    private Properties properties;

    public SettingsManager() {
        properties = new Properties();
        loadSettings();
    }

    private void loadSettings() {
        try (InputStream input = new FileInputStream(SETTINGS_FILE)) {
            properties.load(input);
        } catch (IOException e) {
            setDefaultSettings();
        }
    }

    private void setDefaultSettings() {
        properties.setProperty("difficultyLevel", "1");
        properties.setProperty("initialTime", "60");
        properties.setProperty("pointsPerBurger", "10");
    }

    public int getDifficultyLevel() {
        return Integer.parseInt(properties.getProperty("difficultyLevel", "1"));
    }

    public void setDifficultyLevel(int level) {
        properties.setProperty("difficultyLevel", String.valueOf(level));
        saveSettings();
    }

    public int getInitialTime() {
        return Integer.parseInt(properties.getProperty("initialTime", "60"));
    }

    public void setInitialTime(int time) {
        properties.setProperty("initialTime", String.valueOf(time));
        saveSettings();
    }

    public int getPointsPerBurger() {
        return Integer.parseInt(properties.getProperty("pointsPerBurger", "10"));
    }

    public void setPointsPerBurger(int points) {
        properties.setProperty("pointsPerBurger", String.valueOf(points));
        saveSettings();
    }

    private void saveSettings() {
        try (OutputStream output = new FileOutputStream(SETTINGS_FILE)) {
            properties.store(output, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
