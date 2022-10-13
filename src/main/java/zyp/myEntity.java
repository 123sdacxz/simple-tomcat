package zyp;

import org.dom4j.Element;

/**
 * 对应配置文件中的<servlet-name>
 *               <servlet-class>
 */
public class myEntity {
    private String name;
    private String cla;

    public myEntity() {

    }

    public myEntity(String name ,String cla) {
        this.name = name;
        this.cla = cla;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCla() {
        return cla;
    }

    public void setCla(String cla) {
        this.cla = cla;
    }
}
