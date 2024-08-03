public class GameStatistics {

    private int totalBurgersClicked;
    private int highestScore;

    public GameStatistics() {
        this.totalBurgersClicked = 0;
        this.highestScore = 0;
    }

    public void updateStatistics(int burgersClicked, int currentScore) {
        this.totalBurgersClicked += burgersClicked;
        if (currentScore > highestScore) {
            highestScore = currentScore;
        }
    }

    public int getTotalBurgersClicked() {
        return totalBurgersClicked;
    }

    public int getHighestScore() {
        return highestScore;
    }
}