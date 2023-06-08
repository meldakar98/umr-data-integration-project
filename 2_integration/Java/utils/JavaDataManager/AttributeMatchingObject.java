package utils.JavaDataManager;

public class AttributeMatchingObject {
    Double vergleichsWert;
    String VergleichsBasis;
    String VerglichenAuf;

    public AttributeMatchingObject(Double vergleichsWert, String vergleichsBasis, String verglichenAuf) {
        this.vergleichsWert = vergleichsWert;
        VergleichsBasis = vergleichsBasis;
        VerglichenAuf = verglichenAuf;
    }

    public Double getVergleichsWert() {
        return vergleichsWert;
    }

    public String getVergleichsBasis() {
        return VergleichsBasis;
    }

    public String getVerglichenAuf() {
        return VerglichenAuf;
    }
}
