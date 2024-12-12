package org.simulation.project.entities;

public class Grass extends Entity {
    public Grass(Coordinates coordinates) {
        super(coordinates);
    }
    @Override
    public String getSymbol() {
        return "🌱"; // Эмоджи травы
    }
}
