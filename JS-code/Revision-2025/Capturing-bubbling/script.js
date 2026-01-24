const grandParent = document.getElementById("grandparent");
const parent = document.getElementById("parent");
const child = document.getElementById("child");

grandParent.addEventListener("click", () => {
  console.log("grandparent clicked")
})

parent.addEventListener("click", () => {
  console.log("parent clicked")
})

child.addEventListener("click", (event) => {
  console.log("child clicked") 
  // event.stopPropagation()
})

grandParent.addEventListener("click", () => {
  console.log("grandparent capturing clicked")
}, true)

parent.addEventListener("click", () => {
  console.log("parent capturing clicked")
}, true)

child.addEventListener("click", (event) => {
  console.log("child capturing clicked")
}, true)


/*

Capturing Phase = true
Bubbling Phase = false (default)

|------------------------| <- Root (Window)
|    |------------------| <- Capturing Phase
|    |   |--------------| <- Capturing Phase
|    |   |   |  Target  | <- Capturing Phase
|    |   |--------------| <- Bubbling Phase
|    |------------------| <- Bubbling Phase
|------------------------| <- Bubbling Phase

*/