package org.simulation.project.map;

import org.simulation.project.entities.Coordinates;
import org.simulation.project.entities.Entity;
import org.simulation.project.entities.Sheep;

import java.util.HashMap;
import java.util.Map;

public class GameMap {
    private HashMap<Coordinates, Entity> map;

    public GameMap() {
        map = new HashMap<>();
    }

    void placeEntity(Entity entity, Coordinates coordinates) {
    }


    // Добавить сущность
    // Удалить сущность
    // Получить сущность
    // Отрисовать карту
}