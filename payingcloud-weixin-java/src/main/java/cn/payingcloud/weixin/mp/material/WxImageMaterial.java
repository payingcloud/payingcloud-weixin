package cn.payingcloud.weixin.mp.material;

import java.io.InputStream;

/**
 * @author ZM.Wang
 */
public class WxImageMaterial {

    private final InputStream imageStream;
    private final String contentType;

    public WxImageMaterial(InputStream imageStream, String contentType) {
        this.imageStream = imageStream;
        this.contentType = contentType;
    }

    public InputStream getImageStream() {
        return imageStream;
    }

    public String getContentType() {
        return contentType;
    }
}
