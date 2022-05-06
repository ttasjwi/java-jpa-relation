package domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "A")
public class Album extends Item {

    private int artist;
    private int etc;

    public int getArtist() {
        return artist;
    }

    public void setArtist(int artist) {
        this.artist = artist;
    }

    public int getEtc() {
        return etc;
    }

    public void setEtc(int etc) {
        this.etc = etc;
    }
}
