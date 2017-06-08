package cn.payingcloud.weixin.mp.menu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YQ.Huang
 */
public class WxMenu {
    private List<WxButton> buttons = new ArrayList<>(3);

    public WxMenu addButton(WxButton button) {
        buttons.add(button);
        return this;
    }

    public WxMenu addClickButton(String name, String key) {
        return addButton(new WxClickButton(name, key));
    }

    public WxMenu addViewButton(String name, String url) {
        return addButton(new WxViewButton(name, url));
    }

    public List<WxButton> getButtons() {
        return buttons;
    }
}
