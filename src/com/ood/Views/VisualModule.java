package com.ood.Views;

/**
 * Interface that has both I and O
 */
public interface VisualModule extends ShortOutput,ShortInput{
    void inputReprint(String userInput);
}
