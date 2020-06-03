class Solution {
    public void deleteNode(ListNode node) {
        
        ListNode prev=null;
        if(node.next==null){
            node=null;
        }
        while(node!=null && node.next!=null){
            node.val=node.next.val;
            prev=node;
            node=node.next;
        }
        prev.next=null;
        }
    }
