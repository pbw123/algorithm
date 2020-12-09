package main;

public class LinkedTest {

    public static void main(String[] args) {
        Linked<Integer> linked = new Linked<>();
        linked.add(3);
        linked.add(1);
        linked.add(6);
        linked.addLast(9);
        linked.add(2, 2);
        System.out.println(linked.toString());
        System.out.println(linked.getSize());
        System.out.println("----------------");
//        linked.removeFirst();
//        linked.removeFirst();
//        linked.remove();
//        linked.remove(5);

//        System.out.println(linked.toString());
//        System.out.println(linked.getSize());
//        linked.reset();
//        System.out.println(linked.isContain(0));
//        System.out.println(
//        linked.isEmpty());
//        linked.addBeforeNode(99,6);
//        linked.addBeforeNode(8,9);
//        linked.addBeforeNode(2,3);
//        linked.addBeforeNode2(99,6);
//        linked.addBeforeNode2(8,9);
//        linked.addBeforeNode2(2,3);
//        System.out.println(linked.toString());
//        System.out.println(linked.getSize());
        System.out.println(linked.get(4));

    }
}
