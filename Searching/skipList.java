public class skipList {
    public static class Node{
        int node;
        Node next[];   // Array to store the pointer of next node at same level of different ele

        Node(int node, int level){
            this.node = node;
            next = new Node[level+1];
        }
    }

    public static class SkipList{
        Node head;
        int maxLvl;
        int lvl;
        float prob;     

        SkipList(int maxLvl, float prob){
            this.maxLvl = maxLvl;
            this.prob = prob;
            lvl = 0;
            head = new Node(-1, maxLvl);
        }

        int generateLevel(){
            float rand = (float)Math.random();
            int lvl = 0;
            while(rand<prob && lvl<maxLvl){
                lvl++;
                rand = (float)Math.random();
            }
            return lvl;
        }

        Node creatNode(int node, int level){
            Node n = new Node(node, level);
            return n;
        }

        void insertElement(int ele){
            Node curr = head;
            Node update[] = new Node[maxLvl + 1];

            /* start from highest level of skip list move the current pointer forward while ele is greater than element of node next to current 
            Otherwise insert current in update and move one level down and continue search */
            for(int i=lvl; i>=0; i--){
                while(curr.next[i]!=null && curr.next[i].node<ele){
                    curr = curr.next[i];
                }
                update[i] = curr;
            }
            curr = curr.next[0];

            /* if current is NULL that means we have reached to end of the level or current's ele is not equal to ele to insert that means we have to insert node between 
            update[0] and current node */
            if(curr==null || curr.node!=ele){
                int level = generateLevel();

                if(level > lvl){
                    for(int i=lvl+1; i<level+1; i++){
                        update[i] = head;
                    }
                    lvl = level;
                }
                Node n = creatNode(ele, level);

                // insert node by rearranging pointers
                for(int i=0; i<=level; i++){
                    n.next[i] = update[i].next[i];
                    update[i].next[i] = n;
                }
                System.out.println("Successfully inserted => " + ele);
            }
        }

        void search(int ele){
            Node curr = head.next[0];
            while(curr!=null){
                if(curr.node==ele){
                    System.out.println("Found => " + ele);
                    return;
                }
                curr = curr.next[0];
            }
            System.out.println("Not found => " + ele);
        }

        void display(){
            for(int i=0; i<=lvl; i++){
                Node node = head.next[i];
                System.out.print("Level " + i + ": ");

                while(node!=null){
                    System.out.print(node.node + " ");
                    node = node.next[i];
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        SkipList lst = new SkipList(5, 0.6f);

        lst.insertElement(5);
        lst.insertElement(7);
        lst.insertElement(9);
        lst.insertElement(1);
        lst.insertElement(3);
        lst.insertElement(6);
        lst.insertElement(8);
        lst.insertElement(2);
        lst.insertElement(4);
        lst.insertElement(6);
        System.out.println();
        
        lst.display();
        System.out.println();

        lst.search(7);
        lst.search(9);
        lst.search(10);
        System.out.println();

    }
}

/* 
output
Successfully inserted => 5
Successfully inserted => 7
Successfully inserted => 9
Successfully inserted => 1
Successfully inserted => 3
Successfully inserted => 6
Successfully inserted => 8
Successfully inserted => 2
Successfully inserted => 4

Level 0: 1 2 3 4 5 6 7 8 9 
Level 1: 1 2 3 8 
Level 2: 1 2 3 8 
Level 3: 1 2 8 
Level 4: 1 8 
Level 5: 1 8

Found => 7
Found => 9
Not found => 10
*/
