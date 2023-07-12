console.log("====== Rest ======");

function myBio(firstName, lastName, ...otherInfo) {
  return otherInfo;
}

// Invoke myBio function while passing five arguments to its parameters:
console.log(myBio("Oluwatobi", "Sofela", "CodeSweetly", "Web Developer", "Male"));

console.log();

console.log("====== Spread ======");

function myNewBio(firstName, lastName, otherInfo) {
    return firstName + " " + lastName + " " + otherInfo;
  }
  
  // Invoke myBio function while passing five arguments to its parameters:
  console.log(myNewBio(...["Oluwatobi", "Sofela", "CodeSweetly", "Web Developer", "Male"]));