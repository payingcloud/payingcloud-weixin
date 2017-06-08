package cn.payingcloud.weixin.mp.menu;

/**
 * @author YQ.Huang
 */
public abstract class WxButton {

    private final String type;
    private String name;

    public WxButton(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
