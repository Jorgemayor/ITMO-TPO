package task2;

import comp.task2.SplayTree;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SplayTreeTest {

    @Test
    @DisplayName("Check empty")
    void checkEmpty() {
        assertEquals("", SplayTree.getTree(null));
    }

    @Test
    @DisplayName("Check zeros")
    void checkZeros() {
        assertEquals("0\n", SplayTree.getTree(null, new int[]{0,0,0,0}));
    }

    @Test
    @DisplayName("Check positive values")
    void checkPositiveValues() {
        assertAll(
                () -> assertEquals("3\n4\n5\n33\n", SplayTree.getTree(null, new int[]{33, 3, 4, 5})),
                () -> assertEquals("1\n3\n4\n7\n9\n", SplayTree.getTree(null, new int[]{4,1,3,9,7})),
                () -> assertEquals("1\n2\n3\n4\n5\n6\n7\n8\n9\n10\n", SplayTree.getTree(null, new int[]{10,9,8,7,6,5,4,3,2,1})),
                () -> assertEquals("2\n3\n5\n8\n13\n", SplayTree.getTree(null, new int[]{13, 5, 2, 8, 3})),
                () -> assertEquals("10\n20\n30\n40\n50\n", SplayTree.getTree(null, new int[]{50, 10, 30, 40, 20})),
                () -> assertEquals("100\n200\n300\n400\n500\n600\n", SplayTree.getTree(null, new int[]{400, 600, 100, 500, 200, 300})),
                () -> assertEquals("1\n2\n4\n8\n16\n32\n", SplayTree.getTree(null, new int[]{16, 1, 8, 32, 4, 2})),
                () -> assertEquals("3\n6\n9\n12\n15\n18\n21\n", SplayTree.getTree(null, new int[]{9, 15, 3, 12, 18, 6, 21})),
                () -> assertEquals("22\n28\n30\n82\n159\n166\n287\n289\n338\n365\n371\n444\n451\n520\n527\n567\n623\n676\n714\n719\n741\n771\n783\n818\n874\n884\n914\n960\n970\n983\n",
                        SplayTree.getTree(null, new int[]{444, 520, 166, 874, 676, 22, 338, 783, 365, 970, 623, 30, 287, 451, 914, 371, 741, 818, 527, 714, 166, 159, 960, 289, 567, 82, 771, 983, 719, 884, 28}))
        );
    }

    @Test
    @DisplayName("Check negative values")
    void checkNegativeValues() {
        assertAll(
                () -> assertEquals("-3\n-2\n-1\n", SplayTree.getTree(null, new int[]{-1, -3, -2})),
                () -> assertEquals("-50\n-40\n-30\n-20\n-10\n", SplayTree.getTree(null, new int[]{-50, -10, -30, -40, -20})),
                () -> assertEquals("-600\n-500\n-400\n-300\n-200\n-100\n", SplayTree.getTree(null, new int[]{-400, -600, -100, -500, -200, -300})),
                () -> assertEquals("-32\n-16\n-8\n-4\n-2\n-1\n", SplayTree.getTree(null, new int[]{-16, -1, -8, -32, -4, -2})),
                () -> assertEquals("-21\n-18\n-15\n-12\n-9\n-6\n-3\n", SplayTree.getTree(null, new int[]{-9, -15, -3, -12, -18, -6, -21}))
        );
    }

    @Test
    @DisplayName("Check values")
    void checkValues() {
        assertAll(
                () -> assertEquals("-3\n-2\n1\n2\n3\n", SplayTree.getTree(null, new int[]{1, -3, 2, -2, 3})),
                () -> assertEquals("-10\n-5\n-2\n1\n5\n10\n", SplayTree.getTree(null, new int[]{10, -5, 1, -2, 5, -10})),
                () -> assertEquals("-100\n-50\n-20\n10\n50\n100\n", SplayTree.getTree(null, new int[]{100, -50, 10, -20, 50, -100})),
                () -> assertEquals("-32\n-4\n-2\n-1\n5\n8\n16\n", SplayTree.getTree(null, new int[]{16, -1, 8, -32, 5, -4, -2})),
                () -> assertEquals("-9\n-6\n-3\n1\n3\n6\n9\n", SplayTree.getTree(null, new int[]{9, -6, 3, -3, 1, -9, 6}))
        );
    }
}
