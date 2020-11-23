package model;

public class Dictionary {
    private String keyWord;
    private String means;

    public Dictionary() {
    }

    public Dictionary(String keyWord, String means) {
        this.keyWord = keyWord;
        this.means = means;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getMeans() {
        return means;
    }

    public void setMeans(String means) {
        this.means = means;
    }
}
