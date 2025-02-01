package entity.island;

import entity.Location;

public class Island {
    private int columnsCount;
    private int rowsCount;

    public Island(int x, int y) {
        this.columnsCount = x;
        this.rowsCount = y;
    }

    public Location[][] locations = new Location[columnsCount][rowsCount];
}
