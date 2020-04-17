package com.company;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, ParseException {
        Set<Student> studentSet= new HashSet<>();
        String json ="src\\main\\java\\com\\company\\Students";
        String xml ="src\\main\\java\\com\\company\\Students.xml";
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document = documentBuilder.parse(xml);
        Node root = document.getDocumentElement();
        NodeList students = root.getChildNodes();

        for (int i = 0; i < students.getLength(); i++) {
            Node student = students.item(i);
            NodeList studentChildren = student.getChildNodes();
            if (students.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Student st = new Student();
                for (int j = 0; j < studentChildren.getLength(); j++) {
                    Node studentChildrenElement = studentChildren.item(j);
                    if (studentChildrenElement.getNodeType() == Node.ELEMENT_NODE) {
                        try {
                            st.setField(studentChildrenElement.getNodeName(),
                                    studentChildrenElement.getChildNodes().item(0).getNodeValue());
                        }
                        catch (IllegalArgumentException e){
                            e.getStackTrace();
                        }
                    }
                }
                studentSet.add(st);
            }
        }

        studentSet.forEach((v)->System.out.println(v));

        studentSet.clear();
        FileReader reader = new FileReader(json);

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
        JSONArray jsonArray = (JSONArray) jsonObject.get("Students");

        for(Object element : jsonArray){
            Student st = new Student();
            JSONObject el = (JSONObject) element;
            st.setField("name", (String) el.get("name"));
            st.setField("surname", (String) el.get("surname"));
            st.setField("group", (String) el.get("group"));
            st.setField("university", (String) el.get("university"));
            st.setField("faculty", (String) el.get("faculty"));
            studentSet.add(st);
        }
        studentSet.forEach((v)->System.out.println(v));
    }
}
