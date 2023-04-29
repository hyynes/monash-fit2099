package game.enemies;

public interface Skeleton {
    int getTurnsAfterDeath();
    void setTurnsAfterDeath(int turnsAfterDeath);
    boolean getPileOfBones();
    void setPileOfBones(boolean pileOfBones);
    char getOriginalDisplayChar();

}
