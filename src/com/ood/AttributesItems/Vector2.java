package com.ood.AttributesItems;

/**
 * A 2d data type
 */
public class Vector2 {
    public Vector2(){
        this.row = 0;
        this.col = 0;
    }

    public Vector2(int row, int col) {
        this.row = row;
        this.col = col;
    }

    private int row;
    private int col;

    public Vector2(Vector2 position) {
        this.row=position.getRow();
        this.col=position.getCol();
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
