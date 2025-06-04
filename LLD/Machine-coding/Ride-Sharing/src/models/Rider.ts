import { Gender } from "../../helper/enums"
import { GlobalClass } from "./GlobalClass"

export class Rider extends GlobalClass {
    name: string
    email: string
    password: string
    gender: Gender
    constructor(name: string, email: string, password: string, gender: Gender) {
        super()
        this.name = name
        this.email = email
        this.password = password
        this.gender = gender
    }
}