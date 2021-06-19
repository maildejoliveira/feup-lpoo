package com.g56.controller.game.movestrategies;

import com.g56.model.game.Position;
import com.g56.utils.RandomGenerator;

public class RandomMoveStrategy implements MoveStrategy{
    @Override
    public Position move(Position position) {
        switch (RandomGenerator.getRandomNumber(0,4)){
            case 0: //left
                return new Position(position.getX()-1, position.getY());
            case 1: //right
                return new Position(position.getX()+1, position.getY());
            case 2: //up
                return new Position(position.getX(), position.getY()-1);
            case 3: //down
                return new Position(position.getX(), position.getY()+1);
        }
        return position;
    }
}
