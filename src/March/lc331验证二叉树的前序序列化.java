package March;

/**
 * Description:
 * User: zhangcheng
 * Date: 2021-03-12
 * Time: 15:33
 */
public class lc331验证二叉树的前序序列化 {
    public boolean isValidSerialization(String preorder) {
        // 计算入度出度。
        if (preorder.equals("#") ){
            return true;
        }
        String[] ss = preorder.split(",");
        int len = ss.length;
        int inDegree = 0, outDegree = 0;
        for (int i = 0; i < len; i++) {
            // 根节点提供两个out，0个in
            // 非根非空节点提供2个out，1个in。
            // 空节点提供1个in.
            if (i == 0) { // 根节点
                if (ss[i].equals("#")) { // #,#,1 这样的 是非法的
                    return false;
                }
                outDegree += 2; // 根节点  出度+2
                continue;
            }
            if (ss[i].equals("#")){
                inDegree++;
            }else if (i != 0){
                outDegree += 2;
                inDegree++;
            }
            if (i != len - 1 && inDegree >= outDegree){
                return false;
            }
        }
        return inDegree == outDegree;
    }

}
