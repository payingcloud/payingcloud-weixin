package cn.payingcloud.weixin.mp.menu;

/**
 * @author YQ.Huang
 */
public class WxViewButton extends WxButton {

    private String url;

    public WxViewButton(String name, String url) {
        super("view", name);
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
