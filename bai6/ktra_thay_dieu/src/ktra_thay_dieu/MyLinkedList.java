package ktra_thay_dieu;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class MyLinkedList {
    Node head;
    Scanner sc = new Scanner(System.in);

    MyLinkedList() {
        head = null;
    }

    //nhap danh sach
    void nhapsd() {
        int x;
        Node cuoi = null;
        head = null;
        while (true) {
            System.out.println("Nhap x:");
            x = sc.nextInt();
            if (x == 0) {
                break;
            }
            Node t = new Node(x);
            if (head == null) {
                head = cuoi = t;
            } else {
                cuoi.next = t;
                cuoi = t;
            }
        }
    }

    // in danh sach
    void in() {
        System.out.println("\n Noi dung cua danh sach :==>");
        Node p = head;
        while (p != null) {
            System.out.println(p);
            p = p.next;
        }
        System.out.println("null \n");
    }

    // xoa vi tri K
    void remove(int k) {
        if (k < 1 || head == null) {
            System.out.println("khong xoa duoc:");
        } else if (k == 1) {
            head = head.next;
        } else {
            int vt = 1;
            Node p = head;
            while (p != null && vt < k - 1) {
                vt++;
                p = p.next;
            }
            if (p == null || p.next == null) {
                System.out.println("\n vi tri xoa khong hop le !");
            } else {
                p.next = p.next.next;
            }
        }
    }

    //sap xep
    public void sort() {
        for (Node i = head; i.next != null; i = i.next) {
            for (Node j = i.next; j != null; j = j.next) {
                if (i.data > j.data) {
                    int tmp = i.data;
                    i.data = j.data;
                    j.data = tmp;
                }
            }
        }
    }

    // chen
    void insert(int x, int k) {
        if (k < 1) {
            System.out.println("vi tri chen khong hop le ");
        } else if (k == 1) {
            head = new Node(x, head);
        } else {
            int vt = 1;
            Node p = head;
            while (p != null && vt < k - 1) {
                vt++;
                p = p.next;
            }
            if (p == null) {
                System.out.println("vi tri chen khong hop le");
            } else {
                Node t = new Node(x, p.next);
                p.next = t;
            }
        }
    }

    // dao
    void dao() {
        Node t = null;
        Node p = head;
        while (p != null) {
            Node q = p.next;
            p.next = t;
            t = p;
            p = q;
        }
        head = t;
    }

    //tinh tong cac not le
    int tongLe() {
        int k = 0;
        Node p = head;
        while (p != null) {
            if (p.data % 2 != 0) {
                k = k + p.data;
            }
            p = p.next;
        }
        return k;
    }

    // trung binh cong cac so chan
    int tongTrungBinhSoChan() {
        int k = 0;
        int n = 0;
        Node p = head;
        while (p != null) {
            if (p.data % 2 == 0) {
                n++;
                k = k + p.data;
            }
            p = p.next;
        }
        return k / n;
    }

    //dem so phan tu lon hon 3 trong danh sach
    int demLonHon3() {
        int n = 0;
        Node p = head;
        while (p != null) {
            if (p.data > 3)
                n++;
            p = p.next;
        }
        return n;
    }

    //dem so phan tu khac nhau trong danh sach
    int demPhanTuKhac() {
        int count = 0;
        Node p = head;
        while (p != null) {
            boolean isDistinct = false;
            Node temp = p.next;
            while (temp != null) {
                if (p.data == temp.data) {
                    isDistinct = true;
                    break;
                }
                temp = temp.next;
            }
            if (!isDistinct) {
                count++;
            }
            p = p.next;
        }
        return count;
    }

    //hoan vi phan tu dau va cuoi cua danh sach
    Node hoanvi_daucuoi(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node prev = null;
        Node p = head;
        while (p.next != null) {
            prev = p;
            p = p.next;
        }

        p.next = head.next;
        prev.next = head;
        head.next = null;

        return p;
    }

    void hvi_DauCuoi() {
        Node temp = hoanvi_daucuoi(head);
        System.out.print("\n Noi dung danh sach:\n===>");
        while (temp != null) {
            System.out.println(temp);
            temp = temp.next;
        }
        System.out.print("null \n");
    }

    void addNode(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    void doc_file() {
        String filePath = "D:\\bai6\\ktra_thay_dieu\\src\\ktra_thay_dieu\\solieu.txt";
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            int n = Integer.parseInt(scanner.nextLine());
            String[] numbers = scanner.nextLine().split(" ");

            for (int i = 0; i < n; i++) {
                int value = Integer.parseInt(numbers[i]);
                addNode(value);
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("File not found.");
        }
    }
    public static void main(String[] args) throws Exception {
        MyLinkedList p = new MyLinkedList();
//        p.nhapsd();
//        p.in();
//		System.out.println("sap xep");
//		p.sort();
//		p.in();
//		System.out.println("xoa so vi tri  5");
//		p.remove(5);
//		p.in();
//		System.out.println("dao");
//		p.dao();
//		p.in();
//		System.out.println("chen vi tri ");
//		p.insert(99,5);
//		p.in();
//        System.out.println("Tong cac not le :" + p.tongLe());
//		System.out.println("Trung binh cong cac so chan:"+p.tongTrungBinhSoChan());
//		System.out.println("Cac not lon hon 3: "+p.demLonHon3());
//		System.out.println("cac so khac:"+p.demPhanTuKhac());
//		p.dao();
//		System.out.println("danh sach dao");
//		p.in();
        p.doc_file();
        p.in();
        System.out.println("Tong cac not le :" + p.tongLe());
//        System.out.println("hoan vi");
//        p.hvi_DauCuoi();
//        p.in();
    }
}
