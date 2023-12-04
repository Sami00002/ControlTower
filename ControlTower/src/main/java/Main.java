public class Main {
    public static void main(String[] args) {
        IControlTower tower = new ControlTower();

        IAirplane plane1 = new Airplane("A2", tower);
        IAirplane plane2 = new Airplane("B4", tower);
        IAirplane plane3 = new Airplane("C9", tower);

        tower.register(plane1);
        tower.register(plane2);
        tower.register(plane3);

        plane1.requestLanding();
        plane2.requestLanding();
        plane3.requestLanding();

        plane2.completeLanding();
        plane1.completeLanding();

        plane3.requestLanding();
        plane3.completeLanding();

        plane2.completeLanding();
        plane3.completeLanding();
    }
}