public boolean handleCommand(Command command) {
        if (command == null) {
            throw new IllegalArgumentException("Command cannot be null");
        }
        return command.execute(this);
    }

    public boolean updatePosition(int nrSteps) {
        if (nrSteps < 0) {
            throw new IllegalArgumentException("Number of steps cannot be negative");
        }

        int newX = this.position.getX();
        int newY = this.position.getY();

        switch (this.currentDirection) {
            case NORTH -> newY += nrSteps;
            case EAST -> newX += nrSteps;
            case SOUTH -> newY -= nrSteps;
            case WEST -> newX -= nrSteps;
        }

        Position newPosition = new Position(newX, newY);
        if (isPositionAllowed(newPosition)) {
            this.position = newPosition;
            return true;
        }
        return false;
    }