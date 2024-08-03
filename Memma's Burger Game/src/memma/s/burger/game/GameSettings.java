public class GameSettings {

    private int difficultyLevel;
    private int initialTime;
    private int pointsPerBurger;

    public GameSettings() {
        // Impostazioni predefinite
        this.difficultyLevel = 1;
        this.initialTime = 60; 
        this.pointsPerBurger = 10; 
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public int getInitialTime() {
        return initialTime;
    }

    public void setInitialTime(int initialTime) {
        this.initialTime = initialTime;
    }

    public int getPointsPerBurger() {
        return pointsPerBurger;
    }

    public void setPointsPerBurger(int pointsPerBurger) {
        this.pointsPerBurger = pointsPerBurger;
    }

    public void applySettings(GameController controller) {
        controller.setBurgerPoints(pointsPerBurger);
    }
}

