public class BonusManager {

    private ScoreManager scoreManager;

    public BonusManager(ScoreManager scoreManager) {
        this.scoreManager = scoreManager;
    }

    public void checkForBonuses() {
        if (scoreManager.getScore() % 100 == 0) {
            int bonusPoints = 50;
            scoreManager.increaseScore(bonusPoints);
        }
    }
}
