let intervalId = setInterval(() => {
    console.log("This plays for every 2 seconds");
}, 2000);

setTimeout(() => {
    console.log("This is played after 11 seconds");
    clearInterval(intervalId);
    console.log("The interval is cleard");

}, 11000);
