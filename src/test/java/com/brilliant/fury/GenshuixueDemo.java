package com.brilliant.fury;

import com.google.common.collect.Lists;
import java.util.List;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试
 */
public class GenshuixueDemo {

    private static final Logger log = LoggerFactory.getLogger(GenshuixueDemo.class);

    /**
     *   1. 多叉树
     */
    public class TreeNode {
        public TreeNode rootNode = null;
        public List<TreeNode> groupList = null;
        public String str;
    }


    @Test
    public void test() {
        TreeNode root = new TreeNode();
        TreeNode copyRoot = deepCopyRoot(root);
    }

    private TreeNode deepCopyRoot(TreeNode node) {
        TreeNode treeNode = new TreeNode();
        treeNode.str = node.str;
        if (null == node.groupList) {
            return treeNode;
        } else {
            List<TreeNode> nodes = Lists.newArrayList();
            for (TreeNode treeNodeTemp : node.groupList) {
                TreeNode copyRoot = deepCopyRoot(treeNodeTemp);
                nodes.add(copyRoot);
            }
            treeNode.groupList = nodes;

        }
        return treeNode;
    }

}
