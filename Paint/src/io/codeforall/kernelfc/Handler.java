package io.codeforall.kernelfc;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Handler implements KeyboardHandler {

    Grid grid;

    Pencil pencil;

    GridPosition gridPosition;

    Keyboard keyboard;

    public Handler() {
        pencil = new Pencil();
        grid = new Grid();
        initPaint();
        keyboard = new Keyboard(this);
        gridPosition = new GridPosition(10, 10);
        createKeyboardEvents();
    }

    public void initPaint() {
    }

    public void createKeyboardEvents() {

        KeyboardEvent keyboardEventRight = new KeyboardEvent();
        keyboardEventRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyboardEventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventRight);

        KeyboardEvent keyboardEventLeft = new KeyboardEvent();
        keyboardEventLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyboardEventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventLeft);

        KeyboardEvent keyboardEventUp = new KeyboardEvent();
        keyboardEventUp.setKey(KeyboardEvent.KEY_UP);
        keyboardEventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventUp);

        KeyboardEvent keyboardEventDown = new KeyboardEvent();
        keyboardEventDown.setKey(KeyboardEvent.KEY_DOWN);
        keyboardEventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventDown);

        KeyboardEvent keyboardEventSpace = new KeyboardEvent();
        keyboardEventSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyboardEventSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventSpace);

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        int distanceToMove;
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                if (pencil.gridPosition.getX() <= 40) {
                    distanceToMove = 0;
                } else {
                    distanceToMove = -40;
                }
                this.pencil.move(distanceToMove, 0);
                this.pencil.gridPosition.setX(this.pencil.rectangle.getX());
                //System.out.println(pencil.gridPosition.getGridPosition());
                break;
            case KeyboardEvent.KEY_RIGHT:
                if (pencil.gridPosition.getX() >= 960) {
                    distanceToMove = 0;
                } else {
                    distanceToMove = 40;
                }
                this.pencil.move(distanceToMove, 0);
                this.pencil.gridPosition.setX(this.pencil.rectangle.getX());
                //System.out.println(pencil.gridPosition.getGridPosition());
                break;
            case KeyboardEvent.KEY_UP:
                if (pencil.gridPosition.getY() <= 40) {
                    distanceToMove = 0;
                } else {
                    distanceToMove = -40;
                }
                this.pencil.move(0, distanceToMove);
                this.pencil.gridPosition.setY(this.pencil.rectangle.getY());
                break;
            case KeyboardEvent.KEY_DOWN:
                if (pencil.gridPosition.getY() >= 960) {
                    distanceToMove = 0;
                } else {
                    distanceToMove = 40;
                }
                this.pencil.move(0, distanceToMove);
                this.pencil.gridPosition.setY(this.pencil.rectangle.getY());
                break;
            case KeyboardEvent.KEY_SPACE:
                grid.paint( pencil.getY()/Grid.getCellSize(), pencil.getX()/Grid.getCellSize());
                break;

        }
    }




}
