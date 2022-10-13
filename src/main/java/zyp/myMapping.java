package zyp;

import java.util.ArrayList;
import java.util.List;

/**
 * 对应<servlet-name>
 *     <servlet-url>，可以有多个url
 */
public class myMapping {
    private String name;
    private List<String> url;

    public myMapping() {
        url = new ArrayList<>();
    }

    public myMapping(String name, List<String> url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getUrl() {
        return url;
    }

    public void setUrl(List<String> url) {
        this.url = url;
    }
}
