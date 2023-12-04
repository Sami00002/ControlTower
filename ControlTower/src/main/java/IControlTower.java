interface IControlTower {
    void register(IAirplane plane);
    boolean canTakeOff(IAirplane plane);
    boolean canLand(IAirplane plane);
    void hasLanded(IAirplane plane);
    void hasTakeOff(IAirplane plane);
}