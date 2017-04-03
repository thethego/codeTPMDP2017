package pacman.elements;

/**
 * Created by menros on 03/04/17.
 */
public class Position2D {
    private int posX;
    private int posY;

    public Position2D(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position2D that = (Position2D) o;

        if (posX != that.posX) return false;
        return posY == that.posY;
    }

    @Override
    public int hashCode() {
        int result = posX;
        result = 31 * result + posY;
        return result;
    }
}
