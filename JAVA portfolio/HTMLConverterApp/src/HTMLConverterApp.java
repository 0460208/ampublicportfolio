/*
 * Author:   Amanda Martel
 * Date:     11/20/2020 
 *
 * Filename:   EmailCreatorApp.java
 * Program will take an HTML list and convert it to normal text format.
 * Program will display both HTML and normal format of the list. 
 * 
 */


public class HTMLConverterApp { //create HTMLConverterApp class 


    public static void main(String[] args) { //create main method 

        //print message 
        System.out.println("HTML Converter");
        //print blank line 
        System.out.println();
 
        //print HTML list 
        System.out.println("INPUT");
        //create html String 
        String html = "<h1>Grocery List</h1>\n" +
                "<ul>\n" +
                "    <li>Eggs</li>\n" +
                "    <li>Milk</li>\n" +
                "    <li>Butter</li>\n" +
                "<ul>"; 
        
        //print the html list 
        System.out.print(html);
        //print blank line 
        System.out.println();
        
        //print blank line 
        System.out.println();
        //print message
        System.out.println("OUTPUT");
 
        //create htmlArray and split html string 
        String[] htmlArray = html.split("\n");
        //initialize groceryList to emplty string 
        String groceryList = "";
        //create arrayOne 
        for (String arrayOne : htmlArray) {
            //trim extra space from arrayOne 
            groceryList += arrayOne.trim() + "\n";
        }
        
        //edit the groceryList to remove HTML tags
        //edit to add asterisk in front of each list item 
        groceryList = groceryList.replace("<h1>", "")
                .replace("</h1>", "")
                .replace("<li>", "*  ")
                .replace("</li>", "")
                .replace("<ul>", "")
                .replace("</ul>", "")
                .replace("\n\n", "\n");
                
        //print the groceryList 
        System.out.println(groceryList);
    }
    
}
