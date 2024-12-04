package org.simulation.project.entities;

public abstract class Creature extends Entity {
    // имеет скорость (сколько клеток может пройти за 1 ход)
    // количество HP
    protected int hp; // Здоровье
    protected int speed; // Скорость

    public Creature(Coordinates coordinates, int hp, int speed) {
        super(coordinates);
        this.hp = hp;
        this.speed = speed;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSpeed() {
        return speed;
    }

    public abstract void makeMove();
}
