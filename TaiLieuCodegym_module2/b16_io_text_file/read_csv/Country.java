package b16_io_text_file.read_csv;

public class Country {
    String startIp;
    String endIp;
    String x;
    String y;
    String code;
    String name;

    public Country(String startIp, String endIp, String x, String y, String code, String name) {
        this.startIp = startIp;
        this.endIp = endIp;
        this.x = x;
        this.y = y;
        this.code = code;
        this.name = name;
    }

    public String getStartIp() {
        return startIp;
    }

    public void setStartIp(String startIp) {
        this.startIp = startIp;
    }

    public String getEndIp() {
        return endIp;
    }

    public void setEndIp(String endIp) {
        this.endIp = endIp;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.startIp + "," + this.endIp + "," + this.x + "," + this.y +
                "," + this.code + "," + this.name;
    }
}
