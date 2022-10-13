package zyp;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;


import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class myDom {
    private List<myEntity> myEntityList;
    private List<myMapping> myMappingList;

    public myDom() {
        myMappingList = new ArrayList<>();
        myEntityList = new ArrayList<>();
    }

    public myDom(List<myEntity> myEntityList, List<myMapping> myMappingList) {
        this.myEntityList = myEntityList;
        this.myMappingList = myMappingList;
    }

    public List<myEntity> getMyEntityList() {
        return myEntityList;
    }

    public void setMyEntityList(List<myEntity> myEntityList) {
        this.myEntityList = myEntityList;
    }

    public List<myMapping> getMyMappingList() {
        return myMappingList;
    }

    public void setMyMappingList(List<myMapping> myMappingList) {
        this.myMappingList = myMappingList;
    }

    public Document getDocument(){
        SAXReader reader = new SAXReader();
        File  file = new File("D:/ideawork/myTomcat/src/main/webapp/myweb.xml");
       try {
            return reader.read(file);
       }catch (DocumentException e){
           e.printStackTrace();
       }
       return  null;
    }
    public void parseDocument(Document document){
        //得到根标签
        Element rootElement = document.getRootElement();
        //得到多个servlet标签
        Iterator<Element> servlets = rootElement.elementIterator("servlet");
        //对myentity进行封装
        while(servlets.hasNext()){
            Element element = servlets.next();
            Element elementName = element.element("servlet-name");
            Element elementClass = element.element("servlet-class");
            myEntity entity = new myEntity(elementName.getText(),elementClass.getText());
            myEntityList.add(entity);
        }
        //得到多个mapping标签
        Iterator<Element> mappings = rootElement.elementIterator("mapping");
        //对mymapping进行封装
        while(mappings.hasNext()){
            Element element = mappings.next();
            Element elementName = element.element("servlet-name");
            Iterator<Element> elementIterator = element.elementIterator("servlet-url");
            List<String> list = new ArrayList<>();
            while(elementIterator.hasNext()){
                Element elementUrl = elementIterator.next();
                list.add(elementUrl.getText());
            }
            myMapping mapping = new myMapping(elementName.getText(),list);
            myMappingList.add(mapping);
        }

    }
}
