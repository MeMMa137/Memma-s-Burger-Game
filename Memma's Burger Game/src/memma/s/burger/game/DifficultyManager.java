public class DifficultyManager {

    private int difficultyLevel;
    private int paniniSpeed;
    private int paniniCount;

    public DifficultyManager() {
        this.difficultyLevel = 1;
        updateDifficulty();
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
        updateDifficulty();
    }

    private void updateDifficulty() {
        switch (difficultyLevel) {
            case 1:
                paniniSpeed = 5;
                paniniCount = 5;
                break;
            case 2:
                paniniSpeed = 10;
                paniniCount = 10;
                break;
            case 3:
                paniniSpeed = 15;
                paniniCount = 15;
                break;
            default:
                paniniSpeed = 5;
                paniniCount = 5;
                break;
        }
    }

    public int getPaniniSpeed() {
        return paniniSpeed;
    }

    public int getPaniniCount() {
        return paniniCount;
    }
}
