package cn.payingcloud.weixin.mp.menu;

/**
 * @author YQ.Huang
 */
public class WxClickButton extends WxButton {

    private String key;

    public WxClickButton(String name, String key) {
        super("click", name);
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
