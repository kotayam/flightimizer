public class Tuple {
    private int destCityId;
    private float duration;

    public Tuple(int destCityId, float duration) {
        this.destCityId = destCityId;
        this.duration = duration;
    }

    public int getId() {
        return this.destCityId;
    }

    public float getDuration() {
        return this.duration;
    }

    public void setDuration(float newDur) {
        this.duration = newDur;
    }
}
