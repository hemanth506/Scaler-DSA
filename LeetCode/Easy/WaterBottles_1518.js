var numWaterBottles = function(numBottles, numExchange) {
    let db = numBottles
    let totalDbs = db 

    while (db >= numExchange) {
        console.log('db', db)
        let newFilledBottle = Math.floor(db / numExchange)
        let existingEmptyBottle = Math.floor(db % numExchange)
        db = newFilledBottle + existingEmptyBottle
        totalDbs += newFilledBottle
    }

    console.log(totalDbs)
    return totalDbs
};


numWaterBottles(15, 4)