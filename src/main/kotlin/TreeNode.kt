class TreeNode(val value: Int, var left: TreeNode? = null, var right: TreeNode? = null){
    /**
     * searching a binary search tree
     * @param searchValue
     * @param node
     * @return [Int]
     */
    fun searchTree(searchValue: Int, node: TreeNode) : Int {
        // Base case
        if (node.value == searchValue) {
            return node.value
        }

        val result: Int? = if (searchValue < node.value) {
            node.left?.let { searchTree(searchValue, it) }
        } else {
            node.right?.let{ searchTree(searchValue, it) }
        }
        return result ?: 0
    }

    /**
     * inserting into a binary search tree
     * @param value
     * @param node
     * @return [Unit]
     */
    fun insertNode(value: Int, node: TreeNode) {
        if (value < node.value) {

            if (node.left != null) {
                node.left = TreeNode(value)
            } else {
               node.left?.let { insertNode(value, it) }
            }
        }
        else {
            if (node.right != null) {
                node.right = TreeNode(value)
            } else {
                node?.right?.let { insertNode(value, it) }
            }
        }
    }
}

/**
 * traversing a tree
 * @param node
 */
fun traverseAndPrintNode(node: TreeNode) {
    if (node == null) {
        return
    }
    traverseAndPrintNode(node.left!!)
    print(node.value)
    traverseAndPrintNode(node.right!!)
}

fun main() {
    val node1 = TreeNode(25)
}
