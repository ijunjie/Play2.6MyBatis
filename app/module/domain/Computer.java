package module.domain;

public class Computer {


    public Computer(String name, String id, String introduced, String discontinuted) {
        this.name = name;
        this.id = id;
        this.introduced = introduced;
        this.discontinuted = discontinuted;
    }

    private String name;
    public String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIntroduced() {
        return introduced;
    }

    public void setIntroduced(String introduced) {
        this.introduced = introduced;
    }

    public String getDiscontinuted() {
        return discontinuted;
    }

    public void setDiscontinuted(String discontinuted) {
        this.discontinuted = discontinuted;
    }

    private String introduced;
    private String discontinuted;


}
