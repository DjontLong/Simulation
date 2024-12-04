package org.simulation.project.entities;

public class Wolf extends Creature{
private int attackPower; // Сила атаки

    public Wolf(Coordinates coordinates, int hp, int speed, int attackPower) {
        super(coordinates, hp, speed);
        this.attackPower = attackPower;
    }

    public int getAttackPower() {
        return attackPower;
    }

    @Override
    public void makeMove() {
        // Логика: поиск овцы или случайное перемещение
    }
}
