package com.ood.Buff;

import com.ood.Characters.ICharacter;

/**
 * Encapsulated all of the Buff methods
 * @param <T>
 */
public interface IBuff<T extends ICharacter> {
    void doEffect(T character);
}
