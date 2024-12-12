package org.simulation.project.entities;

public class Rock extends Entity {
    public Rock(Coordinates coordinates) {
        super(coordinates);
    }
    @Override
    public String getSymbol() {
        return "🪨"; // Эмоджи камня
    }
}
