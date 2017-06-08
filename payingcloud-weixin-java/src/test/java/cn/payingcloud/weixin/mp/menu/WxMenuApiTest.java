package cn.payingcloud.weixin.mp.menu;

import cn.payingcloud.weixin.WxTest;
import org.junit.Test;

/**
 * @author YQ.Huang
 */
public class WxMenuApiTest extends WxTest {

    private WxMenuApi menuApi = new WxMenuApi(CLIENT, ACCESS_TOKEN_PROVIDER);

    @Test
    public void createMenu() throws Exception {
        WxMenu menu = new WxMenu()
                .addButton(new WxViewButton("我要收款", "https://pcashier.payingcloud.cn/account/wx/authorize?state=charge"))
                .addButton(new WxViewButton("我要推广", "https://pcashier.payingcloud.cn/account/wx/authorize"))
                .addButton(new WxMenuButton("更多")
                        .addViewButton("使用帮助", "https://pcashier.payingcloud.cn/help.html")
                        .addViewButton("联系我们", "https://pcashier.payingcloud.cn/contactus.html")
                        .addViewButton("用户协议", "https://pcashier.payingcloud.cn/agreement.html")
                        .addViewButton("好贷", "http://finhd.payingcloud.cn/"));
        menuApi.createMenu(menu);
    }

    @Test
    public void deleteMenu() throws Exception {
        menuApi.deleteMenu();
    }

}