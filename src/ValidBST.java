import java.util.ArrayList;
import java.util.List;

public class ValidBST {


    public boolean isValidBST(TreeNode root) {
        List<Integer> inorder = inorder(root);
        return isSorted(inorder);
    }

    public List<Integer> inorder(TreeNode node){
        if(node == null) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        res.addAll(inorder(node.left));
        res.add(node.data);
        res.addAll(inorder(node.right));
        return res;
    }

    public boolean isSorted(List<Integer> l){
        for(int i=1; i<l.size(); i++){
            if(l.get(i) <= l.get(i-1)) return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
