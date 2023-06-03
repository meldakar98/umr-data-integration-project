import Model.McDonalds;
import Model.Training;
import utils.Dataholder;
import utils.Verwaltung;

public class main {
    public static void main(String[] args) {
        Verwaltung v=new Verwaltung();
        v.init();
        System.out.println(Dataholder.getInstance().getLaender().size());

        System.out.println(Dataholder.getInstance().getTraining().get(2).getCommaSeparatedString());
        System.out.println(Training.getAttributes());

    }
}
