package test.dmisb.toothpick.data.model;

public class Poster {
    private int firstPoster;
    private int firstImage;
    private int secondPoster;
    private int secondImage;

    public Poster(int firstPoster, int firstImage) {
        this.firstPoster = firstPoster;
        this.firstImage = firstImage;
    }

    public int getFirstPoster() {
        return firstPoster;
    }

    public void setFirstPoster(int firstPoster) {
        this.firstPoster = firstPoster;
    }

    public int getFirstImage() {
        return firstImage;
    }

    public void setFirstImage(int firstImage) {
        this.firstImage = firstImage;
    }

    public int getSecondPoster() {
        return secondPoster;
    }

    public void setSecondPoster(int secondPoster) {
        this.secondPoster = secondPoster;
    }

    public int getSecondImage() {
        return secondImage;
    }

    public void setSecondImage(int secondImage) {
        this.secondImage = secondImage;
    }
}
