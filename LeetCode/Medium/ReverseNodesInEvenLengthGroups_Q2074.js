// Linked list

function ListNode(val, next) {
    this.val = val === undefined ? 0 : val;
    this.next = next === undefined ? null : next;
}
var reverseEvenLengthGroups = function (head) {
    const temp_h = head;
    function iterate() {
        let route_head = temp_h;
        let output = ""; // Accumulate the values here

        while (route_head != null) {
            output += route_head.val + " ";
            route_head = route_head.next;
        }

        console.log(output.trim()); // Print once after the loop
        console.log("-------------");
    }
    function reverse(prev_th, th, prev_t, t) {
        let dt = null;
        let rth = th;
        while (rth != t) {
            let ref = rth.next;
            rth.next = dt;
            dt = rth;
            rth = ref;
        }
        prev_th.next = prev_t;
        th.next = t;
    }
    iterate();
    let prev_th = temp_h;
    let th = head.next;
    let group = 2;
    while (th != null) {
        let ct = 1;
        let t = th;
        let prev_t = t;
        while (t !== null && ct <= group) {
            prev_t = t;
            t = t.next;
            ct += 1;
        }
        if ((ct - 1) % 2 === 0) {
            reverse(prev_th, th, prev_t, t);
            prev_th = th;
            th = th.next;
        } else {
            prev_th = prev_t;
            th = t;
        }
        group += 1;
    }

    iterate();

    return temp_h;
};

let head;

// head = [5, 2, 6, 3, 9, 1, 7, 3, 8, 4];
// head = [1,1,0,6]
head = [1,1,0,6,5]
function createLLAndReturnHead(head) {
    const headNode = new ListNode(head[0]);
    let hn = headNode;
    for (let i = 1; i < head.length; i++) {
        let node = new ListNode(head[i]);
        hn.next = node;
        hn = node;
    }
    return headNode;
}

const primary = createLLAndReturnHead(head);
reverseEvenLengthGroups(primary);
