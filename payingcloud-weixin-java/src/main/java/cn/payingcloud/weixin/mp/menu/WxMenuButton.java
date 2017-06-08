package cn.payingcloud.weixin.mp.menu;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YQ.Huang
 */
public class WxMenuButton extends WxButton {

    @JsonProperty("sub_button")
    private List<WxButton> subButtons = new ArrayList<>();

    public WxMenuButton(String name) {
        super(null, name);
    }

    public WxMenuButton addButton(WxButton button) {
        subButtons.add(button);
        return this;
    }

    public WxMenuButton addClickButton(String name, String key) {
        return addButton(new WxClickButton(name, key));
    }

    public WxMenuButton addViewButton(String name, String url) {
        return addButton(new WxViewButton(name, url));
    }

    public List<WxButton> getSubButtons() {
        return subButtons;
    }
}
