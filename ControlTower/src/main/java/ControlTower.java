import java.util.ArrayList;
import java.util.List;

class ControlTower implements IControlTower {
    private List<IAirplane> planes = new ArrayList<>();
    private List<IAirplane> lineLand = new ArrayList<>();
    private List<IAirplane> lineTakeOff = new ArrayList<>();

    @Override
    public boolean canLand(IAirplane plane) {
        if (!lineLand.contains(plane))
            lineLand.add(plane);

        for (IAirplane p : planes)
            if (p.canLand())
            {
                System.out.println(p.getName() + " is landing, so " + plane.getName() + " can't");
                return false;
            }
        System.out.println(plane.getName() + " you can land");
        return true;
    }

    @Override
    public boolean canTakeOff(IAirplane plane) {
        if (!lineTakeOff.contains(plane))
            lineTakeOff.add(plane);

        for (IAirplane p : planes)
            if (p.canTakeOff())
            {
                System.out.println(p.getName() + " is taking off, " + plane.getName() + " you can't");
                return false;
            }
        System.out.println(plane.getName() + " you can take off");
        return true;
    }

    @Override
    public void hasLanded(IAirplane plane) {
        System.out.println(plane.getName() + " has landed");
        lineLand.remove(plane);
        if (!lineLand.isEmpty()) {
            lineLand.get(0).requestLanding();
        }
    }

    @Override
    public void hasTakeOff(IAirplane plane) {
        System.out.println(plane.getName() + " has taken off");
        lineTakeOff.remove(plane);
        if (!lineTakeOff.isEmpty()) {
            lineTakeOff.get(0).requestTakeOff();
        }
    }

    @Override
    public void register(IAirplane plane) {
        if (!planes.contains(plane))
            planes.add(plane);
    }
}
