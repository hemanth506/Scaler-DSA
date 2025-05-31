import { Transaction } from "../dtos/Transaction";
import { User } from "./User";
import Heap from "heap-js";

export interface SettleUpStrategy {
  settleUpUsers(map: Map<User, number>): Transaction[]
}

export class HeapSettleUp implements SettleUpStrategy {
    settleUpUsers(map: Map<User, number>): Transaction[] {
        const maxAmountComparator = (a: [User, number], b: [User, number]) => b[1] - a[1];
        const receiverHeap = new Heap(maxAmountComparator);
        const giverHeap = new Heap(maxAmountComparator);

        let totalReceiverAmount = 0;
        let totalGiverAmount = 0;
        for (const [key, value] of map) {
            if (value > 0) {
                receiverHeap.push([key, value])
                totalReceiverAmount += value
            } else {
                giverHeap.push([key, value * -1])
                totalGiverAmount += value
            }
        }

        let transactions: Transaction[] = []
        if ((totalReceiverAmount + totalGiverAmount) === 0) {
            while (receiverHeap.size() > 0 && giverHeap.size() > 0) {
                const receiver = receiverHeap.pop()
                const giver = giverHeap.pop()

                if (receiver && giver) {
                    const amountSettled = (receiver[1] - giver[1])

                    if(amountSettled >= 0) {
                        transactions.push(new Transaction(giver[0], receiver[0], giver[1]));
                    }

                    if (amountSettled > 0) {
                        receiverHeap.push([receiver[0], amountSettled])
                    } else if (amountSettled < 0) {
                        transactions.push(new Transaction(giver[0], receiver[0], receiver[1]));
                        giverHeap.push([giver[0], amountSettled])
                    }
                }
            }
        } else {
            throw new Error("Amount not tallied..!")
        }
        return transactions
    }

    settleUps(map: Map<string, number>): Transaction[] {
        const maxAmountComparator = (a: [string, number], b: [string, number]) => b[1] - a[1];
        const receiverHeap = new Heap(maxAmountComparator);
        const giverHeap = new Heap(maxAmountComparator);

        let totalReceiverAmount = 0;
        let totalGiverAmount = 0;
        for (const [key, value] of map) {
            if (value > 0) {
                receiverHeap.push([key, value])
                totalReceiverAmount += value
            } else {
                giverHeap.push([key, value * -1])
                totalGiverAmount += value
            }
        }

        let transactions: Transaction[] = []
        if ((totalReceiverAmount + totalGiverAmount) === 0) {
            while (receiverHeap.size() > 0 && giverHeap.size() > 0) {
                const receiver = receiverHeap.pop()
                const giver = giverHeap.pop()

                if (receiver && giver) {
                    const amountSettled = (receiver[1] - giver[1])
                    // transactions.push(new Transaction(giver[0], receiver[0], giver[1]));
                    
                    if(amountSettled >= 0) {
                        console.log(giver[0], ' => ', receiver[0], ' :: ', giver[1])
                    } else {
                        console.log(giver[0], ' => ', receiver[0], ' :: ', receiver[1])
                    }
                    if (amountSettled > 0) {
                        receiverHeap.push([receiver[0], amountSettled])
                    } else if (amountSettled < 0) {
                        giverHeap.push([giver[0], amountSettled*-1])
                    }
                }
            }
        } else {
            throw new Error("Amount not tallied..!")
        }
        console.log('transactions', transactions)
        return transactions
    }

}