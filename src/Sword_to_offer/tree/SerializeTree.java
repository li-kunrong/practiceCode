package Sword_to_offer.tree;

public class SerializeTree {
    public static void main(String[] args){
     String a = "123,445,453";
     String []b = a.split(",");
//        System.out.println(b);
        System.out.println(a);
    }

    int index = -1;
    String Serialize(TreeNode root) {
        StringBuffer buffer = new StringBuffer();
        if (root == null){
            buffer.append("#,");
            return buffer.toString();
        }

        buffer.append(root.val+",");
        buffer.append(Serialize(root.left));
        buffer.append(Serialize(root.right));
        return buffer.toString();
    }
    TreeNode Deserialize(String str) {
        index++;
        TreeNode node = null;
        String[] s = str.split(",");
        while(!s[index].equals("#")){
            node = new TreeNode(Integer.valueOf(s[index]));
            node.left = Deserialize(str);//这个开始比较难理解，因为已经有index控制，不用分析到哪里了
            node.right = Deserialize(str);
        }
        return node;
    }
}
