package by.bsac.practice_8.gem;

public class Gem {
    private String name;
    private boolean preciousness;
    private String origin;

    private String color;
    private int transparency;
    private int facet;

    public Gem() {
        // empty;
    }

    public Gem(String name, boolean preciousness, String origin, String color, int transparency, int facet) {
        this.name = name;
        this.preciousness = preciousness;
        this.origin = origin;
        this.color = color;
        this.transparency = transparency;
        this.facet = facet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isPreciousness() {
        return preciousness;
    }

    public void setPreciousness(boolean preciousness) {
        this.preciousness = preciousness;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTransparency() {
        return transparency;
    }

    public void setTransparency(int transparency) {
        this.transparency = transparency;
    }

    public int getFacet() {
        return facet;
    }

    public void setFacet(int facet) {
        this.facet = facet;
    }

    @Override
    public String toString() {
        return "Gem{" +
                "name='" + name + '\'' +
                ", preciousness=" + preciousness +
                ", origin='" + origin + '\'' +
                ", color='" + color + '\'' +
                ", transparency=" + transparency +
                ", facet=" + facet +
                "}\n";
    }
}
