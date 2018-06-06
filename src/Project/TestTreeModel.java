package Project;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

public class TestTreeModel implements TreeModel{
    Node root;
    @Override
    public Node getRoot() {
        return root;
    }

    @Override
    public Node getChild(Object parent, int index) {
        Node node=(Node)parent;

        return node.getChild().get(index);
    }

    @Override
    public int getChildCount(Object parent) {
        Node node=(Node)parent;
        return node.getChild().size();
    }

    @Override
    public boolean isLeaf(Object node) {
        Node target=  (Node)node;
        if(target.getChild().size()==0) return true;
        else return false;
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {

    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        Node node=(Node)parent;
        Node target= (Node)child;
        for(int i=0;i<node.getChild().size();i++){
            if(node.getChild().get(i).getText().equals(target.getText())==true) return i;
        }
        return -1;
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {

    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {

    }
}