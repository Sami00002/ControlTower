interface IAirplane {
    void requestTakeOff();
    void completeTakeOff();
    void requestLanding();
    void completeLanding();
    String getName();
    boolean canLand();
    boolean canTakeOff();
}