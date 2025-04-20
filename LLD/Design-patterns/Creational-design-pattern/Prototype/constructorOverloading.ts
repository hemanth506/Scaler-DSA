/*

*/

// constructor overloading
class NewStudent {
    name?: string
    age?: number
    email?: string
    bloodGroup?: string
    city?: string
    state?: string
    country?: string

    constructor(); // acts like an abstract

    constructor(st: NewStudent); // acts like an abstract

    constructor(st: NewStudent, name: string); // acts like an abstract

    // this is the actual constructor which can handle with or with out arguments
    constructor(st?: NewStudent, name?: string) {
        if(st) {
            this.age = st.age
            this.bloodGroup = st.bloodGroup
            this.city = st.city
            this.country = st.country
            this.email = st.email
            this.name = st.name
            this.state = st.state
        }

        if(name) {
            this.name = name + "" + this.name
        }
    }

}


let st = new NewStudent();
st.age = 27
st.bloodGroup = "O+ve"
st.city = "Chennai"
st.country = "India"
st.email = "hemanth@gmail.com"
st.name = " Hemanth"
st.state = "TN"

let st2 = new NewStudent(st, "Ruchika");
console.log(st);
console.log(st2);