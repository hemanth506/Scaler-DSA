export class User {
    name: string
    phoneNumber: string
    password: string

    constructor(name: string, phoneNumber: string, password: string) {  
        this.name = name
        this.phoneNumber = phoneNumber
        this.password = password
    }

    getName() {
        return this.name
    }

    setName(name: string) {
        this.name = name
    }

    getPhoneNumber() {
        return this.phoneNumber
    }

    setPhoneNumber(phNo: string) {
        this.phoneNumber = phNo
    }

    getPassword() {
        return this.password
    }

    setPassword(password: string) {
        this.password = password
    }
}