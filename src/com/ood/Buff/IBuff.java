package com.ood.Buff;

import com.ood.Characters.ICharacter;
import com.ood.Enums.CharacterAttributeEnum;

/**
 * Encapsulated all of the Buff methods
 * @param <T>
 */
public interface IBuff<T extends ICharacter> {
    void doEffect(T character);//do effect on characters who use it
    boolean hasAttribute(CharacterAttributeEnum attributeEnum);
}
