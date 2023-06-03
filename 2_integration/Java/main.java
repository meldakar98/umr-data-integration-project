import utils.Dataholder;
import utils.Verwaltung;

public class main {
    public static void main(String[] args) {
        Verwaltung v=new Verwaltung();
        v.init();
        System.out.println(Dataholder.getInstance().getLaender().size());

        System.out.println(Dataholder.getInstance().getTraining().size());

    }
}
