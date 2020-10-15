/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esinf;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 *
 * @author DEI-ISEP
 * @param <E> Generic type of buffer element
 */
public class PriorityBufferPrinter<E extends Document> implements Iterable<E> {

    private final ArrayList<E> buffer;
    private final Integer maxSize;

    /**
     * Creates a new PriorityBufferPrinter with a maximum buffer size maxSize
     * 
     * @param maxSize maximum buffer size
     */
    public PriorityBufferPrinter(Integer maxSize) {
        buffer = new ArrayList<>(); // Diamond notation: the type can be inferred by the compiler
        this.maxSize = maxSize;
    }

    /**
     * Adds a document to the buffer.Documents are added using a numeric priority system, being FIFO when priorities are equal.
     * 
     * @param doc   the document to be added to the buffer
     * @return      true if the buffer has space, false otherwise
     */
    public Boolean addDocument(E doc) {
         
        throw new UnsupportedOperationException("Not supported yet.");
        
    }
    
     /**
     * Gets the next document in the queue.
     * 
     * @return The next document in the queue
     */
    public E getDocument() {
      
        throw new UnsupportedOperationException("Not supported yet.");
    } 

    /**
     * Deletes a document from the buffer (if it exists), given a name and an author 
     * 
     * @param name      the name of the Document
     * @param author    the author of the Document
     * @return          true if the document existed, false otherwise
     */
    public Boolean delDocument(String name, String author) {
      
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * Deletes all the documents which are superior to a given size
     * 
     * @param size  the size above which documents will be deleted
     * @return      true if there is at least one Document size
     */
    public Boolean delDocumentsAbove(Integer size) {
      
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Lista de documentos");
        sb.append(System.getProperty("line.separator"));

        for (E doc : buffer) {
            sb.append(doc.toString());
            sb.append(System.getProperty("line.separator"));
        }
        return sb.toString(); 
    }

    @Override
    public Iterator<E> iterator() {
       throw new UnsupportedOperationException("Not supported yet.");
    }

}
