package org.simulation.project.entities;

public class Tree extends Entity {
    public Tree(Coordinates coordinates) {
        super(coordinates);
    }
    @Override
    public String getSymbol() {
        return "🌳"; // Эмоджи дерева
    }
}
