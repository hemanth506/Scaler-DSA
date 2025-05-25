export class GlobalClass {
    _id: string
    

    constructor(id: string) {
        this._id = id
    }

    public setId(id: string) {
        this._id = id
    }

    public getId() {
        return this._id
    }
}


export class BaseClass extends GlobalClass {
    _name: string

    constructor(id: string, name: string) {
        super(id)
        this._name = name
    }

    public setName(name: string) {
        this._name = name
    }

    public getName() {
        return this._name
    }
}