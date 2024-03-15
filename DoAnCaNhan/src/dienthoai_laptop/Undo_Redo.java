/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dienthoai_laptop;
import java.util.Iterator;
import java.util.Stack;
/**
 *
 * @author Admin
 */
public class Undo_Redo<E> implements Iterable<E>{
    private final Stack<E> stack1;
    private final Stack<E> stack2;
    
    public Undo_Redo()  {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    public void add(E item) {
        stack1.push(item);
        stack2.clear();
    }

    public E undo() {
        if (stack1.size()>1){
            stack2.push(stack1.pop());
            return stack1.get(stack1.size()-1);
        } else {
            return null;
        }
    }

    public E redo() {
        if (!stack2.isEmpty()) {
            E item = stack2.pop();
            stack1.push(item);
            return item;
        }
        return null;
    }
    
    public E getCurrent()   {
        if (stack1.isEmpty()) {
            return null;
        }   else{
            return stack1.get(stack1.size()-1);
        }
    }
    
    public boolean isUndoAble() {
        return stack1.size()>1;
    }

    public boolean isRedoAble() {
        return !stack2.empty();
    }
    
    public void clear() {
        stack1.clear();
        stack2.clear();
    }
    
    public void clearRedo() {
        stack2.clear();
    }
    
    @Override
    public Iterator<E> iterator()   {
        return new MyIterator();
    }

    public class MyIterator implements Iterator<E>  {
        
        private int index = 0;
        
        @Override
        public boolean hasNext()    {
            if (index < stack1.size()) {
                return true;
            }   else if (index < stack1.size()+stack2.size()) {
                return true;
            }   else {
                return false;
            }
        }
        
        @Override
        public E next() {
            if (index < stack1.size())  {
                return stack1.elementAt(index++);
            }else {
                return stack2.elementAt((index++) - stack1.size());
            }
        }
    }
}
