package org.yorichan.formfx.control;

import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.yorichan.formfx.control.mydefine.LabelLink;
import org.yorichan.formfx.utils.UiUtil;
import java.io.IOException;

/**
 * Created by YoriChan on 2017/4/25
 * Some utils that help you create static controls quickly
 */
public class Static {

    public static Hyperlink hyperlink(String text) {
        return hyperlink(text, null);
    }

    public static Hyperlink hyperlink(String text, String url) {
        Hyperlink hyperlink = new Hyperlink(text);
        if (url != null)
            hyperlink.setOnAction(a -> {
                try {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        return hyperlink;
    }

    public static LabelLink labelLink(String text) {
        return labelLink(text, null);
    }

    public static LabelLink labelLink(String text, String url) {
        return new LabelLink(text, url);
    }

    public static ImageView imageView(Image image) {
        return imageView(-1, -1, image);
    }

    public static ImageView imageView(double width, double height, Image image) {
        ImageView imageView = new ImageView(image);
        if (width != -1)
            imageView.setFitWidth(width);
        if (height != -1)
            imageView.setFitHeight(height);
        return imageView;
    }

    public static ImageView imageView(String path) {
        return imageView(-1, -1, path);
    }

    public static ImageView imageView(double width, double height, String path) {
        ImageView imageView = UiUtil.getImg(path);
        if (width != -1)
            imageView.setFitWidth(width);
        if (height != -1)
            imageView.setFitHeight(height);
        return imageView;
    }

    public static Label label(String text) {
        return label(-1, -1, text);
    }

    public static Label label(double width, double height, String text) {
        Label label = new Label(text);
        label.setWrapText(true);
        if (width != -1)
            label.setMaxWidth(width);
        if (height != -1)
            label.setMaxHeight(height);
        return label;
    }

}
