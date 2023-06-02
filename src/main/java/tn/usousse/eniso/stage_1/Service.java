/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tn.usousse.eniso.stage_1;

/**
 *
 * @author rahma
 */

public class Service {
    private Table tab ;

    public Service(Table tab) {
        this.tab = tab;
    }

    public Service() {
    }

    public boolean add(String value) {
    if (find(value)) {
        return false;  
    } else {
        int index = hachage(value);
        Node noeud = new Node(value);

        if (tab.getNodes()[index] == null) {
            tab.getNodes()[index] = noeud;
        } else {
            Node currentNode = tab.getNodes()[index];
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(noeud);
        }

        return true;  
    }
}

    
    
    
    public boolean find(String value) {
    int i = hachage(value);
    Node currentNode = this.tab.getNodes()[i];
    
    while (currentNode != null) {
        if (currentNode.getValue().equals(value)) {
            return true;  
        }
        currentNode = currentNode.getNext();
    }
    
    return false;  
}
    
    
    public void list(){
        for(int i=0;i<this.tab.getNodes().length;i++){
            System.out.print(i+"--");
            Node currentNode = this.tab.getNodes()[i];
            while (currentNode != null) {
                System.out.print(currentNode.getValue()+"--");
                currentNode = currentNode.getNext();
            }
            System.out.println("null");
        }
    }
    
    
    
    
    public int hash1(String value){
        int s=0 ;
        for(char ch:value.toCharArray()){
            s=s+(int)ch;
        }
        return(s%3);
    }

    public int hachage(String value){
        int s=0 ;
        int x=value.length()-1;
        char[] charr = value.toCharArray();
        for(int i =0;i<charr.length;i++){

            s=(int)(s+(int)charr[i]*Math.pow(31,x));
            x=x-1;
        }
        return(s%tab.getNodes().length);
    }

public boolean remove(String value) {
    int index = hachage(value);
    Node currentNode =this.tab.getNodes()[index];
    Node prevNode = null;

    while (currentNode != null) {
        if (currentNode.getValue().equals(value)) {
            if (prevNode == null) {
                this.tab.getNodes()[index] = currentNode.getNext();
            } else {
                prevNode.setNext(currentNode.getNext());
            }
            return true; 
        }
        prevNode = currentNode;
        currentNode = currentNode.getNext();
    }

    return false;  
}


}

