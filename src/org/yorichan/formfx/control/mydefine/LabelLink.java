package org.yorichan.formfx.control.mydefine;

import javafx.scene.Cursor;
import javafx.scene.control.Label;
import java.io.IOException;

/**
 * Created by YoriChan on 2017/4/25
 * A special Label that linked to a url
 */
public class LabelLink extends Label {

    String url;

    public LabelLink(String text) {
        this(text, null);
    }

    public LabelLink(String text, String url) {
        super(text);
        this.setCursor(Cursor.HAND);
        this.setOnMouseEntered(e -> {
            this.setStyle("-fx-text-fill:dodgerblue");
            this.setUnderline(true);
        });
        this.setOnMouseExited(e -> {
            this.setStyle("-fx-text-fill:black");
            this.setUnderline(false);
        });
        if (url != null)
            this.setOnMouseClicked(a -> {
                try {
                    Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
