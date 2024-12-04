package org.simulation.project.entities;

public class Sheep extends Creature {
    public Sheep(Coordinates coordinates, int hp, int speed) {
        super(coordinates, hp, speed);
    }

    @Override
    public void makeMove() {
        // Логика: поиск травы или случайное перемещение
    }
    // Стремятся найти ресурс (траву), может потратить свой ход на движение в сторону травы, либо на её поглощение
}
