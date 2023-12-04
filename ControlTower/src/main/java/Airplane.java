class Airplane implements IAirplane {
    private String name;
    private IControlTower tower;
    private boolean canTakeOff;
    private boolean canLand;

    public Airplane(String name, IControlTower tower) {
        this.name = name;
        this.tower = tower;
        canTakeOff = false;
        canLand = false;
    }

    @Override
    public void completeLanding() {
        if (canLand) {
            canLand = false;
            tower.hasLanded(this);
        } else {
            System.out.println(name + " you can't land");
        }
    }

    @Override
    public void completeTakeOff() {
        if (canTakeOff) {
            canTakeOff = false;
            tower.hasTakeOff(this);
        } else {
            System.out.println(name + " you can't take off");
        }
    }

    @Override
    public void requestLanding() {
        canLand = tower.canLand(this);
    }

    @Override
    public void requestTakeOff() {
        canTakeOff = tower.canTakeOff(this);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean canLand() {
        return canLand;
    }

    @Override
    public boolean canTakeOff() {
        return canTakeOff;
    }

    @Override
    public String toString() {
        return name + " -> Land: " + canLand + ", Take off: " + canTakeOff;
    }
}