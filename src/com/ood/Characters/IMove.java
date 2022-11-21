package com.ood.Characters;

import com.ood.AttributesItems.Vector2;

/**
 * Interface for movable subjectives
 */
public interface IMove {
    Vector2 getPosition();
    void setPosition(Vector2 position);
    void setPosition(int row,int col);

}
